package com.optimagrowth.license.service.client;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.optimagrowth.license.model.Organization;

@Component
public class OrganizationRestTemplateClient {

    @Value("${gateway.port}")
    private String gatewayPort;

    @Value("${gateway.service-name}")
    private String gatewayServiceName;
    private final KeycloakRestTemplate restTemplate;

    public OrganizationRestTemplateClient(KeycloakRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        String.format("http://%s:%s/organization/v1/organization/{organizationId}", gatewayServiceName, gatewayPort),
                        HttpMethod.GET,
                        null, Organization.class, organizationId);
        return restExchange.getBody();
    }
}