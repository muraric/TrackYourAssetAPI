package com.murari.TrackYourAsset.Repository;

import com.murari.TrackYourAsset.Entity.AssetMapEntity;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.Optional;

@N1qlPrimaryIndexed
public interface AssetMapRepository extends CouchbasePagingAndSortingRepository<AssetMapEntity, String> {
    Optional<AssetMapEntity> findById(String s);

    @Override
    <S extends AssetMapEntity> S save(S s);

    @Override
    boolean existsById(String docId);

    @Override
    void deleteAll();
}
