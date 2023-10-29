package com.gobinda.Recipe.Management.System.services;

import com.gobinda.Recipe.Management.System.models.Comment;
import com.gobinda.Recipe.Management.System.models.Dto.AuthenticationInputDto;
import com.gobinda.Recipe.Management.System.models.Recipe;
import com.gobinda.Recipe.Management.System.models.UserRecipeBody;
import com.gobinda.Recipe.Management.System.repos.IRecipeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.sql.ast.Clause.FROM;

@Service
public class RecipeService {
    @Autowired
    IRecipeRepo iRecipeRepo;
    @Autowired
    UTokenService tokenService;
    @Autowired
    CommentService commentService;


    public String addRecipes(UserRecipeBody userRecipeBody) {
        AuthenticationInputDto authInfo = userRecipeBody.getAuth();
        Recipe recipe = userRecipeBody.getNewRecipe();

        boolean b =tokenService.authenticate(authInfo);

        if(b) {
           iRecipeRepo.save(recipe);
           return "Recipe Added !!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public List<Recipe> getAllRecipes() {

        return iRecipeRepo.findAll();
    }

    public String updateRecipe(UserRecipeBody userRecipeBody, String name) {
        AuthenticationInputDto authInfo = userRecipeBody.getAuth();
        Recipe recipe = userRecipeBody.getNewRecipe();

        boolean b =tokenService.authenticate(authInfo);
        Recipe searchedRecipe = iRecipeRepo.findFirstByRecipeName(name);

        if(b && searchedRecipe.getEmail().equals(authInfo.getEmailId())) {
            searchedRecipe.setRecipeName(recipe.getRecipeName());
            searchedRecipe.setRecipeIngredient(recipe.getRecipeIngredient());
            searchedRecipe.setRecipeInstruction(recipe.getRecipeInstruction());
            iRecipeRepo.save(searchedRecipe);
            return "Recipe Updated !!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }



    @Transactional
    public String deleteRecipe(AuthenticationInputDto authInfo, String name) {
        boolean b =tokenService.authenticate(authInfo);

        Recipe searchedRecipe = iRecipeRepo.findFirstByRecipeName(name);
        if(b && searchedRecipe.getEmail().equals(authInfo.getEmailId())) {

            commentService.removeComments(searchedRecipe);
            iRecipeRepo.delete(searchedRecipe);
            return "Recipe Deleted !!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }


    public Recipe getRecipes(String recipeName) {
        return iRecipeRepo.findFirstByRecipeName(recipeName);
    }



}
