/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.services;

import com.mycompany.springapp.Repository.ProductRepository;
import com.mycompany.springapp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quchi
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired @Qualifier("One")
    private ProductRepository productRepository;
    
    @Override
    public void processOrder(String productId, int count) {
        Product productbyId = productRepository.getProductByID(productId);
        
        if(productbyId.getUnitsInStock() < count){
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie : "+productbyId.getUnitsInStock());
        }
        productbyId.setUnitsInStock(productbyId.getUnitsInStock()-count);
    }
    
}
