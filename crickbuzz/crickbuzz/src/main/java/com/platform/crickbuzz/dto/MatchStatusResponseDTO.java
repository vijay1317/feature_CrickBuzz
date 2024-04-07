package com.platform.crickbuzz.dto;

import com.platform.crickbuzz.entities.Matches;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatchStatusResponseDTO {
    private int id;
    private String message;


    public static MatchStatusResponseDTO convert(Matches matchRes) {
        MatchStatusResponseDTO response = new MatchStatusResponseDTO();
        try{
            response.setId(matchRes.getId());
            response.setMessage("Match created successfully");
        }catch (Exception e) {
            // Catch block to handle any other exceptions
            System.out.println("Error: in MatchResponseDTO " + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
