package lv.accenture.bootcamp.rardb.controller;

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
	public String toMain() {
		return "main";
	}

}
