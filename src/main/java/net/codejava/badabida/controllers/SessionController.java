package net.codejava.badabida.controllers;

import net.codejava.badabida.model.Czesc;
import net.codejava.badabida.repos.CzescRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class SessionController {

    private final CzescRepository czescRepository;

    public SessionController(CzescRepository czescRepository) {
        this.czescRepository = czescRepository;
    }

    @PostMapping("/client/cart/add/{nrCzesci}")
    public String addToCart(@PathVariable("nrCzesci") Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();
        if (quantity > 0) {
            if (session.getAttribute("cart") == null) {
                HashMap<Czesc, Integer> cart = new HashMap<>();
                cart.put(czesc, quantity);
                session.setAttribute("cart", cart);
            } else {
                HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
                if (cart.containsKey(czesc)) {
                    Integer oldQuantity = cart.get(czesc);
                    cart.remove(czesc);
                    cart.put(czesc, quantity + oldQuantity);
                } else {
                    cart.put(czesc, cart.containsKey(czesc) ? cart.get(czesc) + quantity : quantity);
                }
            }
            calculateTheSum(session);
        }
        return "redirect:/client/store";
    }

    private boolean contain(List<Czesc> list, Czesc czesc) {
        for (Czesc c : list) {
            if (c.getNrCzesci().equals(czesc.getNrCzesci()))
                return true;
        }
        return false;
    }


    @PostMapping("/client/cart/remove/{nrCzesci}")
    public String removeFromCart(@PathVariable("nrCzesci") Long nrCzesci, Integer quantity, HttpSession session) {
        Czesc czesc = czescRepository.findById(nrCzesci).get();
        if (session.getAttribute("cart") == null || quantity < 0) {
            return "redirect:/client/store";
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            if (cart.containsKey(czesc)) {
                Integer oldQuantity = cart.get(czesc);
                if (oldQuantity - quantity <= 0) {
                    cart.remove(czesc);
                } else {
                    cart.remove(czesc);
                    cart.put(czesc, oldQuantity - quantity);
                }
                checkEmpty(cart, session);
                calculateTheSum(session);
            } else {
                return "redirect:/client/store";
            }
        }
        calculateTheSum(session);
        return "redirect:/client/store";
    }

    private void checkEmpty(HashMap<Czesc, Integer> cart, HttpSession session) {
        if (cart.size() == 0) {
            session.setAttribute("cart", null);
        }
    }


    private String calculateTheSum(HttpSession session) {
        BigDecimal amount = new BigDecimal("0");
        if (session.getAttribute("cart") == null) {
            session.setAttribute("amount", amount);
            return "redirect:/client/store";
        } else {
            HashMap<Czesc, Integer> cart = (HashMap<Czesc, Integer>) session.getAttribute("cart");
            List<Czesc> list = new ArrayList<>(cart.keySet());
            for (Czesc c : list) {
                amount = amount.add(c.getCena().multiply(new BigDecimal(cart.get(c))));
            }
            session.setAttribute("amount", amount);
        }
        return "redirect:/client/store";
    }
}

