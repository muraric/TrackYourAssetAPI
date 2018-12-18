package com.murari.TrackYourAsset.Repository;

import com.murari.TrackYourAsset.Entity.UserProfileEntity;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.Optional;


@N1qlPrimaryIndexed
public interface UserProfileRepository extends CouchbasePagingAndSortingRepository<UserProfileEntity, String> {
    Optional<UserProfileEntity> findById(String s);

    @Override
    void deleteAll();
}
