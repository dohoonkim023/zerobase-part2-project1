package com.zerobase.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {

    long id;

    String bannerName;
    String link;
    String openMethod;
    long sortValue;
    Boolean disclosureYn;

    //삭제를 위한
    String idList;


    //ADD
    String filename;
    String urlFilename;

}
