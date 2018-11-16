package com.exam.demo.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by syg on2018-11-16
 */
public interface BaseSelectListMapper<T> {

    /**
     * 公共的查询方法
     * @param params 查询条件
     * @return  查询的列表 单纯对象的话查询没有数据就是null 集合的话
     * 查询没有数据的话集合不是null 而是size()=0,表示的是里面没有元素
     */

    List<T> selectByParams(Map<String, Object> params);
}
