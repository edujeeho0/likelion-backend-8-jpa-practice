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
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;
    @Setter
    private String homepage;

    @OneToMany(mappedBy = "shop")
    private final List<Item> items = new ArrayList<>();

    public Shop(String name, String homepage) {
        this.name = name;
        this.homepage = homepage;
    }
}
