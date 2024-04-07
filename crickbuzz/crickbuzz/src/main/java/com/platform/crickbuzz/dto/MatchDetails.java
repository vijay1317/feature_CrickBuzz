package com.platform.crickbuzz.dto;

import com.platform.crickbuzz.entities.Matches;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchDetails {
    private int match_id;
    private String team_1;
    private String team_2;

    private String date;
    private String venue;
    private String status;
    private SquadsDTO squads;

    public static MatchDetails createMatchDetails(Matches matches,SquadsDTO squadsDTO){
        MatchDetails response = new MatchDetails();
        response.setMatch_id(matches.getId());
        response.setTeam_1(matches.getTeam_1());
        response.setTeam_2(matches.getTeam_2());
        response.setDate(matches.getDate());
        response.setVenue(matches.getVenue());
        response.setStatus("upcoming");
//        List<SquadsDTO> sqadList = new ArrayList<>();
//        sqadList.add(squadsDTO);
        response.setSquads(squadsDTO);
        return response;
    }
}
