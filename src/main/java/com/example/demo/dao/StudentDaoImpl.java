package com.example.demo.dao;



import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class StudentDaoImpl implements StudentDao{
    private static final AtomicLong studentID = new AtomicLong();
    private static final Map<Long, Student> studentMap = new ConcurrentHashMap<>();


    @Override
    public void save(Student student) {
        final long studentId = studentID.incrementAndGet();
        student.setId(studentId);
        studentMap.put(studentId, student);
    }

    @Override
    public Student get(long id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public List<Student> getAllByGroupId(long groupId) {
        List<Student> studentsByGroup = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if(student.getGroupID() == groupId){
                studentsByGroup.add(student);
            }
        }
        return studentsByGroup;
    }


    @Override
    public boolean update(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return studentMap.remove(id) != null;
    }

}
