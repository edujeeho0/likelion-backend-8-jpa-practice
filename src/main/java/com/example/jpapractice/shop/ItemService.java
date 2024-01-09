package com.example.jpapractice.shop;

import com.example.jpapractice.shop.dto.ItemDto;
import com.example.jpapractice.shop.entity.Item;
import com.example.jpapractice.shop.entity.Shop;
import com.example.jpapractice.shop.repo.ItemRepository;
import com.example.jpapractice.shop.repo.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;

    public ItemDto create(Long shopId, ItemDto dto) {
        Shop shop = shopRepository.findById(shopId).orElseThrow();
        Item item = new Item(
                dto.getName(),
                dto.getPrice(),
                shop
        );
        return ItemDto.fromEntity(itemRepository.save(item));
    }


    public ItemDto read(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        return ItemDto.fromEntity(item);
    }

    public ItemDto update(Long id, ItemDto dto) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        return ItemDto.fromEntity(itemRepository.save(item));
    }

    public void delete(Long id) {
        itemRepository.delete(itemRepository.findById(id).orElseThrow());
    }
}
