package com.example.jpapractice.book;

import com.example.jpapractice.book.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("new")
    public String newAuthor() {
        return "book/author/new";
    }

    @PostMapping
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("debut")
            Integer debut
    ) {
        authorService.create(new AuthorDto(name, debut));
        return "redirect:/book/new";
    }

    @GetMapping("{id}")
    public String read(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("author", authorService.read(id));
        return "book/author/read";
    }
}
