package com.app.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Person {
  private UUID uniqueIdentificationNumber;
  private String firstName;
  private String lastName;
  private int age;
}
