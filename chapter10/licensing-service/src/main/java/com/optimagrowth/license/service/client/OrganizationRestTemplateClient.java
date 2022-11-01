package com.optimagrowth.license.service.client;

import com.optimagrowth.license.repository.OrganizationRedisRepository;
import com.optimagrowth.license.utils.UserContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.optimagrowth.license.model.Organization;

@Component
public class OrganizationRestTemplateClient {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationRestTemplateClient.class);
    @Value("${gateway.port}")
    private String gatewayPort;

    @Value("${gateway.service-name}")
    private String gatewayServiceName;
    private final KeycloakRestTemplate restTemplate;

//    private final OrganizationRedisRepository redisRepository;

    public OrganizationRestTemplateClient(KeycloakRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Organization getOrganization(String organizationId) {
        logger.debug("In Licensing Service.getOrganization: {}", UserContext.getCorrelationId());
        Organization organization = checkRedisCache(organizationId);
        if (organization != null) {
            logger.debug("I have successfully retrieved an organization {} from the redis cache: {}", organizationId, organization);
            return organization;
        }
        logger.debug("Unable to locate organization from the redis cache: {}.", organizationId);
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        String.format("http://%s:%s/organization/v1/organization/{organizationId}", gatewayServiceName, gatewayPort),
                        HttpMethod.GET,
                        null, Organization.class, organizationId);
        organization = restExchange.getBody();
        if (organization != null) {
            cacheOrganizationObject(organization);
        }
        return restExchange.getBody();
    }

    private Organization checkRedisCache(String organizationId) {
//        try {
//            return redisRepository.findById(organizationId).orElse(null);
//        } catch (Exception ex) {
//            logger.error("Error encountered while trying to retrieve organization {} check Redis Cache.  Exception {}", organizationId, ex);
//            return null;
//        }
        return null;
    }

    private void cacheOrganizationObject(Organization organization) {
//        try {
//            redisRepository.save(organization);
//        } catch (Exception ex) {
//            logger.error("Unable to cache organization {} in Redis. Exception {}", organization.getId(), ex);
//        }
    }
}