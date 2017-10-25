package com.mycompany.springapp.Repository;

import com.mycompany.springapp.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Metody odpowiedzialne za wspólne zachowanie klas repozytorium  w pobieraniu danych na temat Domen
*/
/**
 *
 * @author Quchi
 */

public interface ProductRepository {
   public List <Product> getAllProducts();
   public Product getProductByID(String productID);
   public List<Product> getProductsByCategory(String Category); 
   public Set<Product> getProductsByFilter(Map<String,List<String>> filterParams);
   public List<Product> getProductsByManufacturer(String Manufacturer);
   public void addProduct(Product product);
}
