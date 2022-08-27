package com.zerobase.fastlms.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerName;
    String link;
    String openMethod;
    long sortValue;
    Boolean disclosureYn;

    LocalDateTime regDt;//등록일(추가날짜)
    LocalDateTime udtDt;//수정일(수정날짜)


    String filename;
    String urlFilename;


}
