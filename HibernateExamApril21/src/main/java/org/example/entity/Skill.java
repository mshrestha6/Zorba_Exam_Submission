package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="Skill")

public class Skill {

    @Column(name="skill_id",length=10)
    private Integer id;

    @Column(name="skill_name",length=100)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
