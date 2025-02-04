package com.vendor.Vendor_Insight.Repositories;
import com.vendor.Vendor_Insight.Entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    List<BankDetails> findByVendorVendorId(Long vendorId);
}
