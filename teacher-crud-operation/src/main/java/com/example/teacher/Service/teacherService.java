package com.example.teacher.Service;

import com.example.teacher.Model.Teacher;
import com.example.teacher.Repository.teacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class teacherService {

    @Autowired
    public teacherRepository teacherrepo;

    public List<Teacher> getAllteacher() {
        return teacherrepo.findAll();

    }

    public Optional<Teacher> getTeacher(String teacherid) {

        return teacherrepo.findById(teacherid);
    }

    public Teacher Addteacher(Teacher teacher) {

        return teacherrepo.save(teacher);
    }

    public String updateTeacher(Teacher teacher, String teacherid) {
        Optional<Teacher> teacherData = teacherrepo.findById(teacherid);
        if (teacherData.isPresent()) {
            Teacher produ = teacherData.get();
            produ.setTeacherName(teacher.getTeacherName());

            produ.setSubject(teacher.getSubject());
            produ.setCity(teacher.getCity());
            this.teacherrepo.save(produ);
            return "Teacher details are updated";
        } else {
            return "Teacher detail is not updated";
        }


    }

    public String deleteTeacher(String teacherid) {
        teacherrepo.deleteById(teacherid);
        return teacherid + " was deleted successfully";
    }

    public List<Teacher> getteacher(String email) {

        return teacherrepo.findByEmail(email);
    }
}
