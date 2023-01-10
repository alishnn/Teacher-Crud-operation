package com.example.teacher.Repository;

import com.example.teacher.Model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface teacherRepository extends MongoRepository<Teacher, String> {

    public List<Teacher> findByEmail(String email);

    public void delete(Teacher foundteacher);
}