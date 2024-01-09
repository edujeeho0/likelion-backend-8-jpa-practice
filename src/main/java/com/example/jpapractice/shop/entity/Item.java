package com.example.jpapractice.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;
    @Setter
    private Integer price;

    @ManyToOne
    private Shop shop;

    @OneToMany(mappedBy = "item")
    private final List<Option> options = new ArrayList<>();

    public Item(String name, Integer price, Shop shop) {
        this.name = name;
        this.price = price;
        this.shop = shop;
    }
}
