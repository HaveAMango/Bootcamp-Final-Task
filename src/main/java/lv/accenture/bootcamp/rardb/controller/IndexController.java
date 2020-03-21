package lv.accenture.bootcamp.rardb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.accenture.bootcamp.rardb.login.User;

@Controller
public class IndexController {

	@GetMapping("/")
	public String toIndex() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
		return "index";
	}
	
	@GetMapping("/main")
	public String toMain() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
		return "main";
	}

//	@GetMapping("/main")
//	public String toMainLoggedIn() {
//		return "main";
//	}
}
