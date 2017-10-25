/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.domain;

import java.util.Objects;

/**
 *
 * @author Quchi
 */
public class Customer {
   private String CustomerId;
   private String name;
   private String adress;
   private boolean noOfOrdersMade;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(boolean noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.CustomerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return Objects.equals(this.CustomerId, other.CustomerId);
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerId=" + CustomerId + '}';
    }
   
        
}
