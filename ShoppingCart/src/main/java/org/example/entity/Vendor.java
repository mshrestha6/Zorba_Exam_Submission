package org.example.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="vendor_details")

public class Vendor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="vendor_id")
    private Integer vendorId;

    @Column(name="vendor_name")
    private String vendorName;

    @Column(name="vendor_email")
    private String vendorEmail;

    @Column(name="vendor_mobile")
    private Long vendorMobile;

    @Column(name="vendor_address")
    private String vendorAddress;

    @Column(name="userName")
    private String vendorUserName;

    @Column(name="password")
    private String vendorPassword;

    @Column(name="registration")
    private String vendorRegistration;




}
