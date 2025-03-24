package org.example.search.repository;

import java.util.List;
import org.example.search.entity.Concept;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ConceptRepository extends ElasticsearchRepository<Concept, String> {

  List<Concept> findByTitle(String keyword);

}
