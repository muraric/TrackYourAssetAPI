package com.murari.TrackYourAsset.Service;

import com.couchbase.client.core.message.kv.subdoc.multi.Mutation;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.subdoc.DocumentFragment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.murari.TrackYourAsset.Entity.AssetEntity;
import com.murari.TrackYourAsset.Entity.AssetMapEntity;
import com.murari.TrackYourAsset.Repository.AssetMapRepository;
import com.murari.TrackYourAsset.Utilities.KeyGenerator;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



@Service
public class AssetMapServiceImpl implements AssetMapService {
    final String documentTypeAssetMap = "AssetMap";
    final String subDocumentpathAssetList = "assetList";

    @Autowired
    private AssetMapRepository assetMapRepository;

    @Override
    public AssetMapEntity findById(String docId) {
        docId = KeyGenerator.createDocumentKey(docId, documentTypeAssetMap);
        return assetMapRepository.findById(docId).get();
    }

    @Override
    public AssetMapEntity save(AssetMapEntity assetMapEntity) {
        assetMapEntity.setDocumentId(KeyGenerator.createDocumentKey(assetMapEntity.getEMail(), documentTypeAssetMap));
        System.out.println(assetMapEntity.getEMail());
        if (existsById(assetMapEntity.getEMail())) {
            System.out.println("Document  found");
            return saveSubDocument(assetMapEntity);
        } else {
            System.out.println("Document NOT  found");
            return assetMapRepository.save(assetMapEntity);
        }
    }

    @Override
    public void deleteById(String docId) {
        assetMapRepository.deleteById(docId);
    }

    @Override
    public boolean existsById(String docId) {
        return assetMapRepository.existsById(KeyGenerator.createDocumentKey(docId, documentTypeAssetMap));
    }

    public AssetMapEntity saveSubDocument(AssetMapEntity assetMapEntity) {
        //String documentId = "muraric@gmail.com::AssetMap";

        if(!existsById(assetMapEntity.getEMail())){
            System.out.println("Document not found....Inserting");
            save(assetMapEntity);
        }


        String documentId = KeyGenerator.createDocumentKey(assetMapEntity.getEMail(), documentTypeAssetMap);
        //String subDocumentPath = "assetList.Bank::Dena::Savings";
        System.out.println(assetMapEntity.getEMail() + ":Sefvice Implementation");
        System.out.println(assetMapEntity.getAssetList().size());
        Map<String, AssetEntity> assetList = assetMapEntity.getAssetList();
        JsonObject jsonObject = JsonObject.create();
        for (Map.Entry<String, AssetEntity> entry : assetList.entrySet()) {
            System.out.println(entry.getKey());
            String subDocumentPath = subDocumentpathAssetList + "." + entry.getKey();
            System.out.println(entry.getValue().toString());
            jsonObject.put("assetSource", entry.getValue().getAssetSource());
            jsonObject.put("assetInstitutation", entry.getValue().getAssetInstitutation());
            jsonObject.put("assetAccountType", entry.getValue().getAssetAccountType());
            jsonObject.put("assetValue", entry.getValue().getAssetValue());
            DocumentFragment<Mutation> documentFragment = assetMapRepository
                    .getCouchbaseOperations()
                    .getCouchbaseBucket()
                    .mutateIn(documentId)
                    .upsert(subDocumentPath, jsonObject, true).execute();
        }
           /* ObjectMapper objectMapper = new ObjectMapper();
            String subdocument = objectMapper.writeValueAsString(assetMapEntity);*/

        return assetMapRepository.findById(documentId).get();

    }

    @Override
    public AssetMapEntity deleteSubDocument(AssetMapEntity assetMapEntity) {
        String documentId = KeyGenerator.createDocumentKey(assetMapEntity.getEMail(), documentTypeAssetMap);
        Map<String, AssetEntity> assetList = assetMapEntity.getAssetList();
        JsonObject jsonObject = JsonObject.create();
        for (Map.Entry<String, AssetEntity> entry : assetList.entrySet()) {
            System.out.println(entry.getKey());
            String subDocumentPath = subDocumentpathAssetList + "." + entry.getKey();

            DocumentFragment<Mutation> documentFragment = assetMapRepository
                    .getCouchbaseOperations()
                    .getCouchbaseBucket()
                    .mutateIn(documentId)
                    .remove(subDocumentPath)
                    .execute();
        }
        return assetMapRepository.findById(documentId).get();

    }
}
