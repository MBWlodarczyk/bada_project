package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Klient;
import net.codejava.badabida.model.Pracownik;
import net.codejava.badabida.repos.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final PracownikRepository pracownikRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeController(PracownikRepository pracownikRepository) {
        this.pracownikRepository = pracownikRepository;
    }

    @GetMapping("/employee/home")
    public String getEmployeeHome() {
        return "employee/home";
    }


    @GetMapping("/employee/login")
    public String getEmployeeLogin() {
        return "employee/login";
    }

    @GetMapping("/employee/personaldata")
    public String getClientInfo(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("pracownik", pracownikRepository.findByUsername(principal.getUsername()).get());
        return "employee/personaldata";
    }

    @PostMapping("/employee/personaldata/update/{nrPracownika}")
    public String updateUser(@PathVariable("nrPracownika") Long nrPracownika, Pracownik newPracownik, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Pracownik oldPracownik = pracownikRepository.findByUsername(principal.getUsername()).get();


        if (oldPracownik.getNrPracownika().equals(nrPracownika)) {

            oldPracownik.setImie(newPracownik.getImie());
            oldPracownik.setNazwisko(newPracownik.getNazwisko());
            oldPracownik.setTelefon(newPracownik.getTelefon());

            if(newPracownik.getPassword()!="" && newPracownik.getPassword() != null )
                oldPracownik.setPassword(passwordEncoder.encode(newPracownik.getPassword()));

            oldPracownik.getAdres().setKodPoczty(newPracownik.getAdres().getKodPoczty());
            oldPracownik.getAdres().setMiasto(newPracownik.getAdres().getMiasto());
            oldPracownik.getAdres().setNrLokalu(newPracownik.getAdres().getNrLokalu());
            oldPracownik.getAdres().setPoczta(newPracownik.getAdres().getPoczta());
            oldPracownik.getAdres().setUlica(newPracownik.getAdres().getUlica());

            pracownikRepository.saveAndFlush(oldPracownik);
        } else {
            return "redirect:/403";
        }
        return "redirect:/employee/personaldata";
    }

}
