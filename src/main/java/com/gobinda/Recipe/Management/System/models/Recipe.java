package com.gobinda.Recipe.Management.System.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    @Column(unique = true)
    private String recipeName;
    @Column(nullable = false)
    private String recipeIngredient;
    @Column(nullable = false)
    private String recipeInstruction;
    @Column(nullable = false)
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "fk_owner_user_id")
//    private Visitor visitor;
}
