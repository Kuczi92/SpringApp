/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.controller;

import com.mycompany.springapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Quchi
 */
@Controller
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping("/customers")
    public String list(Model model)
     {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
     }
}
