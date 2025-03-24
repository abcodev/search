package org.example.search.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Concept {

  @Id
  private String id;
  private String title;
  private String content;

}
