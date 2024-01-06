package com.example.jpapractice.article;

import com.example.jpapractice.article.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public String article(Model model) {
        model.addAttribute("articles", articleService.readAll());
        return "article/index";
    }

    @GetMapping("write")
    public String articleWrite() {
        return "article/write";
    }

    @PostMapping
    public String articleCreate(
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer
    ) {
        Long newId = articleService.create(new ArticleDto(title, content, writer)).getId();
        return String.format("redirect:/article/%d", newId);
    }

    @GetMapping("{id}")
    public String articleOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", articleService.read(id));
        return "article/read";
    }


    @GetMapping("{id}/edit")
    public String articleEdit(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", articleService.read(id));
        return "article/edit";
    }

    @PostMapping("{id}/update")
    public String articleUpdate(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content
    ) {
        articleService.update(id, new ArticleDto(title, content));
        return String.format("redirect:/article/%d", id);
    }

    @PostMapping("{id}/delete")
    public String articleDelete(
            @PathVariable("id")
            Long id
    ) {
        articleService.delete(id);
        return "redirect:/article";
    }
}
