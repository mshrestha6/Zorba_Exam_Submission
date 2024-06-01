package org.example.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Customer_details")

public class Customer {
    @Id
  //  @TableGenerator(name="test",  initialValue = 5001,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="customer_id")
    private Integer customerId;

  @Column(name="customer_name")
  private String customerName;

  @Column (name="mobile_no")
  private String mobileNo;

  @Column(name="customer_email")
  private String customerEmail;

 @Column(name="Customer_address")
 private String customerAddress;

  @Column(name="username")
  private String customerUserName;

  @Column(name="password")
  private String customerPassword;


    }

