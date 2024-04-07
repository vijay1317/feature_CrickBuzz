package com.authentication.AuthenticationService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthRequest {
    private String userName;
    private String password;
}
