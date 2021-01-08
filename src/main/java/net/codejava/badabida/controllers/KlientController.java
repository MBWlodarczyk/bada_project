package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Klient;
import net.codejava.badabida.repos.AdresRepository;
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


@Controller
public class KlientController {

    private final AdresRepository adresRepository;
    private final KlientRepository klientRepository;
    private final CzescRepository czescRepository;

    public KlientController(AdresRepository adresRepository, KlientRepository klientRepository, CzescRepository czescRepository) {
        this.adresRepository = adresRepository;
        this.klientRepository = klientRepository;
        this.czescRepository = czescRepository;
    }


    @GetMapping("/")
    public String getHome(){
        return "client/home";
    }

    @GetMapping("/client/home")
    public String getClientHome(){
        return "client/home";
    }

    @GetMapping("/client/login")
    public String getClientLogin(){
        return "client/login";
    }


    @GetMapping("client/zamowienia")
    public String getUserZamowienia(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("zamowienia", klientRepository.findByUsername(username).get().getZamowienia());
        }
        return "client/zamowienia";
    }

    @GetMapping("/client/dane")
    public String getClientInfo(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("klient", klientRepository.findByUsername(principal.getUsername()).get());
        return "client/dane";
    }

    @GetMapping("/client/store/item/{nrCzesci}")
    public String getItemInfo(@PathVariable("nrCzesci") Long nrCzesci ,Model model) {
        model.addAttribute("czesc",czescRepository.findCzescByNrCzesci(nrCzesci));
        return "client/item";
    }

    @GetMapping("/client/store")
    public String getItemInfo(Model model) {
        model.addAttribute("czesci",czescRepository.findAll());
        return "client/store";
    }

    @PostMapping("/client/dane/update/{nrKlienta}")
    public String updateUser(@PathVariable("nrKlienta") Long nrKlienta, Klient newKlient, Model model, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Klient oldKlient = klientRepository.findByUsername(principal.getUsername()).get();

        oldKlient.setImie(newKlient.getImie());
        oldKlient.setNazwisko(newKlient.getNazwisko());
        oldKlient.setTelefon(newKlient.getTelefon());

        oldKlient.getAdres().setKodPoczty(newKlient.getAdres().getKodPoczty());
        oldKlient.getAdres().setMiasto(newKlient.getAdres().getMiasto());
        oldKlient.getAdres().setNrLokalu(newKlient.getAdres().getNrLokalu());
        oldKlient.getAdres().setPoczta(newKlient.getAdres().getPoczta());
        oldKlient.getAdres().setUlica(newKlient.getAdres().getUlica());


        klientRepository.saveAndFlush(oldKlient);
        return "redirect:/client/dane";
    }
}

