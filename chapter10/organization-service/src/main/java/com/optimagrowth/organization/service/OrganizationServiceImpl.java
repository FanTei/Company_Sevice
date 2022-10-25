package com.optimagrowth.organization.service;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository repository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.repository = organizationRepository;
    }

    @Override
    public Organization findById(String organizationId) {
        Optional<Organization> opt = repository.findByOrganizationId(organizationId);
        return opt.orElse(null);
    }

    @Override
    public Organization create(Organization organization) {
        organization = repository.save(organization);
        return organization;
    }

    @Override
    public void update(Organization organization) {
        repository.save(organization);
    }

    @Transactional
    @Override
    public void delete(String organizationId) {
        repository.deleteByOrganizationId(organizationId);
    }
}
