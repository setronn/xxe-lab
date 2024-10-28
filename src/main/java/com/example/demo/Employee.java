package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@XmlRootElement(name="employee")
public class Employee {
    @Getter @Setter private String name;
    @Getter @Setter private String role;
    @Getter @Setter private Integer id;
}
