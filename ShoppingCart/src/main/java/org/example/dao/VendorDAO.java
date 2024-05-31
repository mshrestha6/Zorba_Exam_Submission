package org.example.dao;

import org.example.entity.Vendor;

import java.util.List;

public interface VendorDAO {
    String registerVendor(Vendor vendor);

    List<Vendor> getAllVendors();
}
