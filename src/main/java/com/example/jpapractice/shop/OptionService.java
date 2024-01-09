package com.example.jpapractice.shop;

import com.example.jpapractice.shop.dto.OptionDto;
import com.example.jpapractice.shop.entity.Item;
import com.example.jpapractice.shop.entity.Option;
import com.example.jpapractice.shop.repo.ItemRepository;
import com.example.jpapractice.shop.repo.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OptionService {
    private final ItemRepository itemRepository;
    private final OptionRepository optionRepository;

    public OptionDto create(Long itemId, OptionDto dto) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        Option option = new Option(
                dto.getDesc(),
                dto.getAddPrice(),
                item
        );

        return OptionDto.fromEntity(optionRepository.save(option));
    }

    public void delete(Long optionId) {
        optionRepository.delete(optionRepository.findById(optionId).orElseThrow());
    }
}
