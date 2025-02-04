package com.vendor.Vendor_Insight.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "vendor_other_details")
public class VendorOtherDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gst_treatment")
    private String gstTreatment;

    @Column(name = "source_of_supply")
    private String sourceOfSupply;

    @Column(name = "pan")
    private String pan;

    @Column(name = "currency")
    private String currency;

    @Column(name = "opening_balance")
    private Double openingBalance;

    @Column(name = "payment_terms")
    private String paymentTerms;

    @Column(name = "tds")
    private String tds;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    // Getters and Setters

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGstTreatment() {
        return gstTreatment;
    }

    public void setGstTreatment(String gstTreatment) {
        this.gstTreatment = gstTreatment;
    }

    public String getSourceOfSupply() {
        return sourceOfSupply;
    }

    public void setSourceOfSupply(String sourceOfSupply) {
        this.sourceOfSupply = sourceOfSupply;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public Vendor getVendor() {
        return vendor;
    }

}
