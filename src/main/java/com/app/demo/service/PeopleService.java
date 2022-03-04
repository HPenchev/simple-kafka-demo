package com.app.demo.service;

import com.app.demo.dto.Person;

import java.util.Collection;
import java.util.UUID;

/**
 * A service implementing business logic of working with people data
 */
public interface PeopleService {
  /**
   * Upserts a person into the database
   * @param person the person to be added to the database
   */
  Person upsertPerson(Person person);

  /**
   * Finds a person by their unique id
   * @param personId the person to be added to the database
   */
  Person findPerson(UUID personId);

  /**
   * retrieving all people from database
   */
  Collection<Person> getAllPeople();
}
