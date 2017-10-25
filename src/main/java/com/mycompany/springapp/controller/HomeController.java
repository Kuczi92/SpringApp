/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Quchi
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Model model){
        
        model.addAttribute("greeting","Witaj w sklepie internetowym");
        model.addAttribute("tagline", "Wyjątkowym i jedynym sklepie");
        
        return "welcome";
    }
    
}
