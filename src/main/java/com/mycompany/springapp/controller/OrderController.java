/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.controller;

import com.mycompany.springapp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Quchi
 */
@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/order/P1234/2")
    public String process(){
        orderService.processOrder("P1234", 2);
        return "redirect:/products";
    }
}
