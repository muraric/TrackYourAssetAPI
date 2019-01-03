package com.murari.TrackYourAsset.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetEntity {

    private String assetSource;
    private String assetInstitutation;
    private String assetAccountType;
    private int assetValue;
}
