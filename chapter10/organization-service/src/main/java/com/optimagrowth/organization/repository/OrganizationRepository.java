package com.optimagrowth.organization.repository;

import com.optimagrowth.organization.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
    Optional<Organization> findByOrganizationId(String organizationId);

    void deleteByOrganizationId(String organizationId);
}
