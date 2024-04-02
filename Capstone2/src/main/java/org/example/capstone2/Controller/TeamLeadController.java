package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.TeamLead;
import org.example.capstone2.Service.TeamLeadService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/teamlead")
@RequiredArgsConstructor
public class TeamLeadController {
    private final TeamLeadService teamLeadService;
    Logger logger = LoggerFactory.getLogger(TeamLeadController.class);

    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info(" getting all team leads ");
        return ResponseEntity.status(200).body(teamLeadService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addTeamLead(@RequestBody @Valid TeamLead teamLead ){
        logger.info(" adding team lead");
        teamLeadService.addTeamLead(teamLead);
        return ResponseEntity.status(200).body(new ApiResponse("TeamLead added"));
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateTeamLead(@PathVariable Integer Id , @RequestBody @Valid TeamLead teamLead ){
        logger.info(" updating team lead");
        teamLeadService.updateTeamLead(Id , teamLead);
        return ResponseEntity.status(200).body(new ApiResponse("TeamLead updated"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeamLead(@PathVariable Integer Id ){
        logger.info(" deleting team lead");
        teamLeadService.deleteTeamLead(Id);
        return ResponseEntity.status(200).body(new ApiResponse("TeamLead deleted"));
    }

    @GetMapping("/experience/{experience}")
    public ResponseEntity getExperienceAbove(@PathVariable Integer experience ){
        logger.info(" getting team lead by experience");
        return ResponseEntity.status(200).body(teamLeadService.getExperienceAbove(experience));
    }

    @PostMapping("status/{id}")
    public ResponseEntity statusUpdate(@PathVariable Integer id){
        logger.info(" updating team lead status pro/beginner");
        teamLeadService.statusUpdate(id);
        return ResponseEntity.status(200).body(new ApiResponse("TeamLead status updated successfully"));
    }
}
