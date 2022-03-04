package com.app.demo.kafka;

import com.app.demo.dto.Person;
import com.app.demo.service.PeopleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PeopleListener {
  private final PeopleService peopleService;
  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  public PeopleListener(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  /**
   * Receiving messages about people and processing data for insertion.
   */
  @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
  public void listenForPeopleMessages(String message) {
    Person person;
    try {
      person = mapper.readValue(message, Person.class);
    } catch (JsonProcessingException e) {
      log.info("Invalid persona message={}", message);
      return;
    }

    peopleService.upsertPerson(person);
  }
}
