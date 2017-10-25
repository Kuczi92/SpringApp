/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.services;

import com.mycompany.springapp.domain.Product;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Quchi
 * Serwisy pozwalają na definiowanie wspólnych zachwań dla usług Biznesowych 
 */
public interface ProductService {
    List<Product>getProductsByCategory(String Category);
    List<Product>getAllProducts();
    Set<Product> getProductByFilter(Map<String,List<String>> filterParams);
    Product getProductById(String Id);
    List<Product> getProductsByManufacturer(String Manufacturer);
    List<Product> getIntersectFromAllList(Collection<Product> ... params);
    void addProduct  (Product product);
}
