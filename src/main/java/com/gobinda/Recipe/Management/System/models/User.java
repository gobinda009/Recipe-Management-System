package com.gobinda.Recipe.Management.System.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //Generated auto values in UserId column
    private Integer userId;
    @Column(nullable = false)                        //nullable means this column should not blank
    private String userName;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")              //Regular Expression for validated email like email string must be abcdds@something.com
    @Column(unique = true)
    private String userEmail;
//    @Size(min=6,max=16)                                                 // Password must be minimum of 16 letters
    private String userPassword;


}
