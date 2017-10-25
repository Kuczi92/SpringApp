/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapp.controller;

import com.mycompany.springapp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.springapp.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Quchi
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    
    //wstrzykiwanie zależności tu masz ! Jest to po prostu referencja do innego kontenera springa dzieki temu tworzą się 
    // zależności pomiędzy klasami oraz zadaniami jakie one mają 
   
    @Autowired 
    private ProductService productService;
    
    @RequestMapping
    public String list(Model model){
        
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }
    
    @RequestMapping("/all")
    public ModelAndView allProducts(){
        ModelAndView model = new ModelAndView();
        model.addObject("products", productService.getAllProducts());
        model.setViewName("products");
        return model;
    }
    
    @RequestMapping("/{category}")
    public String getProductByCategory(Model model,@PathVariable("category") String productCategory){
        model.addAttribute("products",productService.getProductsByCategory(productCategory));
        return "products";
    }
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams,Model model){
        model.addAttribute("products",productService.getProductByFilter(filterParams));
        return "products";
    }
    
    @RequestMapping("/product")
    public String getProductById(@RequestParam ("id") String productId,Model model){
        model.addAttribute("product",productService.getProductById(productId));
        return "product";
    }
    
    @RequestMapping("/{category}/{criteria}")
    public String filterProducts(@RequestParam ("manufacturer") String manufacturer,@PathVariable("category")String productCategory,@MatrixVariable(pathVar="criteria") Map<String,List<String>> filterParams,Model model){
       
        
        model.addAttribute("products",productService.getIntersectFromAllList(productService.getProductByFilter(filterParams)
                                        ,productService.getProductsByCategory(productCategory),
                                        productService.getProductsByManufacturer(manufacturer)));
        return "products";
    }
    
    // te metoda dodaje pusty obiekt co powoduje ze juz w formularzy dodania nowego obiektu na podstawie form beana, firmularz szuka za pomocą srping 
    // frameworka obiekt o kluczu newprodukt a formularz poprzez nazwy pol getterów adresuje poszczególne inputy na pola obiektu bean typu Product
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product NewProduct = new Product();
        model.addAttribute("newProduct",NewProduct);
        return "addProduct";
        
    }
    // Gdy formularz prześle wypełnione pola obiektu beanform spring adresuje na podstawie klucza newProduct na zmienna o nazwie newProduct o typie product 
    // ten obiekt zostaje potem przesłany do wstrzykniętej zależności do usługi service Product a service Produkt przesyła to do Repozytorium Producta
    @RequestMapping(value  =  "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product  newProduct,BindingResult result){
        String[] suppressedFields = result.getSuppressedFields();
        if(suppressedFields.length>0){
            throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
        
    }
     // obiekt który ma za zadanie ograniczać wiązanie z zabronionymi polami beana Domeny
    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInOrder","discontinued");
    }
}
