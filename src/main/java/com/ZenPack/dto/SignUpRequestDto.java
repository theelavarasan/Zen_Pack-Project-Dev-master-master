package com.ZenPack.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private Long id;
    private String userName;
    private String password;
    private String emailId;
}
