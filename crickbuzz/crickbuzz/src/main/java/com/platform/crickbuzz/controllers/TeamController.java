package com.platform.crickbuzz.controllers;


import com.platform.crickbuzz.dto.SquadRequestDto;
import com.platform.crickbuzz.dto.SquadResponseDto;
import com.platform.crickbuzz.entities.Player;
import com.platform.crickbuzz.services.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    MatchesService matchService;

    @PostMapping("/{team_id}/squad")
    public SquadResponseDto addPlayerToSquad(
            @PathVariable("team_id") int teamId, @RequestBody SquadRequestDto squadRequestDto) {
        return matchService.addPlayerToSquad(teamId,squadRequestDto);
    }



}
