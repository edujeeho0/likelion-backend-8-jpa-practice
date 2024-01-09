package com.example.jpapractice.shop;

import com.example.jpapractice.shop.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping("new")
    public String newShop() {
        return "shop/new";
    }

    @PostMapping
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("homepage")
            String homepage
    ) {
        Long newId = shopService.create(new ShopDto(name, homepage)).getId();
        return String.format("redirect:/shop/%d", newId);
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("shops", shopService.readAll());
        return "shop/index";
    }

    @GetMapping("{id}")
    public String read(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("shop", shopService.read(id));
        return "shop/read";
    }

    @GetMapping("{id}/edit")
    public String edit(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("shop", shopService.read(id));
        return "shop/edit";
    }

    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("name")
            String name,
            @RequestParam("homepage")
            String homepage
    ) {
        shopService.update(id, new ShopDto(name, homepage));
        return String.format("redirect:/shop/%d", id);
    }

    @PostMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ) {
        shopService.delete(id);
        return "redirect:/shop";
    }
}
