package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Magazyn;
import net.codejava.badabida.model.MagazynyCzesci;
import net.codejava.badabida.model.Pracownik;
import net.codejava.badabida.model.Zamowienie;
import net.codejava.badabida.repos.*;
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
import java.util.Set;

@Controller
public class EmployeeController {

    private final PracownikRepository pracownikRepository;
    private final ZamowieniaRepository zamowieniaRepository;
    private final CzescRepository czescRepository;
    private final MagazynRepository magazynRepository;
    private final MagazynCzesciRepository magazynCzesciRepository;
    private final HashMap<String,Integer> possibleStatus;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmployeeController(PracownikRepository pracownikRepository, ZamowieniaRepository zamowieniaRepository, CzescRepository czescRepository, MagazynRepository magazynRepository, MagazynCzesciRepository magazynCzesciRepository) {
        this.pracownikRepository = pracownikRepository;
        this.zamowieniaRepository = zamowieniaRepository;
        this.czescRepository = czescRepository;
        this.magazynRepository = magazynRepository;
        this.magazynCzesciRepository = magazynCzesciRepository;
        this.possibleStatus = new HashMap<>();
        this.possibleStatus.put("zlozone",1);
        this.possibleStatus.put("zaakceptowane",2);
        this.possibleStatus.put("realizowane",3);
        this.possibleStatus.put("zrealizowane",4);
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
        if(pracownikRepository.findByUsername(principal.getUsername()).isPresent()
                && pracownikRepository.findByUsername(principal.getUsername()).get().hasMagazyn()) {
            model.addAttribute("zamowienia", pracownikRepository.findByUsername(principal.getUsername()).get().getZamowienia());
            model.addAttribute("statusy", possibleStatus);
            return "employee/orders";
        }
        return "redirect:/403";
    }

    @PostMapping("/employee/orders/update/{nrZamowienia}")
    public String updateOrder(@PathVariable("nrZamowienia") Long nrZamowienia, String statusZamowienia,Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        Magazyn m = pracownikRepository.findByUsername(principal.getUsername()).get().getMagazyn();

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
    public String getItemInfo(Model model, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        if(pracownikRepository.findByUsername(principal.getUsername()).isPresent()
                && pracownikRepository.findByUsername(principal.getUsername()).get().hasMagazyn()) {
            Set<MagazynyCzesci> mc = pracownikRepository.findByUsername(principal.getUsername()).get().getMagazyn().getCzesci();
            model.addAttribute("czesci", mc);
            return "employee/store";
        }
        return "redirect:/403";
    }

    @PostMapping("/employee/store/update/item")
    public String updateItemInWarehouse(Long nrCzesci, Long ilosc, Authentication auth) {
        UserDetails principal = (UserDetails) auth.getPrincipal();
        if(ilosc > 0 && czescRepository.findCzescByNrCzesci(nrCzesci) != null && pracownikRepository.findByUsername(principal.getUsername()).isPresent()
                && pracownikRepository.findByUsername(principal.getUsername()).get().hasMagazyn()) {
            Set<MagazynyCzesci> mc_list = pracownikRepository.findByUsername(principal.getUsername()).get().getMagazyn().getCzesci();
            if (mc_list.stream().anyMatch(n -> n.getCzesc().getNrCzesci().equals(nrCzesci))) {
                MagazynyCzesci mc = mc_list.stream().filter(n -> n.getCzesc().getNrCzesci().equals(nrCzesci)).findFirst().get();
                mc.setIlosc(ilosc);
                magazynCzesciRepository.saveAndFlush(mc);
            }
            return "redirect:/employee/store";
        }
        return "redirect:/403";
    }
}
