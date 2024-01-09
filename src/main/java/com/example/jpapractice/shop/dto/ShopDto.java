package com.example.jpapractice.shop.dto;

import com.example.jpapractice.shop.entity.Item;
import com.example.jpapractice.shop.entity.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ShopDto {
    private Long id;
    @Setter
    private String name;
    @Setter
    private String homepage;
    private final List<ItemDto> items = new ArrayList<>();

    public ShopDto(String name, String homepage) {
        this.name = name;
        this.homepage = homepage;
    }

    public static ShopDto fromEntity(Shop entity) {
        ShopDto dto = new ShopDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.homepage = entity.getHomepage();
        for (Item item: entity.getItems()) {
            dto.items.add(ItemDto.fromEntity(item));
        }
        return dto;
    }
}
