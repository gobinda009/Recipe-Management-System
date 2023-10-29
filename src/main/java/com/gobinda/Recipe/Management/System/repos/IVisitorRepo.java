package com.gobinda.Recipe.Management.System.repos;

import com.gobinda.Recipe.Management.System.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitorRepo extends JpaRepository<Visitor,Integer> {


    Visitor findFirstByVisitorName(String visitorName);
}
