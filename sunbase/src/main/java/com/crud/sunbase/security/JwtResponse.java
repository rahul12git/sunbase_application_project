package com.crud.sunbase.security;


import lombok.*;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private  String username;
}