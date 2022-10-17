package com.optimagrowth.organization.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "organization_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "contact_name",nullable = false)
    String contactName;

    @Column(name = "contact_email",nullable = false)
    String contactEmail;

    @Column(name = "contact_phone",nullable = false)
    String contactPhone;
}
