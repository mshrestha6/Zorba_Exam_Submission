package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Product")

public class Product {
    @Id
    @Column(name="ProductId",length=10)
    private String productId;

    @Column(name="ProductName",length=255)
    private String productName;

    @Column(name="ProductQuantity",length = 100)
    private Double productQuantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="custId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="prod_type_id")
    private Product_type producttype;

    }
