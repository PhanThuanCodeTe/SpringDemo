/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springdemohibernate;

import com.pmt.pojo.Category;
import com.pmt.pojo.Product;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {

    private static SessionFactory factory;

    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.JAKARTA_JDBC_USER, "root");
        props.put(Environment.JAKARTA_JDBC_PASSWORD, "Admin@123");
        props.put(Environment.SHOW_SQL, true);
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        setFactory(conf.buildSessionFactory(serviceRegistry));
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }

    /**
     * @param aFactory the factory to set
     */
    public static void setFactory(SessionFactory aFactory) {
        factory = aFactory;
    }
}
