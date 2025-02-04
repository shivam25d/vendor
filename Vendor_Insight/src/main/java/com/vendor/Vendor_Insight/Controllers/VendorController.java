package com.vendor.Vendor_Insight.Controllers;

import com.vendor.Vendor_Insight.Entity.*;
import com.vendor.Vendor_Insight.ExceptionHandler.VendorNotFoundException;
import com.vendor.Vendor_Insight.Services.VendorService;
import com.vendor.Vendor_Insight.DTO.VendorDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.saveVendor(vendor);
        return ResponseEntity.ok(savedVendor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + id + " not found"));
        return ResponseEntity.ok(vendor);
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        Vendor existingVendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + id + " not found"));

        existingVendor.updateFrom(updatedVendor);
        Vendor savedVendor = vendorService.saveVendor(existingVendor);
        return ResponseEntity.ok(savedVendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        Vendor existingVendor = vendorService.getVendorById(id)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + id + " not found"));
        vendorService.deleteVendor(existingVendor.getVendorId());
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/addresses/{vendorId}/")
    public ResponseEntity<Address> addAddress(@PathVariable Long vendorId, @RequestBody Address address) {
        Address savedAddress = vendorService.addAddressToVendor(vendorId, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }



    @PostMapping("/bank-details/{vendorId}/")
    public ResponseEntity<BankDetails> addBankDetails(@PathVariable Long vendorId, @RequestBody BankDetails bankDetails) {
        BankDetails savedBankDetails = vendorService.addBankDetailsToVendor(vendorId, bankDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBankDetails);
    }



    @PostMapping("/contact-persons/{vendorId}/")
    public ResponseEntity<ContactPerson> addContactPerson(@PathVariable Long vendorId, @RequestBody ContactPerson contactPerson) {
        ContactPerson savedContactPerson = vendorService.addContactPersonToVendor(vendorId, contactPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContactPerson);
    }



    @PostMapping("/vendor-other-details/{vendorId}/")
    public ResponseEntity<VendorOtherDetails> addVendorOtherDetails(@PathVariable Long vendorId, @RequestBody VendorOtherDetails otherDetails) {
        VendorOtherDetails savedOtherDetails = vendorService.addOtherDetailsToVendor(vendorId, otherDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOtherDetails);
    }




    @PostMapping("/documents/{vendorId}/")
    public ResponseEntity<Map<String, String>> uploadDocuments(
            @PathVariable Long vendorId,
            @RequestParam("pan") MultipartFile pan,
            @RequestParam("gst") MultipartFile gst,
            @RequestParam("professionalTax") MultipartFile professionalTax,
            @RequestParam("providentFund") MultipartFile providentFund,
            @RequestParam("ecis") MultipartFile ecis,
            @RequestParam("udyam") MultipartFile udyam,
            @RequestParam("incorporation") MultipartFile incorporation,
            @RequestParam("tan") MultipartFile tan,
            @RequestParam("vendorForm") MultipartFile vendorForm
    ) throws IOException {
        Map<String, String> uploadedFiles = vendorService.uploadDocumentsToVendor(
                vendorId, pan, gst, professionalTax, providentFund, ecis, udyam, incorporation, tan, vendorForm
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(uploadedFiles);
    }


    @GetMapping("/addresses/{vendorId}")
    public ResponseEntity<List<Address>> getAddressesByVendorId(@PathVariable Long vendorId) {
        List<Address> addresses = vendorService.getAddressesByVendorId(vendorId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/bank-details/{vendorId}")
    public ResponseEntity<List<BankDetails>> getBankDetailsByVendorId(@PathVariable Long vendorId) {
        List<BankDetails> bankDetails = vendorService.getBankDetailsByVendorId(vendorId);
        return ResponseEntity.ok(bankDetails);
    }

    @GetMapping("/contact-persons/{vendorId}")
    public ResponseEntity<List<ContactPerson>> getContactPersonsByVendorId(@PathVariable Long vendorId) {
        List<ContactPerson> contactPersons = vendorService.getContactPersonsByVendorId(vendorId);
        return ResponseEntity.ok(contactPersons);
    }

    @GetMapping("/documents/{vendorId}")
    public ResponseEntity<List<OtherDocuments>> getDocumentsByVendorId(@PathVariable Long vendorId) {
        List<OtherDocuments> documents = vendorService.getDocumentsByVendorId(vendorId);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/vendor-other-details/{vendorId}")
    public ResponseEntity<List<VendorOtherDetails>> getOtherDetailsByVendorId(@PathVariable Long vendorId) {
        List<VendorOtherDetails> otherDetails = vendorService.getOtherDetailsByVendorId(vendorId);
        return ResponseEntity.ok(otherDetails);
    }

}

