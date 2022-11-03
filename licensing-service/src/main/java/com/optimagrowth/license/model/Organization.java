package com.optimagrowth.license.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class Organization extends RepresentationModel<Organization> {
    @Id
    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
}
