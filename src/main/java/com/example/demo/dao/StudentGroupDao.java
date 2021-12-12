package com.example.demo.dao;



import com.example.demo.model.StudentGroup;

import java.util.List;

public interface StudentGroupDao {

    void save(StudentGroup studentGroup);

    StudentGroup get(long id);

    List<StudentGroup> getAll();

    boolean update(StudentGroup studentGroup);

    boolean delete(long id);
}
