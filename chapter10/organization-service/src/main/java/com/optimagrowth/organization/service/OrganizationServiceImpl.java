package com.optimagrowth.organization.service;

import com.optimagrowth.organization.events.source.SimpleSourceBean;
import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository repository;

    private final SimpleSourceBean simpleSourceBean;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, SimpleSourceBean simpleSourceBean) {
        this.repository = organizationRepository;
        this.simpleSourceBean = simpleSourceBean;
    }

    @Override
    public Organization findById(String organizationId) {
        Optional<Organization> opt = repository.findByOrganizationId(organizationId);
        simpleSourceBean.publishOrganizationChange("GET",organizationId);
        return opt.orElse(null);
    }

    @Override
    public Organization create(Organization organization) {
        organization.setOrganizationId(UUID.randomUUID().toString());
        organization = repository.save(organization);
        simpleSourceBean.publishOrganizationChange("SAVE", organization.getOrganizationId());
        return organization;
    }

    @Override
    public void update(Organization organization) {
        repository.save(organization);
        simpleSourceBean.publishOrganizationChange("UPDATE", organization.getOrganizationId());
    }

    @Transactional
    @Override
    public void delete(String organizationId) {
        repository.deleteByOrganizationId(organizationId);
        simpleSourceBean.publishOrganizationChange("DELETE", organizationId);
    }
}
