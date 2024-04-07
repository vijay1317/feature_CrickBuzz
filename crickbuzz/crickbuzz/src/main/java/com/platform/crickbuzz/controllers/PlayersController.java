package com.platform.crickbuzz.controllers;

import com.platform.crickbuzz.dto.SquadRequestDto;
import com.platform.crickbuzz.dto.SquadResponseDto;
import com.platform.crickbuzz.entities.Player;
import com.platform.crickbuzz.services.MatchesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayersController {
    Logger logger = LogManager.getLogger(PlayersController.class);
    @Autowired
    MatchesService matchesService;
    @PostMapping("/addPlayer")
    public Player create(@RequestBody Player player){
        logger.info("MatchesController:createMatch() execution started");
        Player playerREs =  matchesService.createPlayer(player);
        logger.info("MatchesController:createMatch() execution ended");
        return playerREs;
    }

    @GetMapping("/{player_id}/stats")
    public Player addPlayerToSquad(@PathVariable("player_id") int player_id) {

        return matchesService.getPlayer(player_id);
    }
}
