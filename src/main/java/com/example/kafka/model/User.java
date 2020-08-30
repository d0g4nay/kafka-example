package com.example.kafka.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {
  private String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("name", name)
            .toString();
  }
}
