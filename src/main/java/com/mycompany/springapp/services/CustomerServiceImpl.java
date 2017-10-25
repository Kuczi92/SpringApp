/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.services;

import com.mycompany.springapp.Repository.CustomerRepository;
import com.mycompany.springapp.domain.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quchi
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired 
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
       return customerRepository.getAllCustomers();
    }
    
}
