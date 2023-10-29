package com.gobinda.Recipe.Management.System.controllers;

import com.gobinda.Recipe.Management.System.models.Comment;
import com.gobinda.Recipe.Management.System.models.Recipe;
import com.gobinda.Recipe.Management.System.models.Visitor;
import com.gobinda.Recipe.Management.System.services.VisitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class VisitorController {
    @Autowired
    VisitorService visitorService;


    @PostMapping("visitor/signup")
    public String addVisitor(@Valid  @RequestBody Visitor visitor){
        return visitorService.addVisitor(visitor);
    }

    @PostMapping("comment/recipeName/{recipeName}/visitorName/{visitorName}")
    public String addComment(@Valid @RequestBody String commentBody, @PathVariable String recipeName,@PathVariable String visitorName){
      return visitorService.addComment(commentBody,recipeName,visitorName);
    }

    @GetMapping("comments")
    public List<Comment> getAllComments(){
        return visitorService.getAllComments();
    }
    @GetMapping("recipe/name/{recipeName}")
    public Recipe getRecipeByName(@Valid @PathVariable String recipeName){
        return visitorService.getRecipe(recipeName);
    }
}
