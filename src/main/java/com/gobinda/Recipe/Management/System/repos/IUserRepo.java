package com.gobinda.Recipe.Management.System.repos;

import com.gobinda.Recipe.Management.System.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {

    User findFirstByUserEmail(String newEmail);
}
