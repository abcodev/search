package org.example.search.controller;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.search.entity.Concept;
import org.example.search.service.RedisService;
import org.example.search.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {
  private final SearchService searchService;
  private final RedisService  redisService;

  @GetMapping
  public List<Concept> search(@RequestParam String keyword) {
    return searchService.search(keyword);
  }

  @GetMapping("/popular")
  public Set<String> getPopularSearches() {
    return redisService.getTopSearches();
  }
}
