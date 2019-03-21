package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rveizaga
 */
@Getter
@Setter
@Document
public class Employee extends GenericDomain {

    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private long phone;
    private String email;
    private String jobDescription;
}