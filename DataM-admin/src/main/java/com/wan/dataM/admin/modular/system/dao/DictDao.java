package com.wan.dataM.admin.modular.system.dao;


import com.wan.dataM.admin.common.constant.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface DictDao {


    List<Dict> selectByCode(@Param("code") String code);


    List<Map<String,Object>> list(@Param("condition") String conditiion);
}
