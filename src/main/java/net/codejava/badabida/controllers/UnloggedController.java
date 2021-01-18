package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Klient;
import net.codejava.badabida.repos.AdresRepository;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UnloggedController {

    private final CzescRepository czescRepository;
    private final AdresRepository adresRepository;
    private final KlientRepository klientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UnloggedController(CzescRepository czescRepository, AdresRepository adresRepository, KlientRepository klientRepository) {
        this.czescRepository = czescRepository;
        this.adresRepository = adresRepository;
        this.klientRepository = klientRepository;
    }


    @GetMapping("/403")
    public String getForbidden() {
        return "403";
    }

    @GetMapping("/")
    public String getAny(Authentication auth) {
        if (auth == null) {
            return "index";
        } else {
            String role = auth.getAuthorities().toString();
            switch (role) {
                case "[ROLE_EMP]":
                    return "redirect:/employee/home";
                case "[ROLE_ADMIN]":
                    return "redirect:/admin/home";
                case "[ROLE_USER]":
                    return "redirect:/client/home";
            }

        }
        return "index";
    }


    @GetMapping("/store")
    public String getItemInfo(Model model) {
        model.addAttribute("czesci", czescRepository.findAll());
        return "store";
    }

    @ModelAttribute()
    public Klient newKlient() {
        return new Klient();
    }

    @PostMapping("/newClient")
    public String addClient(Klient klient) {

        Adres a = new Adres();
        a.setMiasto(klient.getAdres().getMiasto());
        a.setKodPoczty(klient.getAdres().getKodPoczty());
        a.setNrLokalu(klient.getAdres().getNrLokalu());
        a.setPoczta(klient.getAdres().getPoczta());
        a.setUlica(klient.getAdres().getUlica());

        Adres a2 = adresRepository.save(a);

        klient.setAdres(a2);

        //TODO no cyberbezpieczne
        String xd = klient.getPassword();
        String hash = passwordEncoder.encode(xd);

        klient.setPassword(hash);

        klient.setRole("ROLE_USER");

        klientRepository.saveAndFlush(klient);

        return "redirect:/client/login";
    }

}
