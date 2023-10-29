package com.gobinda.Recipe.Management.System.repos;

import com.gobinda.Recipe.Management.System.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRecipeRepo extends JpaRepository<Recipe,Integer> {
    Recipe findFirstByRecipeName(String name);



}
