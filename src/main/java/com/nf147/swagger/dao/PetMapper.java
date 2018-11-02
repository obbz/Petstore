package com.nf147.swagger.dao;

import com.nf147.swagger.entity.Pet;
import java.util.List;

public interface PetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pet record);

    Pet selectByPrimaryKey(Integer id);

    List<Pet> selectAll(String status);

    int updateByPrimaryKey(Pet record);
}