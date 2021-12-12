package com.example.demo.dao;



import com.example.demo.model.Student;


import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student get(long id);

    List<Student> getAll();

    List<Student> getAllByGroupId(long groupId);

    boolean update(Student student);

    boolean delete(long id);
}
