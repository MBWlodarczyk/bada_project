package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Czesc;
import net.codejava.badabida.repos.CzescRepository;
import net.codejava.badabida.repos.KlientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
public class SessionController {

    private final CzescRepository czescRepository;

    public SessionController(CzescRepository czescRepository) {
        this.czescRepository = czescRepository;
    }

    @PostMapping("/client/cart/add")
    public String addToCart(Long nrCzesci,Integer quantity, HttpSession session){

        Czesc czesc = czescRepository.findById(nrCzesci).get();

        if(session.getAttribute("cart")==null){
           HashMap<Czesc,Integer> cart = new HashMap<>();
           cart.put(czesc,quantity);
           session.setAttribute("cart",cart);
       } else {
           HashMap<Czesc,Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
           cart.put(czesc, cart.containsKey(czesc) ? cart.get(czesc) + quantity : quantity);
       }
        return "redirect:/client/store";
    }

    @GetMapping("/client/cart/remove")
    public String removeFromCart(Long nrCzesci,Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();

        if(session.getAttribute("cart")==null){
            return "redirect:/client/store";
        } else{
            HashMap<Czesc,Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            if(!cart.containsKey(czesc)){
                return "redirect:/client/store";
            } else {
                Integer oldQuantity = cart.get(czesc);
                if(oldQuantity - quantity<0){
                    cart.remove(czesc);
                } else {
                    cart.put(czesc,cart.get(czesc) - quantity);
                }
            }
        }
        return "redirect:/client/store";
    }
}

