package com.vendor.Vendor_Insight.Repositories;

import com.vendor.Vendor_Insight.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByVendorVendorId(Long vendorId);
}
