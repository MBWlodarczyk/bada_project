package net.codejava.badabida.controllers;

import net.codejava.badabida.model.CzesciZamowienia;
import net.codejava.badabida.model.Klient;
import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.KlientRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;


@Controller
public class KlientController {

    private final KlientRepository klientRepository;
    private final CzescRepository czescRepository;

    public KlientController(KlientRepository klientRepository, CzescRepository czescRepository) {
        this.klientRepository = klientRepository;
        this.czescRepository = czescRepository;
    }

    @GetMapping("/client/home")
    public String getClientHome() {
        return "client/home";
    }

    @GetMapping("/client/login")
    public String getClientLogin() {
        return "client/login";
    }


    @GetMapping("/client/personaldata")
    public String getClientInfo(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("klient", klientRepository.findByUsername(principal.getUsername()).get());
        return "client/personaldata";
    }

    @PostMapping("/client/personaldata/update/{nrKlienta}")
    public String updateUser(@PathVariable("nrKlienta") Long nrKlienta, Klient newKlient, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Klient oldKlient = klientRepository.findByUsername(principal.getUsername()).get();

        if (oldKlient.getNrKlienta().equals(nrKlienta)) {

            oldKlient.setImie(newKlient.getImie());
            oldKlient.setNazwisko(newKlient.getNazwisko());
            oldKlient.setTelefon(newKlient.getTelefon());

            oldKlient.getAdres().setKodPoczty(newKlient.getAdres().getKodPoczty());
            oldKlient.getAdres().setMiasto(newKlient.getAdres().getMiasto());
            oldKlient.getAdres().setNrLokalu(newKlient.getAdres().getNrLokalu());
            oldKlient.getAdres().setPoczta(newKlient.getAdres().getPoczta());
            oldKlient.getAdres().setUlica(newKlient.getAdres().getUlica());


            klientRepository.saveAndFlush(oldKlient);
        } else {
            return "redirect:/403";
        }
        return "redirect:/client/personaldata";
    }

    @GetMapping("client/orders")
    public String getUserZamowienia(Model model, Authentication auth) {
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Set<Zamowienie> zamowienieSet = klientRepository.findByUsername(username).get().getZamowienia();
        model.addAttribute("zamowienia", zamowienieSet);

        HashMap<Long, BigDecimal> totalPrice = new HashMap<>();
        BigDecimal sum;
        for (Zamowienie z : zamowienieSet) {
            sum = new BigDecimal(0);
            for (CzesciZamowienia cz : z.getCzesci()) {
                sum = sum.add(cz.getCzesc().getCena().multiply(new BigDecimal(cz.getIlosc())));
            }
            totalPrice.put(z.getNrZamowienia(), sum);
        }
        model.addAttribute("totalPrice", totalPrice);

        return "client/orders";
    }

    @GetMapping("/client/store/item/{nrCzesci}")
    public String getItemInfo(@PathVariable("nrCzesci") Long nrCzesci, Model model) {
        model.addAttribute("czesc", czescRepository.findCzescByNrCzesci(nrCzesci));
        return "client/item";
    }

    @GetMapping("/client/store")
    public String getItemInfo(Model model) {
        model.addAttribute("czesci", czescRepository.findAll());
        return "client/store";
    }
}

