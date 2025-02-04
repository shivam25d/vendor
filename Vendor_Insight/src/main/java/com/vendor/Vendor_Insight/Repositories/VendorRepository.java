package com.vendor.Vendor_Insight.Repositories;

import com.vendor.Vendor_Insight.Entity.Vendor;
import com.vendor.Vendor_Insight.DTO.VendorDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    @Query("SELECT new com.vendor.Vendor_Insight.DTO.VendorDetailsDTO(v, a, b, c, o) " +
            "FROM Vendor v " +
            "LEFT JOIN Address a ON v.vendorId = a.vendor.vendorId " +
            "LEFT JOIN BankDetails b ON v.vendorId = b.vendor.vendorId " +
            "LEFT JOIN ContactPerson c ON v.vendorId = c.vendor.vendorId " +
            "LEFT JOIN VendorOtherDetails o ON v.vendorId = o.vendor.vendorId " +
            "WHERE v.vendorId = :vendorId")
    VendorDetailsDTO getVendorDetailsById(@Param("vendorId") Long vendorId);
}



