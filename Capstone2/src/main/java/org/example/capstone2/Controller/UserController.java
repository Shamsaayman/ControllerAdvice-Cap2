package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.User;
import org.example.capstone2.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public ResponseEntity getAll(){
        logger.info(" getting all users");
        return ResponseEntity.status(200).body(userService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        logger.info("adding user");
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user ){
        logger.info("updating user");
        userService.updateUser(Id , user);
        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){
        logger.info("deleting user");
        userService.deleteUser(Id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }

    @GetMapping("/getuserpass/{username}/{password}")
    public ResponseEntity findByUsernamePassword(@PathVariable String username, @PathVariable String password) {
        logger.info("checking user credentials");
        return ResponseEntity.status(200).body(userService.findByUsernameAndPassword(username,password));
    }

    @GetMapping("/getage/{age1}/{age2}")
    public ResponseEntity getByAgeRange(@PathVariable Integer age1 , @PathVariable Integer age2){
        logger.info("getting users in age range ");
        return ResponseEntity.status(200).body(userService.getAgeRange(age1,age2));
    }

    @GetMapping("/weight/{weight}")
    public ResponseEntity getWeightAbove(@PathVariable Integer weight ){
        logger.info("getting users in weight range ");
        return ResponseEntity.status(200).body(userService.getWeightAbove(weight));
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity getByGender(@PathVariable String gender ){
        logger.info("getting users by gender");
        return ResponseEntity.status(200).body(userService.getByGender(gender));
    }

    @GetMapping("/sport/{sport}")
    public ResponseEntity getBySport(@PathVariable String sport ){
        logger.info("getting users by sport");
        return ResponseEntity.status(200).body(userService.getBySport(sport));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity findCategory(@PathVariable Integer id ){
        logger.info("getting users category ");
        return ResponseEntity.status(200).body(userService.findCategory(id));
    }
}
