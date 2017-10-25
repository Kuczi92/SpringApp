/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.services;

import com.mycompany.springapp.domain.Customer;
import java.util.List;

/**
 *
 * @author Quchi
 */
public interface CustomerService {
    public List<Customer> getAllCustomers();
}
