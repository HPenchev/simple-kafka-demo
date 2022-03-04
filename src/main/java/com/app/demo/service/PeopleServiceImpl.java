package com.app.demo.service;

import com.app.demo.data.model.PersonModel;
import com.app.demo.data.repo.PersonDAO;
import com.app.demo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PeopleServiceImpl implements PeopleService{
  private final PersonDAO personDAO;

  @Autowired
  public PeopleServiceImpl(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  @Override
  public Person upsertPerson(Person person) {
    personDAO.save(new PersonModel(
        person.getUniqueIdentificationNumber(),
        person.getFirstName(),
        person.getLastName(),
        person.getAge()));

    return person;
  }

  @Override
  public Person findPerson(UUID personId) {
    Optional<PersonModel> personModelOpt = personDAO.findById(personId);
    if(personModelOpt.isEmpty()) {
      return null;
    }

    PersonModel personModel = personModelOpt.get();

    return new Person(
        personModel.getUniqueIdentificationNumber(),
        personModel.getFirstName(),
        personModel.getLastName(),
        personModel.getAge());
  }


  @Override
  public Collection<Person> getAllPeople() {
    return personDAO.findAll().stream().map(p ->
        new Person(p.getUniqueIdentificationNumber(), p.getFirstName(), p.getLastName(), p.getAge()))
        .collect(Collectors.toList());
  }
}
