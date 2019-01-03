package com.murari.TrackYourAsset.Service;

import com.murari.TrackYourAsset.Entity.AssetMapEntity;

public interface AssetMapService {
    AssetMapEntity findById(String docId);

    AssetMapEntity save(AssetMapEntity assetMapEntity);

    void deleteById(String docId);

    boolean existsById(String docId);

    AssetMapEntity saveSubDocument(AssetMapEntity assetMapEntity);
    AssetMapEntity deleteSubDocument(AssetMapEntity assetMapEntity);

}
