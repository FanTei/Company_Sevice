package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

public interface LicenseService {
    public License getLicense(String licenseId, String organizationId);
    public String createLicense(License license, String organizationId);
    public String updateLicense(License license, String organizationId);

    public String deleteLicense(String licenseId, String organizationId);
}
