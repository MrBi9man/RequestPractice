package com.example.springnewapps.controller;

import com.example.springnewapps.domain.dto.LikeDto;
import com.example.springnewapps.domain.entity.Person;
import com.example.springnewapps.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/get")
  public ResponseEntity<Page<Person>> getAllPerson(Pageable pageable) {
    return new ResponseEntity<>(personService.getAllPerson(pageable), HttpStatus.OK);
  }

  @PostMapping("/changeCount")
  public ResponseEntity<Void> changeCount(@RequestBody LikeDto likeDto) {
    personService.changeCount(likeDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
