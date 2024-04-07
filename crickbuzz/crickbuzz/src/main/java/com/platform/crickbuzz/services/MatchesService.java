package com.platform.crickbuzz.services;

import com.platform.crickbuzz.dto.*;
import com.platform.crickbuzz.entities.Matches;
import com.platform.crickbuzz.entities.Player;
import com.platform.crickbuzz.entities.Squad;
import com.platform.crickbuzz.respositories.MatchesRespository;
import com.platform.crickbuzz.respositories.PlayerRepo;
import com.platform.crickbuzz.respositories.SquadRepo;
import com.platform.crickbuzz.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchesService {
    Logger logger = LogManager.getLogger(MatchesService.class);
    @Autowired
    MatchesRespository matchRepo;
    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    SquadRepo squadRepo;
    public MatchStatusResponseDTO createMatch(Matches match){
        logger.info("MatchesService: createMatch() execution started..");
        logger.info("MatchesService:createMatch() request payload {} ", Mapper.mapToJsonString(match));

        Matches matchRes = matchRepo.save(match);
        MatchStatusResponseDTO matchResponse =  MatchStatusResponseDTO.convert(matchRes);

        logger.info("MatchesService:createMatch() response payload {} ",Mapper.mapToJsonString(matchResponse));
        logger.info("MatchesService: createMatch() execution ended..");
        return matchResponse;
    }

    public MatchesListDto getAll() {
        logger.info("MatchesService: getAll() execution started..");
        List<Matches> matchesList = matchRepo.findAll();
        MatchesListDto matchListResponse =  MatchesListDto.convert(matchesList);
        logger.info("MatchesService:getAll() response payload {} ",Mapper.mapToJsonString(matchesList));
        logger.info("MatchesService: getAll() execution ended..");
        return matchListResponse;
    }

    public MatchDetails getMatcheDetails(int id) {
        Optional<Matches> matches =  matchRepo.findById(id);
        Matches match =  matches.get();
        String country1 =  match.getTeam_1();
        String country2 = match.getTeam_2();
        List<Optional<Player>> team1_players =  playerRepo.findByCountry(country1);

//        PlayerDTO player1Dto =  PlayerDTO.convert(team1_players.get());
        List<Optional<Player>> team2_players =  playerRepo.findByCountry(country2);

        List<Player> player1 = team1_players.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<Player> player2 = team2_players.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<PlayerDTO> team1Players =  PlayerDTO.convert(player1);
        List<PlayerDTO> team2Players =  PlayerDTO.convert(player2);

        SquadsDTO squadsDTO = SquadsDTO.createSquad(team1Players,team2Players);
        return MatchDetails.createMatchDetails(match,squadsDTO);

    }

    public Player createPlayer(Player player) {
        return playerRepo.save(player);
    }

    public SquadResponseDto addPlayerToSquad(int teamId, SquadRequestDto squadRequestDto){
        SquadResponseDto response = new SquadResponseDto();
        Squad squad = new Squad();
        Optional<Player> playerOptional = playerRepo.findByName(squadRequestDto.getName());
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            response.setPlayer_id(player.getPlayer_id());
            response.setDescription("Player added to squad successfully.");
//            response.setTeamId(teamId);
            squad.setPlayer_id(player.getPlayer_id());
            squad.setTeam_id(teamId);
            squad.setName(player.getName());
            squad.setRole(squadRequestDto.getRole());


            // Save the squad entity
            squadRepo.save(squad);

            // Return success response

        }
        return response;
    }

    public Player getPlayer(int playerId) {
        Optional<Player> optionalPlayer =  playerRepo.findById(playerId);
        Player player  = new Player();
        if(optionalPlayer.isPresent()){
            player =  optionalPlayer.get();
            return player;
        }

        return player;





    }
}
