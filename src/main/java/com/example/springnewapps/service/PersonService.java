package com.example.springnewapps.service;

import com.example.springnewapps.domain.dto.LikeDto;
import com.example.springnewapps.domain.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

  Page<Person> getAllPerson(Pageable pageable);

  void changeCount(LikeDto likeDto);
}
