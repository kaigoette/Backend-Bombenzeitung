package de.kaigoe.backendbombenzeitung.service;

import de.kaigoe.backendbombenzeitung.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository){
        this.tokenRepository = tokenRepository;
    }


}
