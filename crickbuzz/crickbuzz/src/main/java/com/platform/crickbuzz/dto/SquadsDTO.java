package com.platform.crickbuzz.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SquadsDTO {
    private List<PlayerDTO> team_1;
    private List<PlayerDTO> team_2;

    public static SquadsDTO createSquad(List<PlayerDTO> team1, List<PlayerDTO> team2){
        SquadsDTO response = new SquadsDTO();


        response.setTeam_1(team1);
        response.setTeam_2(team2);
        return response;

    }


}
