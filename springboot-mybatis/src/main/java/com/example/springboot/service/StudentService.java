package com.example.springboot.service;

import com.example.springboot.entity.Student;
import com.example.springboot.entity.StudentExample;
import com.example.springboot.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wangmin
 * @Comments
 * @since 2017/10/21
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper mapper;

    public Student getStudentById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<Student> getStudents(int pageNum , int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);

        return mapper.selectByExample(new StudentExample());
    }

    public int insertStudentInfo(Student student) {
        return mapper.insertSelective(student);
    }


    @Transactional(propagation = Propagation.REQUIRED, timeout = 3000, rollbackFor = Exception.class)
    public void testTransaction(Student student)
    {
        insertStudentInfo(student);
        throw new RuntimeException();
    }

}
