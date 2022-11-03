package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface LicenseService {
    License getLicense(String licenseId, String organizationId, String clientType);

    License createLicense(License license);

    License updateLicense(License license);

    String deleteLicense(String licenseId);

    List<License> getLicensesByOrganization(String organizationId) throws TimeoutException;
}
