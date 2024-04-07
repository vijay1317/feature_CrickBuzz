package com.platform.crickbuzz.controllers;

import com.platform.crickbuzz.dto.MatchDetails;
import com.platform.crickbuzz.dto.MatchStatusResponseDTO;
import com.platform.crickbuzz.dto.MatchesListDto;
import com.platform.crickbuzz.entities.Matches;
import com.platform.crickbuzz.entities.Player;
import com.platform.crickbuzz.services.MatchesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchesController {
    Logger logger = LogManager.getLogger(MatchesController.class);
    @Autowired
    MatchesService matchesService;
    @PostMapping
    public MatchStatusResponseDTO create(@RequestBody Matches matches){
        logger.info("MatchesController:createMatch() execution started");
        MatchStatusResponseDTO matchRes =  matchesService.createMatch(matches);
        logger.info("MatchesController:createMatch() execution ended");
        return matchRes;
    }


    @GetMapping()
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public MatchesListDto getAll(){
        logger.info("MatchesController:getAll() execution started");
        MatchesListDto matchList = matchesService.getAll();
        logger.info("MatchesController:getAll() execution ended");
        return matchList;
    }

    @GetMapping("/{matchId}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public MatchDetails getMatchDetails(@PathVariable int matchId){

        return (MatchDetails) matchesService.getMatcheDetails(matchId);
    }





}
