package com.dmitrii.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user-profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }


    @GetMapping
    public List<UserProfile>getUserProfiles(){
        return userProfileService.getUserProfiles();
    }

    @PostMapping(
            path = "{userProfileID}/image/download",
            consumes = MediaType.MULTIPART_FROM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )

    public void uploadUserProfileImage(@PathVariable("userProfileID")UUID userProfileID,
                                       @RequestParam("file") MultiPartFile file){
        userProfileService.uploadUserProfileImage(userProfileID, file);

    }

}
