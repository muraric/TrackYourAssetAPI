package com.murari.TrackYourAsset.Utilities;



public class KeyGenerator {


    public static String createDocumentKey(String eMail,String documentType){
        StringBuilder keyDelimiter = new StringBuilder("::");
        StringBuilder eMailStringBuilder = new StringBuilder(eMail);
        StringBuilder documentTypeStringBuilder = new StringBuilder(documentType);
        StringBuilder keyStringBuilder = new StringBuilder();
        keyStringBuilder = eMailStringBuilder.append(keyDelimiter).append(documentTypeStringBuilder);
        return keyStringBuilder.toString();

    }

    public static String createSubDocumentKey(String assetSource,String assetInstitutation,String assetAccountType){
        StringBuilder keyDelimiter = new StringBuilder("::");
        StringBuilder assetSourceStringBuilder = new StringBuilder(assetSource);
        StringBuilder assetInstitutationStringBuilder = new StringBuilder(assetInstitutation);
        StringBuilder assetAccountTypeStringBuilder = new StringBuilder(assetAccountType);
        StringBuilder keyStringBuilder = new StringBuilder();
        keyStringBuilder = assetSourceStringBuilder.append(keyDelimiter).append(assetInstitutationStringBuilder).append(keyDelimiter).append(assetAccountTypeStringBuilder);
        return keyStringBuilder.toString();

    }
}
