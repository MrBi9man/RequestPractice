package com.example.springnewapps.domain.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column
  private Integer count;
}
