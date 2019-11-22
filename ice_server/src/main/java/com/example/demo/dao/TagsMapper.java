package com.example.demo.dao;

import com.example.demo.entity.Tags;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}