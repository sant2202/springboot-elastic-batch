package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository repo;

  @Override
  public Person save(Person p) {
    return repo.save(p);
  }

  @Override
  public Person findOne(String firstName) {
    return repo.findOne(firstName);
  }

  @Override
  public Iterable<Person> findAll() {
    return repo.findAll();
  }

  @Override
  public Page<Person> findByLastName(String lastName, PageRequest pageRequest) {
    return repo.findByLastName(lastName, pageRequest);
  }

  @Override
  public void write(List<? extends Person> persons) throws Exception {
    if (null == persons) {
      return;
    }
    for (Person person : persons) {
      save(person);
    }
  }

}
