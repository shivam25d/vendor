package com.vendor.Vendor_Insight.DTO;

import com.vendor.Vendor_Insight.Entity.*;

public class VendorDetailsDTO {
    private Vendor vendor;
    private Address address;
    private BankDetails bankDetails;
    private ContactPerson contactPerson;
    private VendorOtherDetails vendorOtherDetails;

    // Constructor
    public VendorDetailsDTO(Vendor vendor, Address address, BankDetails bankDetails,
                            ContactPerson contactPerson, VendorOtherDetails vendorOtherDetails) {
        this.vendor = vendor;
        this.address = address;
        this.bankDetails = bankDetails;
        this.contactPerson = contactPerson;
        this.vendorOtherDetails = vendorOtherDetails;

        // Optionally set relationships only if required
        // Remove the following lines if causing circular references
        // if (this.bankDetails != null) this.bankDetails.setVendor(null);
        // if (this.address != null) this.address.setVendor(null);
        // if (this.contactPerson != null) this.contactPerson.setVendor(null);
        // if (this.vendorOtherDetails != null) this.vendorOtherDetails.setVendor(null);
    }

    // Getters and Setters
    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public BankDetails getBankDetails() { return bankDetails; }
    public void setBankDetails(BankDetails bankDetails) { this.bankDetails = bankDetails; }

    public ContactPerson getContactPerson() { return contactPerson; }
    public void setContactPerson(ContactPerson contactPerson) { this.contactPerson = contactPerson; }

    public VendorOtherDetails getVendorOtherDetails() { return vendorOtherDetails; }
    public void setVendorOtherDetails(VendorOtherDetails vendorOtherDetails) { this.vendorOtherDetails = vendorOtherDetails; }
}
