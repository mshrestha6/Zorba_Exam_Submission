package org.example.service;


import org.example.dao.VendorDAO;
import org.example.entity.Vendor;
import org.example.model.VendorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class VendorService {
    @Autowired
    private VendorDAO vendorDAO;

    @Transactional
    public String registerVendor(VendorModel vendorModel) {
        if(vendorModel.getVendorName()==null || vendorModel.getVendorPassword()==null ||
                vendorModel.getVendorEmail()==null || vendorModel.getVendorMobile()==null
                || vendorModel.getVendorAddress()==null|| vendorModel.getVendorRegistration()==null) {
            return "Please give valid information";
        }else if (!vendorModel.getVendorEmail().contains("@")){
              return "Please provide valid Email";
            }else if(vendorModel.getVendorEmail().length() !=10){
            return "Please provide valid phone number";
        }else if(vendorModel.getVendorPassword().length()<6){
            return "Please provide correct password..";
        }else{
            Vendor vendor=new Vendor();
            vendor.setVendorName(vendorModel.getVendorName());
            vendor.setVendorEmail(vendorModel.getVendorEmail());
            vendor.setVendorMobile(vendorModel.getVendorMobile());
            vendor.setVendorAddress(vendorModel.getVendorAddress());
            vendor.setVendorUserName(vendorModel.getVendorUserName());
            vendor.setVendorPassword(vendorModel.getVendorPassword());
            vendor.setVendorRegistration(vendorModel.getVendorRegistration());

            String check=this.vendorDAO.registerVendor(vendor);
            return check;
        }
    }
    public List<VendorModel> getAllVendor(){
        List<Vendor> vendorList=this.vendorDAO.getAllVendors();
        List<VendorModel> vendorModelList=new ArrayList<>();
        for(Vendor vendor:vendorList){
            VendorModel vendorModel=new VendorModel();
            vendorModel.setVendorName(vendor.getVendorName());
            vendorModel.setVendorEmail(vendor.getVendorEmail());
            vendorModel.setVendorMobile(vendor.getVendorMobile());
            vendorModel.setVendorAddress(vendor.getVendorAddress());
            vendorModel.setVendorUserName(vendor.getVendorUserName());
            vendorModel.setVendorPassword(vendor.getVendorPassword());
            vendorModel.setVendorRegistration(vendor.getVendorRegistration());
            vendorModelList.add(vendorModel);

        }
        return vendorModelList;
    }

}
