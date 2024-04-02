package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Organizer;
import org.example.capstone2.Service.OrganizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/organizer")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;
    Logger logger = LoggerFactory.getLogger(OrganizerController.class);

    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info(" getting all organizers");
        return ResponseEntity.status(200).body(organizerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addOrganizer(@RequestBody @Valid Organizer organizer){
        logger.info(" adding organizer");
        organizerService.addOrganizer(organizer);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer added"));
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateOrganizer(@PathVariable Integer Id , @RequestBody @Valid Organizer organizer){
        logger.info(" updating organizer");
        organizerService.updateOrganizer(Id , organizer);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer updated"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteTeam(@PathVariable Integer Id ){
        logger.info(" deleting organizer");
        organizerService.deleteOrganizer(Id);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer deleted"));
    }
}
