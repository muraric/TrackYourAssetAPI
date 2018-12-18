package com.murari.TrackYourAsset.Controller;

import com.murari.TrackYourAsset.Entity.UserProfileEntity;
import com.murari.TrackYourAsset.Service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/TrackYourAsset")
@CrossOrigin(origins = "http://localhost:3000")
public class RestController {
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/")
    public String welcomeMessage() {
        return "Welcome to TrackYourAsset Service";
    }

    @PostMapping("/getTestUserProfile")
    public UserProfileEntity getTestUserProfile() {
        return userProfileService.findById("muraric@gmail.com");
    }

    @PostMapping("/enrollUserProfile")
    public UserProfileEntity enrollUser(@RequestBody UserProfileEntity userProfileEntity) {
        UserProfileEntity userProfileEntityNew = userProfileService.save(userProfileEntity);
        return userProfileEntityNew;
    }

   /* @PostMapping
    public String deleteUserProfile(@RequestBody UserProfileEntity userProfileEntity1) {

        userProfileService.deleteById(userProfileEntity1.geteMail);

    }*/
}
