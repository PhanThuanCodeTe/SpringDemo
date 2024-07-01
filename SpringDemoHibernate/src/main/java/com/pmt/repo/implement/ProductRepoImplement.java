/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmt.repo.implement;

import com.mycompany.springdemohibernate.HibernateUtils;
import com.pmt.pojo.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepoImplement {

    private static final int PAGE_SIZE = 4;
    public List<Product> getProducts(Map<String, String> params) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
           
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            if(params != null){
                List<Predicate> predicates = new LinkedList<>();
                String kw = params.get("q");
                if(kw != null && !kw.isEmpty()){
                    Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
//                    if(p1 == null){
//                        System.out.println("Khong co san pham");
//                    }
//                    else
                        predicates.add(p1);
                }
                String fromPrice = params.get("fromPrice");
                if(fromPrice != null && !fromPrice.isEmpty()){
                    Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                    predicates.add(p2);
                }
                String toPrice = params.get("fromPrice");
                if(toPrice != null && !toPrice.isEmpty()){
                    Predicate p3 = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                    predicates.add(p3);
                }
                String cateId = params.get("cateId");
                if(cateId != null && !cateId.isEmpty()){
                    Predicate p4 = b.lessThanOrEqualTo(root.get("category").as(Integer.class), Integer.parseInt(cateId));
                    predicates.add(p4);
                }
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q); 
            if(params != null){
                String page = params.get("page");
                if(page!=null && !page.isEmpty()){
                    int p = Integer.parseInt(page);
                    int start = (p-1) *PAGE_SIZE;
                    query.setMaxResults(PAGE_SIZE);
                    query.setFirstResult(start);
                }
            }
            return query.getResultList();
        }
    }
}
