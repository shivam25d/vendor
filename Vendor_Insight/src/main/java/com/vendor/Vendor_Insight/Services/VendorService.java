package com.vendor.Vendor_Insight.Services;

import com.vendor.Vendor_Insight.DTO.VendorDetailsDTO;
import com.vendor.Vendor_Insight.Entity.*;
import com.vendor.Vendor_Insight.ExceptionHandler.VendorNotFoundException;
import com.vendor.Vendor_Insight.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;
    private final BankDetailsRepository bankDetailsRepository;
    private final VendorOtherDetailsRepository vendorOtherDetailsRepository;
    private final ContactPersonRepository contactPersonRepository;
    private final OtherDocumentsRepository otherDocumentsRepository;

    private final String uploadDir ="C:\\uploads";

    public VendorService(
            VendorRepository vendorRepository,
            AddressRepository addressRepository,
            BankDetailsRepository bankDetailsRepository,
            VendorOtherDetailsRepository vendorOtherDetailsRepository,
            ContactPersonRepository contactPersonRepository,
            OtherDocumentsRepository otherDocumentsRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
        this.bankDetailsRepository = bankDetailsRepository;
        this.vendorOtherDetailsRepository = vendorOtherDetailsRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.otherDocumentsRepository = otherDocumentsRepository;
    }

    // Handle document upload and save paths in the database
    public Map<String, String> uploadDocumentsToVendor(
            Long vendorId,
            MultipartFile pan,
            MultipartFile gst,
            MultipartFile professionalTax,
            MultipartFile providentFund,
            MultipartFile ecis,
            MultipartFile udyam,
            MultipartFile incorporation,
            MultipartFile tan,
            MultipartFile vendorForm
    ) throws IOException {
        // Retrieve the vendor by ID
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));

        // Ensure the directory for storing files exists
        Path uploadPath = Paths.get(uploadDir, String.valueOf(vendorId));
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Map to store saved file paths
        Map<String, String> savedFilePaths = new HashMap<>();

        // Save each file and store the document paths
        savedFilePaths.put("PAN", saveFile(uploadPath, pan));
        savedFilePaths.put("GST", saveFile(uploadPath, gst));
        savedFilePaths.put("ProfessionalTax", saveFile(uploadPath, professionalTax));
        savedFilePaths.put("ProvidentFund", saveFile(uploadPath, providentFund));
        savedFilePaths.put("ECIS", saveFile(uploadPath, ecis));
        savedFilePaths.put("Udyam", saveFile(uploadPath, udyam));
        savedFilePaths.put("Incorporation", saveFile(uploadPath, incorporation));
        savedFilePaths.put("TAN", saveFile(uploadPath, tan));
        savedFilePaths.put("VendorForm", saveFile(uploadPath, vendorForm));

        // Iterate over the saved file paths and persist each document to the database
        for (Map.Entry<String, String> entry : savedFilePaths.entrySet()) {
            OtherDocuments document = new OtherDocuments();
            document.setVendor(vendor); // Associate with the vendor
            document.setDocumentName(entry.getKey()); // Store the document name (e.g., "PAN")
            document.setDocumentPath(entry.getValue()); // Store the file path

            // Save the document in the database
            otherDocumentsRepository.save(document);
        }

        // Return the map of saved file paths
        return savedFilePaths;
    }

    public Vendor saveVendorWithDetails(Vendor vendor) {
        // Save the vendor first to generate vendorId
        Vendor savedVendor = vendorRepository.save(vendor);

        // Assign vendor to related entities BEFORE saving them
        if (vendor.getAddresses() != null) {
            for (Address address : vendor.getAddresses()) {
                address.setVendor(savedVendor); // Set the vendor reference
            }
            addressRepository.saveAll(vendor.getAddresses()); // Save addresses
        }

        if (vendor.getContactPersons() != null) {
            for (ContactPerson contactPerson : vendor.getContactPersons()) {
                contactPerson.setVendorId(savedVendor); // Set the vendor reference
            }
            contactPersonRepository.saveAll(vendor.getContactPersons()); // Save contact persons
        }

        if (vendor.getBankDetails() != null) {
            vendor.getBankDetails().setVendor(savedVendor); // Set the vendor reference
            bankDetailsRepository.save(vendor.getBankDetails()); // Save bank details
        }

        if (vendor.getVendorOtherDetails() != null) {
            vendor.getVendorOtherDetails().setVendor(savedVendor); // Set the vendor reference
            vendorOtherDetailsRepository.save(vendor.getVendorOtherDetails()); // Save other details
        }

        // Return the saved vendor
        return savedVendor;
    }


    // Helper method to save file to disk and return the file path
    private String saveFile(Path uploadPath, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.isEmpty()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            return filePath.toString();
        } else {
            throw new IOException("Invalid file name for " + file.getName());
        }
    }

    public VendorDetailsDTO getVendorDetailsById(Long id) {
        VendorDetailsDTO vendorDetails = vendorRepository.getVendorDetailsById(id);
        if (vendorDetails == null) {
            throw new VendorNotFoundException("Vendor with ID " + id + " not found");
        }
        return vendorDetails;
    }

    public Address addAddressToVendor(Long vendorId, Address address) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));
        vendor.addAddress(address); // Use the helper method to set the vendor reference
        return addressRepository.save(address);
    }

    public BankDetails addBankDetailsToVendor(Long vendorId, BankDetails bankDetails) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));
        vendor.setBankDetails(bankDetails); // Use the helper method to set the vendor reference
        return bankDetailsRepository.save(bankDetails);
    }


    public ContactPerson addContactPersonToVendor(Long vendorId, ContactPerson contactPerson) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));
        vendor.addContactPerson(contactPerson); // Use the helper method to set the vendor reference
        return contactPersonRepository.save(contactPerson);
    }

    public VendorOtherDetails addOtherDetailsToVendor(Long vendorId, VendorOtherDetails otherDetails) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));
        vendor.setVendorOtherDetails(otherDetails); // Use the helper method to set the vendor reference
        return vendorOtherDetailsRepository.save(otherDetails);
    }


    public OtherDocuments uploadDocumentsToVendor(Long vendorId, OtherDocuments document) {
        Vendor vendor = getVendorById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " not found"));
        document.setVendor(vendor);
        return otherDocumentsRepository.save(document);
    }

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }




    public List<Address> getAddressesByVendorId(Long vendorId) {
        return addressRepository.findByVendorVendorId(vendorId);
    }

    public List<BankDetails> getBankDetailsByVendorId(Long vendorId) {
        return bankDetailsRepository.findByVendorVendorId(vendorId);
    }

    public List<ContactPerson> getContactPersonsByVendorId(Long vendorId) {
        return contactPersonRepository.findByVendorVendorId(vendorId);
    }

    public List<OtherDocuments> getDocumentsByVendorId(Long vendorId) {
        return otherDocumentsRepository.findByVendorVendorId(vendorId);
    }

    public List<VendorOtherDetails> getOtherDetailsByVendorId(Long vendorId) {
        return vendorOtherDetailsRepository.findByVendorVendorId(vendorId);
    }




}
