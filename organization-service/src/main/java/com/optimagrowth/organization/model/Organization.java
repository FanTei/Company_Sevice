package com.optimagrowth.organization.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "organizations")
public class Organization {

    @Id
    @Column(name = "organization_id", nullable = false)
    String organizationId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "contact_name", nullable = false)
    String contactName;

    @Column(name = "contact_email", nullable = false)
    String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    String contactPhone;
}
