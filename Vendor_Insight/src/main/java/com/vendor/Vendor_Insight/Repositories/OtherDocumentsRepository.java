package com.vendor.Vendor_Insight.Repositories;

import com.vendor.Vendor_Insight.Entity.OtherDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherDocumentsRepository extends JpaRepository<OtherDocuments, Long> {
    List<OtherDocuments> findByVendorVendorId(Long vendorId);
}

