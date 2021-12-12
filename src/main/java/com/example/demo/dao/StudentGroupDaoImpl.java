package com.example.demo.dao;



import com.example.demo.model.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class StudentGroupDaoImpl implements StudentGroupDao{
    private static final AtomicLong studentGroupId = new AtomicLong();
    private static final Map<Long, StudentGroup> studentGroupMap = new ConcurrentHashMap<>();


    @Override
    public void save(StudentGroup studentGroup) {
        final long groupId = studentGroupId.incrementAndGet();
        studentGroup.setId(groupId);
        studentGroupMap.put(groupId, studentGroup);
    }

    @Override
    public StudentGroup get(long id) {
        return studentGroupMap.get(id);
    }

    @Override
    public List<StudentGroup> getAll() {
        return new ArrayList<>(studentGroupMap.values());
    }



    @Override
    public boolean update(StudentGroup studentGroup) {
        if (studentGroupMap.containsKey(studentGroup.getId())) {
            studentGroupMap.put(studentGroup.getId(), studentGroup);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return studentGroupMap.remove(id) != null;
    }
}
