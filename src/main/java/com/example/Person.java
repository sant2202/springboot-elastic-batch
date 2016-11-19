package com.example;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "person", type = "simple", shards = 1, replicas = 0)
public class Person implements Serializable {
  private static final long serialVersionUID = -709829263635711234L;
  private String lastName;
  @Id
  private String firstName;

  public Person() {
    super();
  }

  public Person(String firstName2, String lastName2) {
    this.firstName = firstName2;
    this.lastName = lastName2;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String toString() {
    return "Person [lastName=" + lastName + ", firstName=" + firstName + "]";
  }

}
