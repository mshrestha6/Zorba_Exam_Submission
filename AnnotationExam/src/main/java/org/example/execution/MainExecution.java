package org.example.execution;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Product_type;
import org.example.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.module.Configuration;
import java.util.Scanner;

public class MainExecution {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            Scanner scanner = new Scanner(System.in);
            //Input Customer Info
            System.out.println("Enter Customer ID: (e.g:C01)");
            String customerId = scanner.nextLine();

            System.out.println("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.println("Enter Customer Email: ");
            String customerEmail = scanner.nextLine();

            System.out.println("Enter Customer Mobile Number: ");
            Long mobileNumber = scanner.nextLong();

            if(Long.valueOf(mobileNumber).longValue() !=10){
                System.out.println("Invalid Mobile Number");
            }

            //Input Product info

            System.out.println("Enter Product ID: (e.g: P01) ");
            String productId = scanner.nextLine();

            System.out.println("Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.println("Enter Product Quantity: ");
            Double productQuantity = scanner.nextDouble();

            System.out.println("Enter Product Type(grocery/cosmetics/dairyproduct): ");
            String type = scanner.nextLine();

            Product_type productType1=session.createQuery("from Product_type where type= :productType", Product_type.class).
                    setParameter("productType", type).uniqueResult();

            if(productType1==null){
                System.out.println("Invalid Product Type");
            }
            //Calculate Product Price
            double productPrice=productQuantity*productType1.getRate();

            //Create customer and product objects
            Customer customer=new Customer();
            customer.setCustId(customerId);
            customer.setCustName(customerName);
            customer.setEmail(customerEmail);
            customer.setCustMobile(mobileNumber);
            customer.setFinalProductPrice(productPrice);

            Product product=new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setProductQuantity(productQuantity);
            product.setCustomer(customer);
            product.setProducttype(productType1);


            tx = session.beginTransaction();

            session.save(customer);
            session.save(product);
            tx.commit();

            System.out.println("Data saved SUCCESSFULLY");
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
