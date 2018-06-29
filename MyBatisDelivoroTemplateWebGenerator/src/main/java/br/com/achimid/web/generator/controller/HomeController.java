package br.com.achimid.web.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final String PAGE_INDEX = "/home/index";

    @GetMapping
    public String index(){
        return PAGE_INDEX;
    }

}
