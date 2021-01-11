package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Czesc;
import net.codejava.badabida.model.Hurtownia;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.HurtowniaRepository;
import net.codejava.badabida.repos.MagazynRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    private final CzescRepository czescRepository;
    private final HurtowniaRepository hurtowniaRepository;
    private MagazynRepository magazynRepository;

    public AdminController(CzescRepository czescRepository, HurtowniaRepository hurtowniaRepository, MagazynRepository magazynRepository) {
        this.czescRepository = czescRepository;
        this.hurtowniaRepository = hurtowniaRepository;
        this.magazynRepository = magazynRepository;
    }

    @GetMapping("/admin/login")
    public String getAdminLogin() {
        return "admin/login";
    }

    @GetMapping("/admin/home")
    public String getAdminHome() {
        return "admin/home";
    }


    @GetMapping("/admin/item/{nrCzesci}")
    public String getItemInfo(@PathVariable("nrCzesci") Long nrCzesci, Model model) {
        model.addAttribute("czesc", czescRepository.findCzescByNrCzesci(nrCzesci));
        return "admin/item";
    }

    @GetMapping("/admin/store")
    public String getStore(Model model) {
        model.addAttribute("czesci", czescRepository.findAll());
        return "admin/store";
    }

    @GetMapping("/admin/warehouse")
    public String getWarehouse(Model model) {
        model.addAttribute("hurtownia", hurtowniaRepository.findByNrHurtowni((long)1).get());
        return "admin/warehouse";
    }

    @ModelAttribute()
    public Hurtownia newHurtownia(){
        return new Hurtownia();
    }

    @PostMapping("/admin/warehouse/update")
    public String updateWarehouse(Hurtownia newHurtownia)  {
        System.out.println(newHurtownia.toString());
        Hurtownia oldHurtownia = hurtowniaRepository.findByNrHurtowni((long) 1).get();
        oldHurtownia.setNazwa(newHurtownia.getNazwa());
        Adres hurtowniaAdres = oldHurtownia.getAdres();
        hurtowniaAdres.setKodPoczty(newHurtownia.getAdres().getKodPoczty());
        hurtowniaAdres.setMiasto(newHurtownia.getAdres().getMiasto());
        hurtowniaAdres.setNrLokalu(newHurtownia.getAdres().getNrLokalu());
        hurtowniaAdres.setPoczta(newHurtownia.getAdres().getPoczta());
        hurtowniaAdres.setUlica(newHurtownia.getAdres().getUlica());
        hurtowniaRepository.saveAndFlush(oldHurtownia);
        return "redirect:/admin/warehouse";
    }

    @GetMapping("/admin/stockroom")
    public String getStockroom(Model model) {
        model.addAttribute("magazyny", hurtowniaRepository.findAll());
        return "admin/stockroom";
    }

    @PostMapping("/admin/item/update/{nrCzesci}")
    public String updateItem(@PathVariable("nrCzesci") Long nrCzesci, Czesc newCzesc) {
        Czesc oldCzesc = czescRepository.findCzescByNrCzesci(nrCzesci);

        oldCzesc.setCena(newCzesc.getCena());
        oldCzesc.setCzasGwarancji(newCzesc.getCzasGwarancji());
        oldCzesc.setNazwa(newCzesc.getNazwa());
        oldCzesc.setProducent(newCzesc.getProducent());
        czescRepository.saveAndFlush(oldCzesc);

        return "admin/item";
    }

    @PostMapping("/admin/item/add")
    public String addItem(Model model, Czesc newCzesc) {
        Czesc czesc = czescRepository.saveAndFlush(newCzesc);
        System.out.println(czesc.getNrCzesci());
        return "admin/item";
    }
}
