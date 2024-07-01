/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmt.repo.implement;

import com.mycompany.springdemohibernate.HibernateUtils;
import com.pmt.pojo.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepoImplement {
    public List<Category> getCates(){
        try(Session s = HibernateUtils.getFactory().openSession()){
            Query q = s.createQuery("From Category", Category.class);
            return q.getResultList();
        }
    }
}
