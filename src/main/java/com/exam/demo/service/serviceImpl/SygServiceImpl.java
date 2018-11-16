package com.exam.demo.service.serviceImpl;

import com.exam.demo.bean.PO.Student;
import com.exam.demo.mapper.StudentMapper;
import com.exam.demo.service.SygService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by syg on 2018-11-16
 */
public class SygServiceImpl implements SygService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student add(Student student) throws Exception {
        //studentMapper.
        return null;
    }
}
