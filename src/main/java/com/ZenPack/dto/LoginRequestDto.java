package com.ZenPack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String emailId;
    private String password;
}
