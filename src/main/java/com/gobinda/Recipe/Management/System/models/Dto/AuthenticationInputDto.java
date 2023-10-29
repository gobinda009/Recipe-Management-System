package com.gobinda.Recipe.Management.System.models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationInputDto {
    private String emailId;
    private String tokenValues;
}
