package org.example.search.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.search.entity.Concept;
import org.example.search.repository.ConceptRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

  private final ConceptRepository conceptRepository;
  private final RedisService redisService;

  public List<Concept> search(String keyword) {
    redisService.incrementSearchCount(keyword);
    return conceptRepository.findByTitle(keyword);
  }

}
