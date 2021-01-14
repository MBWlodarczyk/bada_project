package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Czesc;
import net.codejava.badabida.model.CzesciZamowienia;
import net.codejava.badabida.model.Klient;
import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.CzesciZamowieniaRepository;
import net.codejava.badabida.repos.KlientRepository;
import net.codejava.badabida.repos.ZamowieniaRepository;
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

    public SessionController(CzescRepository czescRepository, KlientRepository klientRepository, ZamowieniaRepository zamowieniaRepository, CzesciZamowieniaRepository czesciZamowieniaRepository) {
        this.czescRepository = czescRepository;
        this.klientRepository = klientRepository;
        this.zamowieniaRepository = zamowieniaRepository;
        this.czesciZamowieniaRepository = czesciZamowieniaRepository;
    }

    @PostMapping("/client/cart/add/{nrCzesci}")
    public String addToCart(@PathVariable("nrCzesci") Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();

        if (session.getAttribute("cart") == null) {
            HashMap<Czesc, Integer> cart = new HashMap<>();
            cart.put(czesc, quantity);
            session.setAttribute("cart", cart);
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            List<Czesc> list = new ArrayList<>(cart.keySet()); //k ,v
            if (contain(list, czesc)) {
                for (Czesc c : list) {
                    if (c.getNrCzesci().equals(nrCzesci)) {
                        Integer oldQuantity = cart.get(c);
                        cart.remove(c);
                        cart.put(czesc, quantity + oldQuantity);
                        break;
                    }
                }
            } else {
                cart.put(czesc, cart.containsKey(czesc) ? cart.get(czesc) + quantity : quantity);
            }
        }
        calculateTheSum(session);
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
    public String removeFromCart(@PathVariable("nrCzesci")Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();

        if (session.getAttribute("cart") == null) {
            return "redirect:/client/store";
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            List<Czesc> list = new ArrayList<>(cart.keySet());  //k ,v
            if (contain(list,czesc)) {
                for (Czesc c : list) {
                    if (c.getNrCzesci().equals(nrCzesci)) {
                        Integer oldQuantity = cart.get(c);
                        if (oldQuantity - quantity <= 0) {
                            cart.remove(c);
                        } else {
                            cart.remove(c);
                            cart.put(czesc, oldQuantity - quantity);
                        }
                        break;
                    }
                }
                //TODO naprawic ten brzydki kod
                calculateTheSum(session);
                if(cart.size() == 0){
                    session.setAttribute("cart",null);
                }
            } else {
                return "redirect:/client/store";
            }
            if(cart.size() == 0){
                session.setAttribute("cart",null);
            }
        }
        calculateTheSum(session);
        return "redirect:/client/store";
    }

    public String calculateTheSum(HttpSession session) {
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
    public String submitCart(HttpSession session, Authentication auth){

        Zamowienie zamowienie = new Zamowienie();

        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Klient klient = klientRepository.findByUsername(username).get();
        Set<Klient> klienci = new HashSet<>();
        klienci.add(klient);
        zamowienie.setKlienci(klienci);

        zamowienie.setStatusZamowienia("zlozone");

        zamowienie.setDataZlozenia(new Date(Calendar.getInstance().getTime().getTime()));

        zamowienie = zamowieniaRepository.saveAndFlush(zamowienie);
        klient.getZamowienia().add(zamowienie);

        List<CzesciZamowienia> czesci = new ArrayList<>();


        HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");



        for( Czesc c: cart.keySet()){
            CzesciZamowienia link = new CzesciZamowienia(c,zamowienie,cart.get(c));
            czesci.add(link);
        }

        czesciZamowieniaRepository.saveAll(czesci);

        zamowienie.setCzesci(czesci);

        session.setAttribute("cart",null);


        return "redirect:/client/orders";
    }
}

