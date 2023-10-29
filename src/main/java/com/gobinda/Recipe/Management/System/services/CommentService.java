package com.gobinda.Recipe.Management.System.services;

import com.gobinda.Recipe.Management.System.models.Comment;
import com.gobinda.Recipe.Management.System.models.Recipe;
import com.gobinda.Recipe.Management.System.repos.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    ICommentRepo iCommentRepo;

    public void addcomments(Comment newcomment) {
     iCommentRepo.save(newcomment);
    }

    public List<Comment> getComments() {
       return iCommentRepo.findAll();
    }


    public void removeComments(Recipe searchedRecipe) {
        List<Comment> comments = iCommentRepo.findByRecipe(searchedRecipe);
        iCommentRepo.deleteAll(comments);
    }


}
