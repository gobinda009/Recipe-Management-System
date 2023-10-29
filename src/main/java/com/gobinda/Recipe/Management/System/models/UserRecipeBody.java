package com.gobinda.Recipe.Management.System.models;

import com.gobinda.Recipe.Management.System.models.Dto.AuthenticationInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecipeBody {
    //This class contains two entity AuthenticationInputDto and Recipe which is easy for take a single @RequestBody parameter
    AuthenticationInputDto auth = new AuthenticationInputDto();
    Recipe newRecipe = new Recipe();
}
