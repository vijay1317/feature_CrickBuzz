package com.authentication.AuthenticationService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDTO {
    private String status;
    private String status_code;
    private String user_id;
    private String access_token;

    public LoginDTO(String status,String status_code){
        this.status = status;
        this.status_code =status_code;
    }



}
