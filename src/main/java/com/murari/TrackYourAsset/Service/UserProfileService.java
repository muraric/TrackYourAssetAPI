package com.murari.TrackYourAsset.Service;


import com.murari.TrackYourAsset.Entity.UserProfileEntity;

public interface UserProfileService {

    //Optional<UserProfileEntity> findById(String docId);

    UserProfileEntity findById(String docId);
    UserProfileEntity save(UserProfileEntity userProfileEntity);
    void deleteById(String docId);
}
