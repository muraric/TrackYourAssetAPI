package com.murari.TrackYourAsset.Entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetMapEntity {
    @Id
    @NotNull
    private String documentId;

    @Field
    @NonNull
    private String eMail;

    @Field
    Map<String,AssetEntity> assetList = new HashMap<>();
}
