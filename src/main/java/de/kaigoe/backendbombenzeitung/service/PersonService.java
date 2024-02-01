package de.kaigoe.backendbombenzeitung.service;

import de.kaigoe.backendbombenzeitung.Entity.Person;
import de.kaigoe.backendbombenzeitung.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public String login(String user, String password){
        return personRepository.getPersonByUserName(user).login(user,password);
    }

    public Person getPersonById(long id){
        return personRepository.getReferenceById(id);
    }

    public Person getPersonByUserName(String name){
        return personRepository.getPersonByUserName(name);
    }

}
