package com.app.demo.controller;

import com.app.demo.dto.Person;
import com.app.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

/**
 * A controller providing endpoins allowing us working with people data
 */
@RestController
@RequestMapping(value = "/people")
public class PeopleController {
  private final PeopleService peopleService;

  @Autowired
  public PeopleController(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  /**
   * An endpoint returning us a list of all people from the database
   */
  @GetMapping(value = "/find-all")
  public Collection<Person> findAll() {
    return peopleService.getAllPeople();
  }

  /**
   * An endpoint returning us a list of all people from the database
   * @param personId the unique identifier of a person
   */
  @GetMapping(value = "/{personId}")
  public ResponseEntity<Person> getPerson(@PathVariable UUID personId) {
    Person result = peopleService.findPerson(personId);
    if (result == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
