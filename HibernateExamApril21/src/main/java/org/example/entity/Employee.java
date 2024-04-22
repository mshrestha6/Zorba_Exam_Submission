package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="Employee")
public class Employee {

    @Column(name="employee_id",length = 20)
    private Integer employeeId;

    @Column(name="employee_name",length=255)
    private String employeeName;

    @Column(name="employee_address",length = 255)
    private String employeeAddress;

    @Column(name="employee_email",length = 255)
    private String employeeEmail;

    @Column(name="employee_experience",length=20)
    private Integer employeeExperience;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="employee_skill",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="skill_id")
    )
    private Set<Skill> skills;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeExperience=" + employeeExperience +
                '}';
    }
}
