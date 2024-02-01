package de.kaigoe.backendbombenzeitung.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private List<Token> tokens;

    protected Person(){}

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User" + id + ", " + userName;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public boolean checkToken(String token){
        for (int i = 0; i < tokens.size(); i++) {
            if(tokens.get(i).checkToken(token)) return true;
        }
        return false;
    }

    public String login(String userName, String password){
        if (userName.equals(this.userName) && password.equals(this.password)){
            Token newToken = new Token(this);
            String output = newToken.setToken();
            tokens.add(newToken);
            return output;
        } else return "";
    }
}
