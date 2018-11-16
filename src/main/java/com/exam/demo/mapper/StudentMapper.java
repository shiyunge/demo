package com.exam.demo.mapper;

import com.exam.demo.bean.PO.Student;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by syg on 2018-11-16
 */
public interface StudentMapper extends BaseMapper<Student>, BaseSelectListMapper<Student> {

}
