package com.sara.studentdal;

import com.sara.studentdal.entities.Student;
import com.sara.studentdal.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("sara");
        student.setCourse("End to end spring");
        student.setFee(45d);
        studentRepository.save(student);
    }

    @Test
    void testFindById() {
        Student student = studentRepository.findById(2l).get();
//        assert student.getName() == "sara";
        System.out.println(student);
    }

    @Test
    void testUpdateStudent() {
        Student student = studentRepository.findById(2l).get();
        student.setFee(100d);
        studentRepository.save(student);
    }

    @Test
    void testDeleteById() {
        Student student = studentRepository.findById(2l).get();
        studentRepository.delete(student);
    }
}
