/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.springdemohibernate;

import com.pmt.repo.implement.CategoryRepoImplement;
import com.pmt.repo.implement.ProductRepoImplement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class SpringDemoHibernate {

    public static void main(String[] args) {
        CategoryRepoImplement s = new CategoryRepoImplement();
        s.getCates().forEach(c -> System.out.println(c.getName()));
//        System.out.println("======================");
//        ProductRepoImplement s1 = new ProductRepoImplement();
//        s1.getProducts(null).forEach(p -> System.out.println(p.getName()));
        System.out.println("======================");
        Map<String, String> params = new HashMap<>();
        params.put("q", "iphone");
//        params.put("fromPrice", "30000000");
        
        ProductRepoImplement s1 = new ProductRepoImplement();
        s1.getProducts(params).forEach(p -> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));
    }
}
