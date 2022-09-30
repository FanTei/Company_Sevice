package com.optimagrowth.license.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

//POJO object
@Data
@Entity
@Table(name = "licenses")
public class License extends RepresentationModel<License> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "license_id", nullable = false)
    private String licenseId;

    private String description;

    @Column(name = "organization_id", nullable = false)
    private String organizationId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "license_type", nullable = false)
    private String licenseType;

    @Column(name = "comment")
    private String comment;

    public License withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
