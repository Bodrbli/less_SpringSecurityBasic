package org.mihailovo.less_springsecuritybasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class ViewController {
    @GetMapping
    public String home() {
        return "index";
    }
}
