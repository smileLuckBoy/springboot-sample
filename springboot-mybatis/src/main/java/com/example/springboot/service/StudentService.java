package com.example.springboot.service;

import com.example.springboot.dao.StudentMapper;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.StudentExample;
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

    private final StudentMapper mapper;

    @Autowired
    public StudentService(StudentMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    public Student getStudentById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 分页获取数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Student> getStudents(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return mapper.selectByExample(new StudentExample());
    }

    /**
     * 插入测试
     * @param student
     * @return
     */
    public int insertStudentInfo(Student student) {
        return mapper.insertSelective(student);
    }


    /**
     * 测试事物@Transactional
     * @param student
     */
    @Transactional(propagation = Propagation.REQUIRED, timeout = 3000, rollbackFor = Exception.class)
    public void testTransaction(Student student) {
        insertStudentInfo(student);
        throw new RuntimeException();
    }

}
