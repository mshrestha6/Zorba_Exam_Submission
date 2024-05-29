package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="items_info")

public class ItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_quantity")
    private Integer itemQuantity;

    @Column(name="item_price")
    private Double itemPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

}
