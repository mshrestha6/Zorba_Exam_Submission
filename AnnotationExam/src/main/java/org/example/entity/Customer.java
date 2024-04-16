package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Customer")

public class Customer {
    @Id
    @Column(name="custId",length = 10)
    private String custId;

    @Column(name="custName",length=50)
    private String custName;

    @Column(name="Email",length = 255)
    private String email;

    @Column(name="custMobile",length=15)
    private Long custMobile;

    @Column(name="finalProductPrice",length=100)
    private Double finalProductPrice;


    }

