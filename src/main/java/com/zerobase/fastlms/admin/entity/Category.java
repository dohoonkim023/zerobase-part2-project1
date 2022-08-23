package com.zerobase.fastlms.admin.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    String categoryName;
    int sortValue;

    boolean usingYn;

}
