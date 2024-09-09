package com.projects.quickcart.controller.retailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.projects.quickcart.service.InventoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/retailer/inventory")
public class InventoryController {

	@Autowired
	private InventoryService service;

	@GetMapping
	public String inventoryPage(Model model, HttpSession session) {
		var id = (Long) session.getAttribute("userId");
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED,
					"Sorry bro, You should be logon to your account");
		}
		model.addAttribute("inventory", service.getAllProducts(id));
		return "retailer/inventory";
	}

}
