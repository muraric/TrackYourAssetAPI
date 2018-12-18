package com.murari.TrackYourAsset.Service;



import com.murari.TrackYourAsset.Entity.UserProfileEntity;
import com.murari.TrackYourAsset.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
   /* public Optional<UserProfileEntity> findById(String docId){
        return userProfileRepository.findById(docId);
    }
    */
    public UserProfileEntity findById(String docId) {
        return userProfileRepository.findById(docId).get();
    }

    @Override
    public UserProfileEntity save(UserProfileEntity userProfileEntity) {
        return userProfileRepository.save(userProfileEntity);
    }

    @Override
    public void deleteById(String docId) {
        userProfileRepository.deleteById(docId);
    }
}
