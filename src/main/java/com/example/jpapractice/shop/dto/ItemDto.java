package com.example.jpapractice.shop.dto;

import com.example.jpapractice.shop.entity.Item;
import com.example.jpapractice.shop.entity.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ItemDto {
    private Long id;
    @Setter
    private String name;
    @Setter
    private Integer price;
    private final List<OptionDto> options = new ArrayList<>();

    public ItemDto(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static ItemDto fromEntity(Item entity) {
        ItemDto dto = new ItemDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.price = entity.getPrice();
        for (Option option: entity.getOptions()) {
            dto.options.add(OptionDto.fromEntity(option));
        }
        return dto;
    }
}
