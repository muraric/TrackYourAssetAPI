package com.murari.TrackYourAsset.Entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquityEntity {

    @NotNull
    @Id
    private String docId;

    @NotNull
    @Field
    private String eMailId;

    @NotNull
    @Field
    private String docType;

    @Field
    Map<String,Integer> assetList = new HashMap<>();

}
