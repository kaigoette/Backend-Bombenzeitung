package de.kaigoe.backendbombenzeitung.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.kaigoe.backendbombenzeitung.service.PersonService;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Token {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String token = "";
    @ManyToOne
    @JsonManagedReference
    private Person person;
    private Date lastUsed;

    protected Token(){}

    public Token(Person person){
        this.person = person;
        lastUsed = Calendar.getInstance().getTime();
    }

    public boolean checkToken(String token){
        System.out.println(token);
        System.out.println(this.token);
        if(!token.equals(this.token)) return false;
        long timeSinceLastUse = Calendar.getInstance().getTime().getTime() - lastUsed.getTime();
        long twoWeeks = 1210000;
        if(timeSinceLastUse > twoWeeks){
            return false;
        }
        lastUsed = Calendar.getInstance().getTime();
        return true;
    }

    public String setToken(){
        if(!token.equals("")) return "";
        token = "AmongUs123LOL" + person.getId() + Calendar.getInstance().getTime().getTime();
        return token;
    }

}
