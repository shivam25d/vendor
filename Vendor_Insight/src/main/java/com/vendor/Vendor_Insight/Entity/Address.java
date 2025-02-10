package com.vendor.Vendor_Insight.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", nullable = false)
    private Vendor vendor;

    @Column(name = "billing_attention")
    private String billingAttention;

    @Column(name = "billing_country_region")
    private String billingCountryRegion;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "billing_street1")
    private String billingStreet1;

    @Column(name = "billing_street2")
    private String billingStreet2;

    @Column(name = "billing_city")
    private String billingCity;

    @Column(name = "billing_state")
    private String billingState;

    @Column(name = "billing_pin_code")
    private String billingPinCode;

    @Column(name = "billing_phone")
    private String billingPhone;

    @Column(name = "billing_fax_number")
    private String billingFaxNumber;

    @Column(name = "shipping_attention")
    private String shippingAttention;

    @Column(name = "shipping_country_region")
    private String shippingCountryRegion;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_street1")
    private String shippingStreet1;

    @Column(name = "shipping_street2")
    private String shippingStreet2;

    @Column(name = "shipping_city")
    private String shippingCity;

    @Column(name = "shipping_state")
    private String shippingState;

    @Column(name = "shipping_pin_code")
    private String shippingPinCode;

    @Column(name = "shipping_phone")
    private String shippingPhone;

    @Column(name = "shipping_fax_number")
    private String shippingFaxNumber;

    // Getters and Setters

    public Long getAddressId() {
        return addressId;
    }


    public void setaddressId(Long id) {
        this.addressId = id;
    }

    public String getBillingAttention() {
        return billingAttention;
    }

    public void setBillingAttention(String billingAttention) {
        this.billingAttention = billingAttention;
    }

    public String getBillingCountryRegion() {
        return billingCountryRegion;
    }

    public void setBillingCountryRegion(String billingCountryRegion) {
        this.billingCountryRegion = billingCountryRegion;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingStreet1() {
        return billingStreet1;
    }

    public void setBillingStreet1(String billingStreet1) {
        this.billingStreet1 = billingStreet1;
    }

    public String getBillingStreet2() {
        return billingStreet2;
    }

    public void setBillingStreet2(String billingStreet2) {
        this.billingStreet2 = billingStreet2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingPinCode() {
        return billingPinCode;
    }

    public void setBillingPinCode(String billingPinCode) {
        this.billingPinCode = billingPinCode;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingFaxNumber() {
        return billingFaxNumber;
    }

    public void setBillingFaxNumber(String billingFaxNumber) {
        this.billingFaxNumber = billingFaxNumber;
    }

    public String getShippingAttention() {
        return shippingAttention;
    }

    public void setShippingAttention(String shippingAttention) {
        this.shippingAttention = shippingAttention;
    }

    public String getShippingCountryRegion() {
        return shippingCountryRegion;
    }

    public void setShippingCountryRegion(String shippingCountryRegion) {
        this.shippingCountryRegion = shippingCountryRegion;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingStreet1() {
        return shippingStreet1;
    }

    public void setShippingStreet1(String shippingStreet1) {
        this.shippingStreet1 = shippingStreet1;
    }

    public String getShippingStreet2() {
        return shippingStreet2;
    }

    public void setShippingStreet2(String shippingStreet2) {
        this.shippingStreet2 = shippingStreet2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingPinCode() {
        return shippingPinCode;
    }

    public void setShippingPinCode(String shippingPinCode) {
        this.shippingPinCode = shippingPinCode;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingFaxNumber() {
        return shippingFaxNumber;
    }

    public void setShippingFaxNumber(String shippingFaxNumber) {
        this.shippingFaxNumber = shippingFaxNumber;
    }

    public void setVendor(Vendor savedVendor) {

    }
}
