package com.gobinda.Recipe.Management.System.services;

import com.gobinda.Recipe.Management.System.models.Comment;
import com.gobinda.Recipe.Management.System.models.Recipe;
import com.gobinda.Recipe.Management.System.models.Visitor;
import com.gobinda.Recipe.Management.System.repos.IVisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorService {
    @Autowired
    IVisitorRepo iVisitorRepo;
    @Autowired
    RecipeService recipeService;
    @Autowired
    CommentService commentService;

    public String addComment(String commentBody, String recipeName,String visitorName) {
      Recipe recipe =recipeService.getRecipes(recipeName);
        Visitor visitor = iVisitorRepo.findFirstByVisitorName(visitorName);
       Comment newcomment = new Comment(null,commentBody,recipe,visitor);
       commentService.addcomments(newcomment);
       return "Comment added";

    }

    public String addVisitor(Visitor visitor) {
        iVisitorRepo.save(visitor);
        return "Visitor Added";
    }


    public List<Comment> getAllComments() {
        return commentService.getComments();
    }

    public Recipe getRecipe(String recipeName) {
        return recipeService.getRecipes(recipeName);
    }
}
