/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.Repository;

import com.mycompany.springapp.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Quchi
 */

@Repository("Two")
public class TwoInMemoryProductRepository implements ProductRepository {
     private List<Product> listOfProducts = new ArrayList<>();
    
    
 public TwoInMemoryProductRepository() {
	Product iphone = new Product("P1234","iPhone 5stwo", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smytjsytbguh6ruartfon z 4-calowym ekranem o rozdzielczości 640×1136 i 8-megapikselowym aparatem");
        iphone.setCategory("smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235","Dell Inspiron two", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy lbtbrsshrthfrthsrthsrthsrthaptop (czarny) z procesorami Intel Core 3. generacji");
        laptop_dell.setCategory("laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236","Nexus 7 two", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszhsrthsrthsrthsrthsrthsrthsrthsrthsrthsym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);

	}
 
    @Override
    public List<Product> getAllProducts() {
       return listOfProducts;
    }

    @Override
    public Product getProductByID(String productID) {
     Product productbyId = null;
     for(Product product:listOfProducts){
         if(product != null && product.getProductId().equals(productID) && product.getProductId()!= null){
             productbyId = product;
         }
     }
     if(productbyId == null)        
     {
         throw new IllegalArgumentException("Brak produktu o wskazanym id "+ productID);
     }
     return productbyId;
    }

    @Override
    public List<Product> getProductsByCategory(String Category) {
      List<Product>  productsByCategory = new ArrayList<>();
      listOfProducts.stream().filter((currentProduct) -> (currentProduct.getCategory().equals(Category))).forEachOrdered((currentProduct) -> {
          productsByCategory.add(currentProduct);
         });
      return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
       Set<Product> ProductByBrand = new HashSet<>();
       Set<Product> ProductByCategory = new HashSet<>();
       Set<String> Criterias = filterParams.keySet();
       if(Criterias.contains("brand")){
           for(String brandName: filterParams.get("brand")){
               for(Product CurrentProduct:listOfProducts){
                   if(brandName.equalsIgnoreCase(CurrentProduct.getManufacturer())){
                       ProductByBrand.add(CurrentProduct);
                   }
               }
           }
       }
       if(Criterias.contains("category")){
           for(String categoryName: filterParams.get("category")){
               ProductByCategory.addAll(this.getProductsByCategory(categoryName));
           }
       }
       
       ProductByBrand.retainAll(ProductByCategory);
       return ProductByBrand;
    }

    @Override
    public List<Product> getProductsByManufacturer(String Manufacturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
