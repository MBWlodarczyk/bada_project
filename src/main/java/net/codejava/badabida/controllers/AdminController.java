package net.codejava.badabida.controllers;

import net.codejava.badabida.model.*;
import net.codejava.badabida.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;


@Controller
public class AdminController {

    private final CzescRepository czescRepository;
    private final HurtowniaRepository hurtowniaRepository;
    private final MagazynRepository magazynRepository;
    private final AdresRepository adresRepository;
    private final PracownikRepository pracownikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AdminController(CzescRepository czescRepository, HurtowniaRepository hurtowniaRepository,
                           MagazynRepository magazynRepository, AdresRepository adresRepository,
                           PracownikRepository pracownikRepository) {
        this.czescRepository = czescRepository;
        this.hurtowniaRepository = hurtowniaRepository;
        this.magazynRepository = magazynRepository;
        this.adresRepository = adresRepository;
        this.pracownikRepository = pracownikRepository;
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


    ////////////////////////// HURTOWNIA ////////////////////////////////////
    @GetMapping("/admin/wholesaler")
    public String getWholesaler(Model model) {
        model.addAttribute("hurtownia", hurtowniaRepository.findByNrHurtowni((long) 1).get());
        return "admin/wholesaler";
    }

    @ModelAttribute()
    public Hurtownia newHurtownia() {
        return new Hurtownia();
    }

    @PostMapping("/admin/wholesaler/update")
    public String updateWholesaler(Hurtownia newHurtownia) {
        Hurtownia oldHurtownia = hurtowniaRepository.findByNrHurtowni((long) 1).get();
        oldHurtownia.setNazwa(newHurtownia.getNazwa());
        Adres hurtowniaAdres = oldHurtownia.getAdres();
        hurtowniaAdres.setKodPoczty(newHurtownia.getAdres().getKodPoczty());
        hurtowniaAdres.setMiasto(newHurtownia.getAdres().getMiasto());
        hurtowniaAdres.setNrLokalu(newHurtownia.getAdres().getNrLokalu());
        hurtowniaAdres.setPoczta(newHurtownia.getAdres().getPoczta());
        hurtowniaAdres.setUlica(newHurtownia.getAdres().getUlica());
        hurtowniaRepository.saveAndFlush(oldHurtownia);
        return "redirect:/admin/wholesaler";
    }

    ////////////////////////// MAGAZYN ////////////////////////////////////
    @GetMapping("/admin/warehouse")
    public String getWarehouse(Model model) {
        model.addAttribute("magazyny", magazynRepository.findAll());
        return "admin/warehouse";
    }

    @ModelAttribute()
    public Magazyn newMagazyn() {
        return new Magazyn();
    }

    @PostMapping("/admin/warehouse/update/{nrMagazynu}")
    public String updateWarehouse(@PathVariable("nrMagazynu") Long nrMagazynu, Magazyn newMagazyn) {
        Magazyn oldMagazyn = magazynRepository.findByNrMagazynu(nrMagazynu).get();
        oldMagazyn.setNazwa(newMagazyn.getNazwa());
        Adres magazynAdres = oldMagazyn.getAdres();
        magazynAdres.setKodPoczty(newMagazyn.getAdres().getKodPoczty());
        magazynAdres.setMiasto(newMagazyn.getAdres().getMiasto());
        magazynAdres.setNrLokalu(newMagazyn.getAdres().getNrLokalu());
        magazynAdres.setPoczta(newMagazyn.getAdres().getPoczta());
        magazynAdres.setUlica(newMagazyn.getAdres().getUlica());
        magazynRepository.saveAndFlush(oldMagazyn);
        return "redirect:/admin/warehouse";
    }

    @PostMapping("/admin/warehouse/new")
    public String addWarehouse(Magazyn magazyn) {
        magazyn.setHurtownia(hurtowniaRepository.findByNrHurtowni((long) 1).get());
        Adres a = new Adres();
        a.setMiasto(magazyn.getAdres().getMiasto());
        a.setKodPoczty(magazyn.getAdres().getKodPoczty());
        a.setNrLokalu(magazyn.getAdres().getNrLokalu());
        a.setPoczta(magazyn.getAdres().getPoczta());
        a.setUlica(magazyn.getAdres().getUlica());
        Adres a2 = adresRepository.save(a);
        magazyn.setAdres(a2);
        magazynRepository.saveAndFlush(magazyn);
        return "redirect:/admin/warehouse";
    }

    @PostMapping("/admin/warehouse/remove{nrMagazynu}")
    public String removeWarehouse(@PathVariable("nrMagazynu") Long nrMagazynu) {
        magazynRepository.deleteById(nrMagazynu);
        return "redirect:/admin/warehouse";
    }

    ////////////////////////// PRACOWNICY ////////////////////////////////////
    @GetMapping("/admin/employees")
    public String getEmployees(Model model) {
        model.addAttribute("magazyny1", magazynRepository.findAll());
        model.addAttribute("pracownicy", pracownikRepository.findAll());
        Set<String> possibleRoles = new HashSet<String>();
        possibleRoles.add("ROLE_ADMIN");
        possibleRoles.add("ROLE_EMP");
        possibleRoles.add("ROLE_USER");
        model.addAttribute("possibleRoles",possibleRoles);
        return "admin/employees";
    }

    @ModelAttribute()
    public Pracownik newEmployee() {
        return new Pracownik();
    }

    @ModelAttribute()
    public Czesc newCzesc() { return new Czesc();}

    @PostMapping("/admin/employees/update/{nrPracownika}")
    public String updateEmployee(@PathVariable("nrPracownika") Long nrPracownika, Pracownik newPracownik) {
        Pracownik oldPracownik = pracownikRepository.findByNrPracownika(nrPracownika).get();
        oldPracownik.setImie(newPracownik.getImie());
        oldPracownik.setNazwisko(newPracownik.getNazwisko());
        oldPracownik.setDataUrodzenia(newPracownik.getDataUrodzenia());
        oldPracownik.setTelefon(newPracownik.getTelefon());
        Adres a = oldPracownik.getAdres();
        a.setKodPoczty(newPracownik.getAdres().getKodPoczty());
        a.setMiasto(newPracownik.getAdres().getMiasto());
        a.setNrLokalu(newPracownik.getAdres().getNrLokalu());
        a.setPoczta(newPracownik.getAdres().getPoczta());
        a.setUlica(newPracownik.getAdres().getUlica());
        oldPracownik.setAdres(a);
        if(newPracownik.hasMagazyn()) oldPracownik.setMagazyn(magazynRepository.findByNrMagazynu(newPracownik.getMagazyn().getNrMagazynu()).get());
        else oldPracownik.setMagazyn(null);
        pracownikRepository.saveAndFlush(oldPracownik);
        return "redirect:/admin/employees";
    }

    @PostMapping("/admin/employees/new")
    public String addEmployeee(Pracownik pracownik) {
        pracownik.setHurtownia(hurtowniaRepository.findByNrHurtowni((long) 1).get());

        if(!pracownik.hasMagazyn()){
            pracownik.setMagazyn(null);
        }

        Adres a = new Adres();
        a.setMiasto(pracownik.getAdres().getMiasto());
        a.setKodPoczty(pracownik.getAdres().getKodPoczty());
        a.setNrLokalu(pracownik.getAdres().getNrLokalu());
        a.setPoczta(pracownik.getAdres().getPoczta());
        a.setUlica(pracownik.getAdres().getUlica());

        Adres a2 = adresRepository.save(a);
        pracownik.setAdres(a2);

        //TODO no cyberbezpieczne
        String xd = pracownik.getPassword();
        String hash = passwordEncoder.encode(xd);

        pracownik.setPassword(hash);


        pracownikRepository.saveAndFlush(pracownik);
        return "redirect:/admin/employees";
    }

    @PostMapping("/admin/employees/remove{nrPracownika}")
    public String removeEmployee(@PathVariable("nrPracownika") Long nrPracownika) {
        pracownikRepository.deleteById(nrPracownika);
        return "redirect:/admin/employees";
    }

    ////////////////////////// COS INNEGO ////////////////////////////////////

    @PostMapping("/admin/item/update/{nrCzesci}")
    public String updateItem(@PathVariable("nrCzesci") Long nrCzesci, Czesc newCzesc) {
        Czesc oldCzesc = czescRepository.findCzescByNrCzesci(nrCzesci);

        oldCzesc.setCena(newCzesc.getCena());
        oldCzesc.setCzasGwarancji(newCzesc.getCzasGwarancji());
        oldCzesc.setNazwa(newCzesc.getNazwa());
        oldCzesc.setProducent(newCzesc.getProducent());
        czescRepository.saveAndFlush(oldCzesc);

        return "redirect:/admin/store";
    }
    @PostMapping("/admin/item/remove/{nrCzesci}")
    public String removeItem(@PathVariable("nrCzesci") Long nrCzesci) {
        czescRepository.deleteById(nrCzesci);
        return "redirect:/admin/store";
    }


    @PostMapping("/admin/item/new")
    public String addItem(Czesc newCzesc) {
        czescRepository.saveAndFlush(newCzesc);
        return "redirect:/admin/store";
    }
}
