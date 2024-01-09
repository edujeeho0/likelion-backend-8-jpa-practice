package com.example.jpapractice.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String desc;
    @Setter
    private Integer addPrice;

    @Setter
    @ManyToOne
    private Item item;

    public Option(String desc, Integer addPrice, Item item) {
        this.desc = desc;
        this.addPrice = addPrice;
        this.item = item;
    }
}
