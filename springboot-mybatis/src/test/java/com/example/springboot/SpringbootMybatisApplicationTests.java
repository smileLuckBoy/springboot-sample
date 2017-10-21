package com.example.springboot;

import com.example.springboot.entity.Student;
import com.example.springboot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootMybatisApplicationTests.class);

    @Autowired
    private StudentService studentService;


    @Test
    public void testStudentById() {
        Student student = studentService.getStudentById(2);
        logger.info("studentInfo : {} ", student.toString());
    }

    @Test
    public void testInsertStudent() {
        Student student = Student.builder().name("哈哈").age(12).sex(1).idCard("111111111111115").build();

        int count = studentService.insertStudentInfo(student);

        logger.info("insert count : {} ", count);
    }

    @Test
    public void testPageHelper() {
        List<Student> students = studentService.getStudents(2, 2);

        if (null != students && students.size() > 0) {
            students.forEach(System.out::println);
        }
    }

    @Test
    public void testTransaction() {
        Student student = Student.builder().name("哈哈").age(12).sex(1).idCard("111111111111115").build();

        studentService.testTransaction(student);
    }

}
