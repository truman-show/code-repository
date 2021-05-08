package com.truman.show.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Tutorial {

  private long id;
  private String title;
  private String description;
  private boolean published;

  @Builder
  public Tutorial(long id, String title, String description, boolean published) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.published = published;
  }
}
