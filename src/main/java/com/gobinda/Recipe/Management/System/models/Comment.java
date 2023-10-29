package com.gobinda.Recipe.Management.System.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(nullable = false)
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "fkrecipeid")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "fk_commenter_id")
    private Visitor commenter;


}
