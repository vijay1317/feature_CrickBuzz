package com.platform.crickbuzz.dto;

import com.platform.crickbuzz.entities.Player;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private int player_id;
    private String name;
//    private String matches_played;
//    private String runs;
//    private String average;
//    private String strike_rate;

    public static List<PlayerDTO> convert (List<Player> playersList){
        List<PlayerDTO> response = new ArrayList<>();


        try {
            for(Player player:playersList){
                PlayerDTO dto = new PlayerDTO();
                dto.setPlayer_id(player.getPlayer_id());
                dto.setName(player.getName());
                response.add(dto);
            }


//            response.setMatches_played(players.getMatches_played());
//            response.setRuns(players.getRuns());
//            response.setAverage(players.getAverage());
//            response.setStrike_rate(players.getStrike_rate());
        } catch(Exception e) {
            // Catch block to handle any other exceptions
            System.out.println("Error: in MatchesListDto " + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

}
