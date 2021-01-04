package com.codejames.middleware.model.mapper;

import com.codejames.middleware.model.entity.RedDetail;
import com.codejames.middleware.model.entity.RedRecord;

public interface RedDetailMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(RedDetail record);
    int insertSelective(RedDetail record);
    RedDetail selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(RedDetail record);
    int updateByPrimaryKey(RedDetail redDetail);
}
