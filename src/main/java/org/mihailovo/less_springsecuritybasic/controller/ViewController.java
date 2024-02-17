package org.mihailovo.less_springsecuritybasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class ViewController {
    /*@GetMapping
    public String home() {
        return "index";
    }*/

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
