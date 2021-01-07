package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Klient;
import net.codejava.badabida.repos.KlientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateKlient {

    private final KlientRepository klientRepository;

    public UpdateKlient(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    @PostMapping("/client/dane/update/{nrKlienta}")
    public String updateUser(@PathVariable("nrKlienta") Long nrKlienta, Klient klient,
                             BindingResult result, Model model) {
        System.out.println(klient.toString());
        klientRepository.save(klient);
        return "client/dane";
    }
}
