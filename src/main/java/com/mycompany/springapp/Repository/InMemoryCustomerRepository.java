/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.Repository;

import com.mycompany.springapp.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Quchi
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
private List<Customer> customersList = new ArrayList<>();
    public InMemoryCustomerRepository() {
        Customer Adi = new Customer();
        Adi.setAdress("Mierzęcice ul. wolności 1233");
        Adi.setCustomerId("1");
        Adi.setName("Adi");
        Adi.setNoOfOrdersMade(true);
        Customer Mati = new Customer();
        Mati.setAdress("Mierzęcice ul. wolności 5443");
        Mati.setCustomerId("2");
        Mati.setName("Mateusz");
        Mati.setNoOfOrdersMade(true);
   
        Customer Kamil = new Customer();
        Kamil.setAdress("Niwiska ul. kaczorowa 5443");
        Kamil.setCustomerId("3");
        Kamil.setName("Kamilek");
        Kamil.setNoOfOrdersMade(true);
       
        Customer Damianek = new Customer();
        Damianek.setAdress("Mierzęcice ul. wolności 5433333");
        Damianek.setCustomerId("4");
        Damianek.setName("Damian");
        Damianek.setNoOfOrdersMade(true);
      
        Customer Norbert = new Customer();
        Norbert.setAdress("Mierzęcice ul. wolności 143");
        Norbert.setCustomerId("5");
        Norbert.setName("Norbert");
        Norbert.setNoOfOrdersMade(true);
        
        
        
         customersList.add(Kamil);
         customersList.add(Mati);
         customersList.add(Damianek);
         customersList.add(Norbert);
         customersList.add(Adi);
    }

    
    
    
    @Override
    public List<Customer> getAllCustomers() {
       return customersList;
    }

    @Override
    public Customer getCustomerbyID(String CustomerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
