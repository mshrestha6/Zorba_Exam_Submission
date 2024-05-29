package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="item_type")

public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_type_id")
    private Integer itemTypeId;

    @Column(name="item_type")
    private String itemType;





}
