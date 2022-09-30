package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

import java.util.Locale;

public interface LicenseService {
    public License getLicense(String licenseId, String organizationId);

    public License createLicense(License license);

    public License updateLicense(License license);

    public String deleteLicense(String licenseId);
}
