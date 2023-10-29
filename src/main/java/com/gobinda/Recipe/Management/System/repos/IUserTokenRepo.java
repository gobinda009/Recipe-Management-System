package com.gobinda.Recipe.Management.System.repos;

import com.gobinda.Recipe.Management.System.models.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {

    UserAuthenticationToken findFirstByTokenValue(String tokenValue);

}
