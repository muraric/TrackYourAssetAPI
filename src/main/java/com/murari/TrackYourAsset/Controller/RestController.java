package com.murari.TrackYourAsset.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.murari.TrackYourAsset.Entity.AssetEntity;
import com.murari.TrackYourAsset.Entity.AssetMapEntity;
import com.murari.TrackYourAsset.Entity.UserProfileEntity;
import com.murari.TrackYourAsset.Pojo.AssetMapPojo;
import com.murari.TrackYourAsset.Service.AssetMapService;
import com.murari.TrackYourAsset.Service.UserProfileService;
import com.murari.TrackYourAsset.Utilities.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/TrackYourAsset")
@CrossOrigin(origins = "*")
public class RestController {


    @Autowired
    private AssetMapService assetMapService;

    @Autowired
    private UserProfileService userProfileService;



    @PostMapping("/")
    public String welcomeMessage() {
        return "Welcome to TrackYourAsset Service";
    }

    @PostMapping("/getTestUserProfile")
    public UserProfileEntity getTestUserProfile() {
        return userProfileService.findById("shobha.ym@gmail.com" + "::" + "AssetMap");
    }

    @PostMapping("/enrollUserProfile")
    public UserProfileEntity enrollUser(@RequestBody UserProfileEntity userProfileEntity) {
        UserProfileEntity userProfileEntityNew = userProfileService.save(userProfileEntity);
        return userProfileEntityNew;
    }

    @PostMapping("/deleteUserProfile")
    public void deleteUserProfile(@RequestBody UserProfileEntity userProfileEntity1) {
        userProfileService.deleteById(userProfileEntity1.getEMail());
    }

    @PostMapping("/getAssetMap")
    public AssetMapEntity getAssetMap(@RequestBody AssetMapEntity assetMapEntity) {
        System.out.println("docID:" + assetMapEntity.toString());

        return assetMapService.findById(assetMapEntity.getEMail());
    }

    @PostMapping("/addAssetMap")
    public AssetMapEntity addAssetMap(@RequestBody AssetMapEntity assetMapEntity) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("Object Mapper" + objectMapper.writeValueAsString(assetMapEntity));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        AssetMapEntity assetMapEntityNew = assetMapService.save(assetMapEntity);
        return assetMapEntityNew;

    }

    @PostMapping("/addSubDocument")
    public AssetMapEntity saveSubDocument(@RequestBody AssetMapEntity assetMapEntity) {
        AssetMapEntity assetMapEntityNew = assetMapService.saveSubDocument(assetMapEntity);
        return assetMapEntityNew;
    }

    @PostMapping("/getAssetMapObject")
    public AssetMapEntity getAssetMap(@RequestBody AssetMapPojo assetMapPojo) {
        AssetMapEntity assetMapEntity = new AssetMapEntity();
        assetMapEntity.setEMail(assetMapPojo.getEMail());
        Map<String, AssetEntity> assetList = new HashMap<>();
        AssetEntity assetEntity = new AssetEntity();
        assetEntity.setAssetAccountType(assetMapPojo.getAssetList().getAssetAccountType());
        assetEntity.setAssetInstitutation(assetMapPojo.getAssetList().getAssetInstitutation());
        assetEntity.setAssetSource(assetMapPojo.getAssetList().getAssetSource());
        assetEntity.setAssetValue(assetMapPojo.getAssetList().getAssetValue());
        assetList.put(KeyGenerator.createSubDocumentKey(assetMapPojo.getAssetList().getAssetSource()
                , assetMapPojo.getAssetList().getAssetInstitutation(),
                assetMapPojo.getAssetList().getAssetAccountType()), assetEntity);
        assetMapEntity.setAssetList(assetList);
        System.out.println("docID:" + assetMapEntity.toString());

        return assetMapService.findById(assetMapEntity.getEMail());
    }

    @PostMapping("/addAssetMapObject")
    public AssetMapEntity saveSubDocumentObject(@RequestBody AssetMapPojo assetMapPojo) {
        System.out.println(assetMapPojo.getEMail());
        System.out.println(assetMapPojo.getAssetList().getAssetAccountType());
        AssetMapEntity assetMapEntity = new AssetMapEntity();
        assetMapEntity.setEMail(assetMapPojo.getEMail());
        Map<String, AssetEntity> assetList = new HashMap<>();
        AssetEntity assetEntity = new AssetEntity();
        assetEntity.setAssetAccountType(assetMapPojo.getAssetList().getAssetAccountType());
        assetEntity.setAssetInstitutation(assetMapPojo.getAssetList().getAssetInstitutation());
        assetEntity.setAssetSource(assetMapPojo.getAssetList().getAssetSource());
        assetEntity.setAssetValue(assetMapPojo.getAssetList().getAssetValue());
        assetList.put(KeyGenerator.createSubDocumentKey(assetMapPojo.getAssetList().getAssetSource()
                , assetMapPojo.getAssetList().getAssetInstitutation(),
                assetMapPojo.getAssetList().getAssetAccountType()), assetEntity);
        assetMapEntity.setAssetList(assetList);

        AssetMapEntity assetMapEntityNew = assetMapService.saveSubDocument(assetMapEntity);
        return assetMapEntityNew;
    }

    @PostMapping("/deleteAssetMapObject")
    public AssetMapEntity deleteSubDocumentObject(@RequestBody AssetMapPojo assetMapPojo) {
        System.out.println(assetMapPojo.getEMail());
        System.out.println(assetMapPojo.getAssetList().getAssetAccountType());
        AssetMapEntity assetMapEntity = new AssetMapEntity();
        assetMapEntity.setEMail(assetMapPojo.getEMail());
        Map<String, AssetEntity> assetList = new HashMap<>();
        AssetEntity assetEntity = new AssetEntity();
        assetEntity.setAssetAccountType(assetMapPojo.getAssetList().getAssetAccountType());
        assetEntity.setAssetInstitutation(assetMapPojo.getAssetList().getAssetInstitutation());
        assetEntity.setAssetSource(assetMapPojo.getAssetList().getAssetSource());
        assetEntity.setAssetValue(assetMapPojo.getAssetList().getAssetValue());
        assetList.put(KeyGenerator.createSubDocumentKey(assetMapPojo.getAssetList().getAssetSource()
                , assetMapPojo.getAssetList().getAssetInstitutation(),
                assetMapPojo.getAssetList().getAssetAccountType()), assetEntity);
        assetMapEntity.setAssetList(assetList);

        AssetMapEntity assetMapEntityNew = assetMapService.deleteSubDocument(assetMapEntity);
        return assetMapEntityNew;
    }

}
