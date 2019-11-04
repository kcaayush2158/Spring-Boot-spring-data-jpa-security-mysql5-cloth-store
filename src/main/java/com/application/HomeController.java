package com.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.entity.Bookstore;
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
		bookService.save(product);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		bookService.delete(id);
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
	
	@GetMapping("/edit/{id}")
	public ModelAndView getEditedId(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("edit_product");
		Bookstore bookstore = bookService.getProduct(id);
		model.addObject("product",bookstore);
		return model;
	}
	@GetMapping("/logout-success")
	public String loginSuccess() {
		return "login";
	}

	

}
