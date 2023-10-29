package com.gobinda.Recipe.Management.System.services;

import com.gobinda.Recipe.Management.System.models.Dto.AuthenticationInputDto;
import com.gobinda.Recipe.Management.System.models.UserAuthenticationToken;
import com.gobinda.Recipe.Management.System.repos.IUserTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UTokenService {
    @Autowired
    IUserTokenRepo iUserTokenRepo;

    public void createToken(UserAuthenticationToken token) {
        iUserTokenRepo.save(token);
    }


    public boolean authenticate(AuthenticationInputDto authInfo) {
        String email = authInfo.getEmailId();
        String tokenValue = authInfo.getTokenValues();

        UserAuthenticationToken token =  iUserTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {
        UserAuthenticationToken token = iUserTokenRepo.findFirstByTokenValue(tokenValue);
        iUserTokenRepo.delete(token);
    }
}
