/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmt.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author admin
 */
@Entity
@Data
@Table(name="product")
public class Product implements Serializable{
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private double price;
        private String image;
        
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;
}
