package net.codejava.badabida.controllers;

import net.codejava.badabida.model.*;
import net.codejava.badabida.repos.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;


@Controller
public class SessionController {

    private final CzescRepository czescRepository;
    private final KlientRepository klientRepository;
    private final ZamowieniaRepository zamowieniaRepository;
    private final CzesciZamowieniaRepository czesciZamowieniaRepository;
    private final PracownikRepository pracownikRepository;
    private final AdresRepository adresRepository;

    public SessionController(CzescRepository czescRepository, KlientRepository klientRepository, ZamowieniaRepository zamowieniaRepository, CzesciZamowieniaRepository czesciZamowieniaRepository, PracownikRepository pracownikRepository, AdresRepository adresRepository) {
        this.czescRepository = czescRepository;
        this.klientRepository = klientRepository;
        this.zamowieniaRepository = zamowieniaRepository;
        this.czesciZamowieniaRepository = czesciZamowieniaRepository;
        this.pracownikRepository = pracownikRepository;
        this.adresRepository = adresRepository;
    }

    @PostMapping("/client/cart/add/{nrCzesci}")
    public String addToCart(@PathVariable("nrCzesci") Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();
        if (quantity > 0) {
            if (session.getAttribute("cart") == null) {
                HashMap<Czesc, Integer> cart = new HashMap<>();
                cart.put(czesc, quantity);
                session.setAttribute("cart", cart);
            } else {
                HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
                if (cart.containsKey(czesc)) {
                    Integer oldQuantity = cart.get(czesc);
                    cart.remove(czesc);
                    cart.put(czesc, quantity + oldQuantity);
                } else {
                    cart.put(czesc, cart.containsKey(czesc) ? cart.get(czesc) + quantity : quantity);
                }
            }
            calculateTheSum(session);
        }
        return "redirect:/client/store";
    }

    private boolean contain(List<Czesc> list, Czesc czesc) {
        for (Czesc c : list) {
            if (c.getNrCzesci().equals(czesc.getNrCzesci()))
                return true;
        }
        return false;
    }


    @PostMapping("/client/cart/remove/{nrCzesci}")
    public String removeFromCart(@PathVariable("nrCzesci") Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();
        if (session.getAttribute("cart") == null || quantity < 0) {
            return "redirect:/client/store";
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            if (cart.containsKey(czesc)) {
                Integer oldQuantity = cart.get(czesc);
                if (oldQuantity - quantity <= 0) {
                    cart.remove(czesc);
                } else {
                    cart.remove(czesc);
                    cart.put(czesc, oldQuantity - quantity);
                }
                checkEmpty(cart, session);
                calculateTheSum(session);
            } else {
                return "redirect:/client/store";
            }
        }
        calculateTheSum(session);
        return "redirect:/client/store";
    }

    private void checkEmpty(HashMap<Czesc, Integer> cart, HttpSession session) {
        if (cart.size() == 0) {
            session.setAttribute("cart", null);
        }
    }


    private String calculateTheSum(HttpSession session) {
        BigDecimal amount = new BigDecimal("0");
        if (session.getAttribute("cart") == null) {
            session.setAttribute("amount", amount);
            return "redirect:/client/store";
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            List<Czesc> list = new ArrayList<>(cart.keySet());
            for (Czesc c : list) {
                amount = amount.add(c.getCena().multiply(new BigDecimal(cart.get(c))));
            }
            session.setAttribute("amount", amount);
        }
        return "redirect:/client/store";
    }

    @Transactional
    @PostMapping("/client/cart/submit")
    public String submitCart(HttpSession session, Authentication auth) {

        Zamowienie zamowienie = new Zamowienie();

        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Klient klient = klientRepository.findByUsername(username).get();
        Adres adres = klient.getAdres();

        Adres newAdres = new Adres();

        newAdres.setUlica(adres.getUlica());
        newAdres.setPoczta(adres.getPoczta());
        newAdres.setNrLokalu(adres.getNrLokalu());
        newAdres.setMiasto(adres.getMiasto());
        newAdres.setKodPoczty(adres.getKodPoczty());


        adres = adresRepository.save(newAdres);
        Set<Klient> klienci = new HashSet<>();
        klienci.add(klient);
        zamowienie.setKlienci(klienci);
        zamowienie.setAdres(adres);
        zamowienie.setStatusZamowienia("zlozone");

        List<Pracownik> pracownicy = pracownikRepository.findAllByStanowisko("magazyn");

        int size = pracownicy.size();
        int item = new Random().nextInt(size);



        zamowienie.setDataZlozenia(new Date(Calendar.getInstance().getTime().getTime()));

        zamowienie = zamowieniaRepository.saveAndFlush(zamowienie);

        pracownicy.get(item).getZamowienia().add(zamowienie);

        klient.getZamowienia().add(zamowienie);

        List<CzesciZamowienia> czesci = new ArrayList<>();


        HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");


        for (Czesc c : cart.keySet()) {
            CzesciZamowienia link = new CzesciZamowienia(c, zamowienie, cart.get(c));
            czesci.add(link);
        }

        czesciZamowieniaRepository.saveAll(czesci);

        zamowienie.setCzesci(czesci);

        session.setAttribute("cart", null);


        return "redirect:/client/orders";
    }

}

