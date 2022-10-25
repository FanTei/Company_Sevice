package com.optimagrowth.organization.service;

import com.optimagrowth.organization.model.Organization;

public interface OrganizationService {
    Organization findById(String organizationId);

    Organization create(Organization organization);

    void update(Organization organization);

    void delete(String organization);
}
