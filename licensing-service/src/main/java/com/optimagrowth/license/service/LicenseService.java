package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface LicenseService {
    public License getLicense(String licenseId, String organizationId, String clientType);

    public License createLicense(License license);

    public License updateLicense(License license);

    public String deleteLicense(String licenseId);

    public List<License> getLicensesByOrganization(String organizationId) throws TimeoutException;
}
