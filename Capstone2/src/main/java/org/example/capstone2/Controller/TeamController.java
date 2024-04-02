package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Team;
import org.example.capstone2.Service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    Logger logger = LoggerFactory.getLogger(TeamController.class);

    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info(" getting all teams");
        return ResponseEntity.status(200).body(teamService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addTeam(@RequestBody @Valid Team team ){
        logger.info(" adding team");
        teamService.addTeam(team);
        return ResponseEntity.status(200).body(new ApiResponse("Team added"));
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateTeam(@PathVariable Integer Id , @RequestBody @Valid Team team ){
        logger.info(" updating organizer");
        teamService.updateTeam(Id , team);
        return ResponseEntity.status(200).body(new ApiResponse("Team updated"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeam(@PathVariable Integer Id ){
        logger.info(" deleting organizer");
        teamService.deleteTeam(Id);
        return ResponseEntity.status(200).body(new ApiResponse("Team deleted"));
    }

    @GetMapping("/join/{userID}/{teamID}")
    public ResponseEntity joinTeam(@PathVariable Integer userID,@PathVariable Integer teamID ){
        logger.info(" user joining a team");
        return ResponseEntity.status(200).body( teamService.joinTeam(teamID,userID));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        logger.info(" getting team with specified name");
        return ResponseEntity.status(200).body(teamService.findByName(name));
    }
}
