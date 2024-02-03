package com.crud.sunbase.security;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String username;
    private String password;

}
