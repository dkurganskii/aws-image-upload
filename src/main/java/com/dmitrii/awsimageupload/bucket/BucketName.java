package com.dmitrii.awsimageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("dmitrii-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
