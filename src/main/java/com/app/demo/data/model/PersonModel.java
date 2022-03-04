package com.app.demo.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table
public class PersonModel {

  @Id
  @Column
  private UUID uniqueIdentificationNumber;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private int age;
}
