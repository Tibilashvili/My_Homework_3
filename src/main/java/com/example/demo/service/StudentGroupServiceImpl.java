package com.example.demo.service;


import com.example.demo.dao.StudentGroupDaoImpl;
import com.example.demo.model.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    private StudentGroupDaoImpl studentGroupDaoImpl;

    StudentGroupServiceImpl(StudentGroupDaoImpl studentGroupDaoImpl){
        this.studentGroupDaoImpl = new StudentGroupDaoImpl();
    }


    @Override
    public void save(StudentGroup studentGroup) {
        studentGroupDaoImpl.save(studentGroup);
    }

    @Override
    public StudentGroup get(long id) {
        return studentGroupDaoImpl.get(id);
    }

    @Override
    public List<StudentGroup> getAll() {
        return studentGroupDaoImpl.getAll();
    }


    @Override
    public boolean update(StudentGroup group) {
        return studentGroupDaoImpl.update(group);
    }

    @Override
    public boolean delete(long id) {
        return studentGroupDaoImpl.delete(id);
    }
}
