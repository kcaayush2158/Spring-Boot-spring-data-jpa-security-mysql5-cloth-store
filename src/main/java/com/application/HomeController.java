package com.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.entity.Bookstore;
import com.application.entity.User;
import com.application.service.BookService;

@Controller
public class HomeController {

	@Autowired
	public BookService bookService;
	@Autowired
	public BCryptPasswordEncoder bcryptPasswordEncoder;

	// view the list of product
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Bookstore> listBook = bookService.findAll();
		model.addAttribute("listBook", listBook);
		return "index";
	}

	@GetMapping("/new")
	public String addNewProduct(Model model) {
		Bookstore product = new Bookstore();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/save")
	public String createNewProduct(@ModelAttribute("product") Bookstore product) {
		User user = new User();
		String rawPassword = user.getPassword();
		String password = bcryptPasswordEncoder.encode(rawPassword);
		bookService.save(product);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		return "login";
	}

	@GetMapping("/singup")
	public String getSignup(Model model) {
		return "signup";
	}
}
