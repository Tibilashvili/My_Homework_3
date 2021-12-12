package com.example.demo.service;



import com.example.demo.dao.StudentDaoImpl;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentDaoImpl studentDaoImpl;

    public StudentServiceImpl(StudentDaoImpl studentDaoImpl) {
        this.studentDaoImpl = new StudentDaoImpl();
    }

    @Override
    public void save(Student student) {
        studentDaoImpl.save(student);
    }

    @Override
    public Student get(long id) {
        return studentDaoImpl.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDaoImpl.getAll();
    }

    @Override
    public List<Student> getAllStudentsByGroup(long groupId) {
        return studentDaoImpl.getAllByGroupId(groupId);
    }

    @Override
    public boolean update(Student student) {
        if(studentDaoImpl.update(student)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return studentDaoImpl.delete(id);
    }

}
