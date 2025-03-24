package org.example.search.service;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

  private static final String SEARCH_RANK_KEY = "search_rank";
  private final StringRedisTemplate redisTemplate;

  public void incrementSearchCount(String keyword) {
    redisTemplate.opsForZSet().incrementScore(SEARCH_RANK_KEY, keyword, 1);
  }

  public Set<String> getTopSearches() {
    return redisTemplate.opsForZSet().reverseRange(SEARCH_RANK_KEY, 0, 9);
  }

}

