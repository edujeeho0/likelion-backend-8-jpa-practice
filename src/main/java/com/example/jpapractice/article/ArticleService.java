package com.example.jpapractice.article;

import com.example.jpapractice.article.dto.ArticleDto;
import com.example.jpapractice.article.entity.Article;
import com.example.jpapractice.article.repo.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDto create(ArticleDto dto) {
        Article article = new Article(
                dto.getTitle(), dto.getContent(), dto.getWriter()
        );
        return ArticleDto.fromEntity(repository.save(article));
    }

    public List<ArticleDto> readAll() {
        List<ArticleDto> articleList = new ArrayList<>();
        for (Article article: repository.findAll()) {
            articleList.add(ArticleDto.fromEntity(article));
        }

        return articleList;
        // stream
        /*return repository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());*/
    }

    public ArticleDto read(Long id) {
        Article article = repository.findById(id).orElseThrow();
        return ArticleDto.fromEntity(article);
    }

    public ArticleDto update(Long id, ArticleDto dto) {
        Article article = repository.findById(id).orElseThrow();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return ArticleDto.fromEntity(repository.save(article));
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow());
    }
}
