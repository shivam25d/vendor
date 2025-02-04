package com.vendor.Vendor_Insight.Repositories;
import com.vendor.Vendor_Insight.Entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
    List<ContactPerson> findByVendorVendorId(Long vendorId);
}
