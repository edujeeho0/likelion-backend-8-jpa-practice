package com.example.jpapractice.shop;

import com.example.jpapractice.shop.dto.ShopDto;
import com.example.jpapractice.shop.entity.Shop;
import com.example.jpapractice.shop.repo.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopDto create(ShopDto dto) {
        Shop shop = new Shop(
                dto.getName(), dto.getHomepage()
        );
        return ShopDto.fromEntity(shopRepository.save(shop));
    }

    public List<ShopDto> readAll() {
        List<ShopDto> shops = new ArrayList<>();
        for (Shop shop: shopRepository.findAll())
            shops.add(ShopDto.fromEntity(shop));

        return shops;
    }

    public ShopDto read(Long id) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow();

        return ShopDto.fromEntity(shop);
    }

    public ShopDto update(Long id, ShopDto dto) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        shop.setName(dto.getName());
        shop.setHomepage(dto.getHomepage());

        return ShopDto.fromEntity(shopRepository.save(shop));
    }

    public void delete(Long id) {
        shopRepository.delete(shopRepository.findById(id).orElseThrow());
    }
}
