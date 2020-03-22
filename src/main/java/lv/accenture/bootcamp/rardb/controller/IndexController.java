package lv.accenture.bootcamp.rardb.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.accenture.bootcamp.rardb.login.User;

@Controller
public class IndexController {

	@GetMapping("/")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/main")
	public String toMain(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean loggedIn = hasUserRole(auth.getAuthorities());
		System.out.println("Logged in: " + loggedIn);
		model.addAttribute("loggedIn", loggedIn);
		System.out.println(auth);
		return "main";
	}
	
	private boolean hasUserRole(Collection<? extends GrantedAuthority> authorities) {
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("USER")) {
				return true;
			}
		}
		
		return false;
	}

	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("user");
		return "user";
	}

}
