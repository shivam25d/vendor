package com.vendor.Vendor_Insight.Repositories;

import com.vendor.Vendor_Insight.Entity.VendorOtherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorOtherDetailsRepository extends JpaRepository<VendorOtherDetails, Long> {
    List<VendorOtherDetails> findByVendorVendorId(Long vendorId);
}
