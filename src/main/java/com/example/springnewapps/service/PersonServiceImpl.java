package com.example.springnewapps.service;

import com.example.springnewapps.domain.dto.LikeDto;
import com.example.springnewapps.domain.entity.Person;
import com.example.springnewapps.repository.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Page<Person> getAllPerson(Pageable pageable) {
    return personRepository.findAll(pageable);
  }

  @Override
  public void changeCount(LikeDto likeDto) {
    Optional<Person> personOptional = personRepository.findById(likeDto.getIdPerson());
    if (personOptional.isPresent()) {
      Person person = personOptional.get();
      Integer count = person.getCount();
      if (count == null) {
        count = 0;
      }
      if (likeDto.getLike() == 1) {
        person.setCount(count + 1);
      } else {
        person.setCount(count - 1);
      }
      personRepository.save(person);
    }
  }
}
