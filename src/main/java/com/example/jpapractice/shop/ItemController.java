package com.example.jpapractice.shop;

import com.example.jpapractice.shop.dto.ItemDto;
import com.example.jpapractice.shop.dto.OptionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("shop/{shopId}/item")
@RequiredArgsConstructor
public class ItemController {
    private final ShopService shopService;
    private final ItemService itemService;
    private final OptionService optionService;

    @GetMapping("{itemId}")
    public String itemDetails(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            Model model
    ) {
        model.addAttribute("item", itemService.read(itemId));
        model.addAttribute("shopId", shopId);
        return "shop/item/read";
    }

    @GetMapping("add")
    public String addItem(
            @PathVariable("shopId")
            Long shopId,
            Model model
    ) {
        model.addAttribute("shop", shopService.read(shopId));
        return "shop/item/add";
    }

    @PostMapping
    public String createItem(
            @PathVariable("shopId")
            Long shopId,
            @RequestParam("name")
            String name,
            @RequestParam("price")
            Integer price
    ) {
        itemService.create(shopId, new ItemDto(name, price));
        return String.format("redirect:/shop/%d", shopId);
    }

    @GetMapping("{itemId}/edit")
    public String editItem(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            Model model
    ) {
        model.addAttribute("shopId", shopId);
        model.addAttribute("item", itemService.read(itemId));
        return "shop/item/edit";
    }

    @PostMapping("{itemId}/update")
    public String updateItem(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            @RequestParam("name")
            String name,
            @RequestParam("price")
            Integer price

    ) {
        itemService.update(itemId, new ItemDto(name, price));
        return String.format("redirect:/shop/%d/item/%d", shopId, itemId);
    }

    @PostMapping("{itemId}/delete")
    public String deleteItem(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId
    ) {
        itemService.delete(itemId);
        return String.format("redirect:/shop/%d", shopId);
    }

    @GetMapping("{itemId}/option/add")
    public String addItemOption(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            Model model
    ) {
        model.addAttribute("shopId", shopId);
        model.addAttribute("item", itemService.read(itemId));
        return "shop/item/option/add";
    }

    @PostMapping("{itemId}/option")
    public String createItemOption(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            @RequestParam("desc")
            String desc,
            @RequestParam("add-price")
            Integer addPrice
    ) {
        optionService.create(itemId, new OptionDto(desc, addPrice));
        return String.format("redirect:/shop/%d/item/%d", shopId, itemId);
    }

    @PostMapping("{itemId}/option/{optionId}/delete")
    public String deleteItemOption(
            @PathVariable("shopId")
            Long shopId,
            @PathVariable("itemId")
            Long itemId,
            @PathVariable("optionId")
            Long optionId
    ) {
        optionService.delete(optionId);
        return String.format("redirect:/shop/%d/item/%d", shopId, itemId);
    }
}
