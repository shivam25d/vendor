    package com.vendor.Vendor_Insight.Entity;

    import jakarta.persistence.*;


    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "vendor")
    public class Vendor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "vendor_Id")
        private Long vendorId;

        @Column(name = "category")
        private String category;

        @Column(name = "company_name")
        private String companyName;

        @Column(name = "display_name")
        private String displayName;

        @Column(name = "email_address", unique = true)
        private String emailAddress;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "mobile", unique = true)
        private String mobile;

        @Column(name = "phone")
        private String phone;

        @Column(name = "remarks")
        private String remarks;

        @Column(name = "salutation")
        private String salutation;

        @Column(name = "work_phone")
        private String workPhone;

        @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
        private List<Address> address = new ArrayList<>();

        @OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL)
        private BankDetails bankDetails;

        @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
        private List<ContactPerson> contactPersons = new ArrayList<>();

        @OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL)
        private VendorOtherDetails vendorOtherDetails;      

//    @OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private OtherDocuments otherDocuments = new OtherDocuments();


    public void setBankDetails(BankDetails bankDetails) {
        if (bankDetails != null) {
            bankDetails.setVendor(this); // Set the vendor reference to this entity
        }
        this.bankDetails = bankDetails;
    }

    public void addAddress(Address address) {
        // address.add(address);
        address.setVendor(this); // Set the vendor in the address
    }

    public void removeAddress(Address address) {
        // address.remove(address);
        address.setVendor(null);
    }

    public void addContactPerson(ContactPerson contactPerson) {
        contactPersons.add(contactPerson);
        contactPerson.setVendor(this); // Set the vendor in the contact person
    }

    public void removeContactPerson(ContactPerson contactPerson) {
        contactPersons.remove(contactPerson);
        contactPerson.setVendor(null);
    }


    public void setVendorOtherDetails(VendorOtherDetails vendorOtherDetails) {
        if (vendorOtherDetails != null) {
            vendorOtherDetails.setVendor(this);
        }
        this.vendorOtherDetails = vendorOtherDetails;
    }
//    public void addOtherDocument(OtherDocuments document) {
//        otherDocuments.add(document);
//        document.setVendor(this);
//    }
//
//    public void removeOtherDocument(OtherDocuments document) {
//        otherDocuments.remove(document);
//        document.setVendor(null);
//    }




    public void updateFrom(Vendor updatedVendor) {
        this.category = updatedVendor.category;
        this.companyName = updatedVendor.companyName;
        this.displayName = updatedVendor.displayName;
        this.emailAddress = updatedVendor.emailAddress;
        this.firstName = updatedVendor.firstName;
        this.lastName = updatedVendor.lastName;
        this.mobile = updatedVendor.mobile;
        this.phone = updatedVendor.phone;
        this.remarks = updatedVendor.remarks;
        this.salutation = updatedVendor.salutation;
        this.workPhone = updatedVendor.workPhone;
    }

    // Getters and Setters
    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> addresses) {

    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }



    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public VendorOtherDetails getVendorOtherDetails() {
        return vendorOtherDetails;
    }


}
