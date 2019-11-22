package com.example.demo.dao;

import com.example.demo.entity.WriteReview;
import org.springframework.stereotype.Repository;

@Repository
public interface WriteReviewMapper {
    int deleteByPrimaryKey(Integer reviewId);

    int insert(WriteReview record);

    int insertSelective(WriteReview record);

    WriteReview selectByPrimaryKey(Integer reviewId);

    int updateByPrimaryKeySelective(WriteReview record);

    int updateByPrimaryKey(WriteReview record);
}