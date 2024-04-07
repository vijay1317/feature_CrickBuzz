package com.authentication.AuthenticationService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpDto {
    private String status;
    private String status_code;
    private String user_id;

}
