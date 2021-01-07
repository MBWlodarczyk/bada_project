package net.codejava.badabida.controllers;

import net.codejava.badabida.repos.KlientRepository;
import net.codejava.badabida.repos.PracownikRepository;
import net.codejava.badabida.repos.ZamowieniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZamowienieController {

    @Autowired
    private final ZamowieniaRepository zamowieniaRepository;
    private final KlientRepository klientRepository;
    private final PracownikRepository pracownikRepository;

    public ZamowienieController(ZamowieniaRepository zamowieniaRepository, KlientRepository klientRepository, PracownikRepository pracownikRepository) {
        this.zamowieniaRepository = zamowieniaRepository;
        this.klientRepository = klientRepository;
        this.pracownikRepository = pracownikRepository;
    }

    @GetMapping("client/zamowienia")
    @Transactional
    public String getUserZamowienia(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("zamowienia", klientRepository.findByUsername(username).get().getZamowienia());
            pracownikRepository.findByUsername("emp1").get().getZamowienia().forEach(System.out::println);
        }
        return "client/zamowienia.html";
    }

    @GetMapping("/client/dane")
    @Transactional
    public String getClientInfo(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("klient", klientRepository.findByUsername(principal.getUsername()).get());
        return "client/dane";
    }
}
