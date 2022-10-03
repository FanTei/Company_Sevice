package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

public interface LicenseService {
    public License getLicense(String licenseId, String organizationId, String clientType);

    public License createLicense(License license);

    public License updateLicense(License license);

    public String deleteLicense(String licenseId);
}
