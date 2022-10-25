package com.optimagrowth.organization.controller;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "v1/organization")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @RolesAllowed({"ADMIN","USER"})
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @RolesAllowed({"ADMIN","USER"})
    @PutMapping()
    public void updateOrganization(@RequestBody Organization organization) {
        service.update(organization);
    }

    @RolesAllowed({"ADMIN","USER"})
    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(service.create(organization));
    }
    @RolesAllowed("ADMIN")
    @DeleteMapping(value = "/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable String organizationId) {
        service.delete(organizationId);
    }
}
