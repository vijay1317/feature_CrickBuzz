package com.platform.crickbuzz.dto;

import com.platform.crickbuzz.entities.Matches;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchesListDto {
    private List<Matches> matches;

    public static MatchesListDto convert(List<Matches> matchesList) {
        MatchesListDto response = new MatchesListDto();
        try{
            response.setMatches(matchesList);
        }catch (Exception e) {
            // Catch block to handle any other exceptions
            System.out.println("Error: in MatchesListDto " + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
