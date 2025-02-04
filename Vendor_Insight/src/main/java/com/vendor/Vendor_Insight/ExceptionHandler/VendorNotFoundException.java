package com.vendor.Vendor_Insight.ExceptionHandler;


public class VendorNotFoundException extends RuntimeException {
    public VendorNotFoundException(String message) {
        super(message);
    }
}
