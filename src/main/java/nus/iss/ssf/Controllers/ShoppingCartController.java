package nus.iss.ssf.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;




import nus.iss.ssf.Models.*;
import nus.iss.ssf.Services.*;
import nus.iss.ssf.Repositories.*;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path={"/","view1test.html"})
public class ShoppingCartController {


	@Autowired
	CartRepo cartrepo;

	// @Autowired
	// ShoppingCartService ShoppingCartService;
    
    @GetMapping
	public String getViewOne(Model model, HttpSession sess) {
		//basically your homepage

		sess.invalidate();

		System.out.println(cartrepo.getShoppingcart());

		ArrayList<CartItems> cart = cartrepo.getShoppingcart();
	

		model.addAttribute("cartitems", new CartItems());
		model.addAttribute("cart", cart);
		

		return "view1test";


	}
	
	@PostMapping(path={"/add"})
	public String postViewOne(@Valid CartItems CartItems, BindingResult result, Model model, HttpSession sess) {
		
		if (result.hasErrors()) {
            return "view1test";
        }


		cartrepo = (CartRepo) sess.getAttribute("cartitems");
		cartrepo.addToCart(CartItems);


		return "redirect:/";

	}

	@GetMapping(path={"/add/shipping"})
	public String getShippingAddress(Model model, HttpSession sess) {
		


		ArrayList<CartItems> cart = cartrepo.getShoppingcart();
	

		model.addAttribute("shippingaddress", new ShippingAddress());
		
		return "view2";
	}
}
