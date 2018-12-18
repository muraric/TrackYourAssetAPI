package com.murari.TrackYourAsset.Entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileEntity {

    @Id
    @NotNull
    private String eMail;

    @NotNull
    @Field
    private String firstName;

    @NotNull
    @Field
    private String lastName;

    @Field
    private String addressLine1;

    @Field
    private String addressLine2;

    @Field
    private String city;

    @Field
    private String state;

    @Field
    private String zipCd;

    @Field
    private String countryCd;


}
