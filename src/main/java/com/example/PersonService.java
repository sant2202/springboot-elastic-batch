package com.example;

import org.springframework.batch.item.ItemWriter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PersonService extends ItemWriter<Person> {

  Person save(Person p);

  Person findOne(String firstName);

  Iterable<Person> findAll();

  Page<Person> findByLastName(String lastName, PageRequest pageRequest);

}
