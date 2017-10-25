/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.services;

import com.mycompany.springapp.Repository.ProductRepository;
import com.mycompany.springapp.domain.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quchi
 */
@Service
public class ProductServiceImpl implements ProductService {
    // Wstrzyknięta zależność do repozytorium, czyli klas odpowiedzialnych za przechwanie danych.
    @Autowired @Qualifier("One")
    ProductRepository productRepository;
    //Metody które nie odwołują się bezpośrednio do klas repozytorium a odsyłają one zadanie w postaci metod do referencji wstrzniętej zależności do repo.
    @Override
    public List<Product> getAllProducts() {
    return  productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String Category) {
       return productRepository.getProductsByCategory(Category);
    }

    @Override
    public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(String Id) {
     return productRepository.getProductByID(Id);
    }

    @Override
    public List<Product> getProductsByManufacturer(String Manufacturer) {
      return productRepository.getProductsByManufacturer(Manufacturer);
    }

    @Override
    public List<Product> getIntersectFromAllList(Collection<Product>... params) {
        Set<Product> FilteredProducts = new HashSet<>();
        for(Collection<Product> currentList : params){
            FilteredProducts.addAll(currentList);
        }
        List <Product> Output = new ArrayList<>();
        Output.addAll(FilteredProducts);
      return Output;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

   
    
    
}
