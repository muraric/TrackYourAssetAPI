package com.murari.TrackYourAsset.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AssetPojo {
    private String assetSource;
    private String assetInstitutation;
    private String assetAccountType;
    private int assetValue;
}
