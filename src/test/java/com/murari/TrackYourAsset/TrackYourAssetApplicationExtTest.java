package com.murari.TrackYourAsset;

import com.murari.TrackYourAsset.Entity.UserProfileEntity;

import static org.junit.Assert.assertThat;

import com.murari.TrackYourAsset.Service.UserProfileService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;


import java.util.Optional;

public class TrackYourAssetApplicationExtTest extends TrackYourAssetApplicationTests {
    final private String testeMailId = "muraric@gmail.com";


    @Autowired
    UserProfileService userProfileService;


    @Test
    public void testsave() {
        UserProfileEntity userProfileEntity = new UserProfileEntity(testeMailId, "Murari", "Chakrakodi", "10725 Cleary Blvd", "APT 306", "Plantation", "FL", "33324", "USA");
        userProfileService.save(userProfileEntity);
        UserProfileEntity userProfileEntityNew = userProfileService.findById(testeMailId);
        System.out.println("Result : " + userProfileEntityNew.toString());
        assertThat(userProfileEntityNew, equalTo(userProfileEntity));
    }


}
