package net.codejava.badabida.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    @GetMapping("/new")
    public String sayNew() {
        return "new";
    }

    @GetMapping("/edit")
    public String sayEdit() {
        return "edit";
    }

    @GetMapping("/delete")
    public String sayDelete() {
        return "delete";
    }
}
