package com.vendor.Vendor_Insight.Entity;


import jakarta.persistence.*;   
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Contact_Person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactPersonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "designation")
    private String designation;

    @Column(name = "department")
    private String department;

    public void setVendorId(Vendor savedVendor) {
    }

    public void setVendor(Vendor vendor) {
    }


    // public void setVendorId(Vendor vendor) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setVendorId'");
    // }

    // Getters and Setters
}
