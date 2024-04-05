package com.BusReservationApp.Controller;

import com.BusReservationApp.Entity.UserRegistration;
import com.BusReservationApp.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
    @Autowired
    private UserServiceImpl userService;
    //http://localhost:8080/api/v1/user
    @PostMapping
    public String createuser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") MultipartFile profilePicture
    ) {
        try {
            UserRegistration userRegistration = new UserRegistration();
            userRegistration.setName(name);
            userRegistration.setEmail(email);
            userRegistration.setPassword(password);
            userRegistration.setProfilePicture(profilePicture.getBytes());

            userService.createUser(userRegistration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Done.....";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable long id) {
        UserRegistration user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Comment is Deleted",HttpStatus.OK);
    }
}

