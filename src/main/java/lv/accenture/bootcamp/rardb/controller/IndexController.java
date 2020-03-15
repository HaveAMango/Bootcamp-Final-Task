package lv.accenture.bootcamp.rardb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String toIndex() {
        return "index";
    }
    

}