package com.zerobase.fastlms.banner.repository;

import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.entity.OpenMethod;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OpenMethodRepository extends JpaRepository<OpenMethod, Long> {

    //Optional<List<Banner>> findByCategoryId(long categoryId);

}
