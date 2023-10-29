package com.gobinda.Recipe.Management.System.services;

import com.gobinda.Recipe.Management.System.models.Dto.AuthenticationInputDto;
import com.gobinda.Recipe.Management.System.models.Dto.SignInputDto;
import com.gobinda.Recipe.Management.System.models.User;
import com.gobinda.Recipe.Management.System.models.UserAuthenticationToken;
import com.gobinda.Recipe.Management.System.repos.IUserRepo;
import com.gobinda.Recipe.Management.System.repos.IUserTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    UTokenService uTokenService;
    @Autowired
    CommentService commentService;

    public String signup(User user) {             //Method for signup by new user
        String newEmail = user.getUserEmail();
      User existUser=  iUserRepo.findFirstByUserEmail(newEmail);   // check whether user has already existed or not in repository
      if(existUser !=null){                                    // if user has already sign up than unable to signup again
          return "User already Exist";
      }

    // Encrypt the password and save in the table
     String newPassword = user.getUserPassword();

        try {
            String encryptedPassword = PasswordEncrpytor.encryptPassword(newPassword);   //getting encrypted password
            user.setUserPassword(encryptedPassword);                                    // set encrypted password
            iUserRepo.save(user);                                                       // save user details by repo in mysql
            return "user registered";
        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String signin(SignInputDto signInputDto) {
        //check if the email is there in your tables
        //sign in only possible if this person ever signed up
        String email = signInputDto.getEmail();
        User existingUser = iUserRepo.findFirstByUserEmail(email);
        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }
        //password should be matched
        String password = signInputDto.getPassword();
        try {
            String encryptedPassword = PasswordEncrpytor.encryptPassword(password);

            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                UserAuthenticationToken token  = new UserAuthenticationToken(existingUser);
                uTokenService.createToken(token);
                return token.getTokenValue();
            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }


    public String userSignOut(AuthenticationInputDto auth) {
        String tokenValue = auth.getTokenValues();
        if(uTokenService.authenticate(auth)){
            uTokenService.deleteToken(tokenValue);
            return "Sign Out Successfully !!!";
        }else {
            return "Invalid Credentials!!!";
        }
    }

}
