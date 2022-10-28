package com.optimagrowth.license.repository;

import com.optimagrowth.license.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

    public List<License> findByOrganizationId(String organizationId);

    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
