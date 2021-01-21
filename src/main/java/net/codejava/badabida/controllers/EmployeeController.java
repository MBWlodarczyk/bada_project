package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Magazyn;
import net.codejava.badabida.model.MagazynyCzesci;
import net.codejava.badabida.model.Pracownik;
import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.MagazynRepository;
import net.codejava.badabida.repos.PracownikRepository;
import net.codejava.badabida.repos.ZamowieniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class EmployeeController {

    private final PracownikRepository pracownikRepository;
    private final ZamowieniaRepository zamowieniaRepository;
    private final CzescRepository czescRepository;
    private final MagazynRepository magazynRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeController(PracownikRepository pracownikRepository, ZamowieniaRepository zamowieniaRepository, CzescRepository czescRepository, MagazynRepository magazynRepository) {
        this.pracownikRepository = pracownikRepository;
        this.zamowieniaRepository = zamowieniaRepository;
        this.czescRepository = czescRepository;
        this.magazynRepository = magazynRepository;
    }

    @GetMapping("/employee/home")
    public String getEmployeeHome() {
        return "employee/home";
    }


    @GetMapping("/employee/login")
    public String getEmployeeLogin() {
        return "employee/login";
    }


    /////////////////// DANE///////////////////////////////////////////////

    @GetMapping("/employee/personaldata")
    public String getClientInfo(Model model, Authentication auth) {
        if (auth != null) {
            UserDetails principal = (UserDetails) auth.getPrincipal();
            model.addAttribute("pracownik", pracownikRepository.findByUsername(principal.getUsername()).get());
            return "employee/personaldata";
        }
        return "redirect:/403";
    }

    @PostMapping("/employee/personaldata/update/{nrPracownika}")
    public String updateUser(@PathVariable("nrPracownika") Long nrPracownika, Pracownik newPracownik, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Pracownik oldPracownik = pracownikRepository.findByUsername(principal.getUsername()).get();


        if (oldPracownik.getNrPracownika().equals(nrPracownika)) {

            oldPracownik.setImie(newPracownik.getImie());
            oldPracownik.setNazwisko(newPracownik.getNazwisko());
            oldPracownik.setTelefon(newPracownik.getTelefon());

            if (newPracownik.getPassword() != "" && newPracownik.getPassword() != null)
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

    //////////////////////////////////// ZAMÓWIENIA ////////////////////////////////////////

    @GetMapping("/employee/orders")
    public String getOrders(Model model, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        model.addAttribute("zamowienia", pracownikRepository.findByUsername(principal.getUsername()).get().getZamowienia());
        HashMap<String,Integer> possibleStatus = new HashMap<>();
        possibleStatus.put("zlozone",1);
        possibleStatus.put("zaakceptowane",2);
        possibleStatus.put("realizowane",3);
        possibleStatus.put("zrealizowane",4);
        model.addAttribute("statusy", possibleStatus);
        return "employee/orders";
    }

    @PostMapping("/employee/orders/update/{nrZamowienia}")
    public String updateOrder(@PathVariable("nrZamowienia") Long nrZamowienia, String statusZamowienia,Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Magazyn m = pracownikRepository.findByUsername(principal.getUsername()).get().getMagazyn();


        HashMap<String,Integer> possibleStatus = new HashMap<>();
        possibleStatus.put("zlozone",1);
        possibleStatus.put("zaakceptowane",2);
        possibleStatus.put("realizowane",3);
        possibleStatus.put("zrealizowane",4);

        Zamowienie z = zamowieniaRepository.findByNrZamowienia(nrZamowienia).get();

            if(statusZamowienia.equals("realizowane") & z.getStatusZamowienia().equals("zlozone")){
                z.getCzesci().forEach(czesc ->
                {
                    MagazynyCzesci mc = m.getCzesci().stream().filter(czescMagazyn -> czescMagazyn.getCzesc().getNrCzesci().equals(czesc.getCzesc().getNrCzesci())).findFirst().get();
                    mc.setIlosc(mc.getIlosc()-czesc.getIlosc());
                });
                magazynRepository.saveAndFlush(m);
            }

            z.setStatusZamowienia(statusZamowienia);
            zamowieniaRepository.save(z);

        return "redirect:/employee/orders";
    }

    //////////////////////////////////// Sklep ////////////////////////////////////////

    @GetMapping("/employee/store")
    public String getItemInfo(Model model) {
        model.addAttribute("czesci", czescRepository.findAll());
        return "employee/store";
    }
}
