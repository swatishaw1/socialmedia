package com.example.socialmedia.Controller;

import com.example.socialmedia.Entity.SocialUser;
import com.example.socialmedia.Service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getAllSocialUsers() {
        return new ResponseEntity<>(socialService.getAllSocialUsers(),HttpStatus.OK);
    }
    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> createNewSocialUser(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialService.createNewSocialUser(socialUser),HttpStatus.OK);
    }
    @DeleteMapping("/social/users/{id}")
    public ResponseEntity<String> deleteSocialUser(@PathVariable Long id) {
        socialService.deleteSocialUser(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
