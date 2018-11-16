package com.exam.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by syg on 2018-11-16
 */
public class JudgeEmptyUtil {

//    /**
//     * 拷贝一个对象并返回
//     */
//    public static Object ObjectClone(Object object) {
//        return ObjectUtils.clone(object);
//    }


    /**
     * 判断字符串不为null或者不为空字符型
     * 或的话第一个条件满足第二个就不执行了
     * 并的话条件都会执行
     *
     * @param str 字符串
     * @return true or false
     */
    public static boolean StringNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }


    /**
     * 判断字符串为null或者为空字符型
     *
     * @param str 字符串
     * @return boolean类型
     */
    public static boolean StringEmpty(String str) {
        return StringUtils.isEmpty(str);
    }


    /**
     * 判断对象为空的方法
     * 相同的对象名不同的包一个类里面只能引入一个 其他
     * 相同的类加上全限定名
     *
     * @param object 对象
     * @return true or false
     */
    public static boolean ObjectEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }


    /**
     * 判断list为空的方法
     *
     * @param list 集合
     * @return true or false
     */
    public static boolean ArrayListEmpty(List<?> list) {
        return CollectionUtils.isEmpty(list);
    }


    /**
     * 判断map集合为空的方法
     *
     * @param params map集合
     * @return true or false
     */
    public static boolean MapEmpty(Map<?, ?> params) {
        return CollectionUtils.isEmpty(params);
    }

}
