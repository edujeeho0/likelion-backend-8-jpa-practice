package com.example.jpapractice.shop.dto;

import com.example.jpapractice.shop.entity.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class OptionDto {
    private Long id;
    @Setter
    private String desc;
    @Setter
    private Integer addPrice;

    public OptionDto(String desc, Integer addPrice) {
        this.desc = desc;
        this.addPrice = addPrice;
    }


    public static OptionDto fromEntity(Option entity) {
        OptionDto dto = new OptionDto();
        dto.id = entity.getId();
        dto.desc = entity.getDesc();
        dto.addPrice = entity.getAddPrice();
        return dto;
    }
}
