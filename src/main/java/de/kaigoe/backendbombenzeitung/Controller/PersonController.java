package de.kaigoe.backendbombenzeitung.Controller;

import de.kaigoe.backendbombenzeitung.Repository.PersonRepository;
import de.kaigoe.backendbombenzeitung.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username + "  " + password);
        return personService.login(username,password);
    }

    @PostMapping("/checktoken")
    public boolean checkToken(@RequestParam("id") long id, @RequestParam("token") String token){
        return personService.getPersonById(id).checkToken(token);
    }

}
