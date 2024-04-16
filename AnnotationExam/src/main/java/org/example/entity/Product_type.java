package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product_type")

public class Product_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_type_id",length = 10)
    private Integer typeid;

    @Column(name="Product_type",length = 50)
    private String type;

    @Column(name= "rate",length = 10)
    private Double rate;

}
