package lv.accenture.bootcamp.rardb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.accenture.bootcamp.rardb.login.LoggedInService;
import lv.accenture.bootcamp.rardb.login.User;

@Controller
public class IndexController {
	
	@Autowired
	private LoggedInService loggedInService;

	@GetMapping("/")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/main")
	public String toMain(Model model) {
		model.addAttribute("loggedIn", loggedInService.loggedIn());
		return "redirect:/movies/main";
	}
	


	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("user");
		return "user";
	}

}
