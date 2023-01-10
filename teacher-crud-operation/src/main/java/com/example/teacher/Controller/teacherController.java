package com.example.teacher.Controller;

import com.example.teacher.Model.Teacher;
import com.example.teacher.Service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/teacher")
@RestController
public class teacherController {

    @Autowired
    public teacherService teacherService;

    @GetMapping("/list")
    public ResponseEntity<List<Teacher>> getAllteacher()
    {
        try {
            return new ResponseEntity<>(teacherService.getAllteacher(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Teacher>> getProduct(@PathVariable("id") String teacherid)
    {
        try {
            return new ResponseEntity<>(teacherService.getTeacher(teacherid),HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/teacher/{email}")
    public ResponseEntity<List<Teacher>> getteacher(@PathVariable("email") String email)
    {
        try
        {
            return new ResponseEntity<>(teacherService.getteacher(email),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/list/add")
    public ResponseEntity<Teacher> Addteacher(@RequestBody Teacher teacher)
    {
        try
        {
            return new ResponseEntity<>(teacherService.Addteacher(teacher),HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/list/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Teacher teacher, @PathVariable("id") String teacherid)
    {
        try
        {
            return new ResponseEntity<>(teacherService.updateTeacher(teacher,teacherid),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") String teacherid)
    {
        try
        {
            teacherService.deleteTeacher(teacherid);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherid+" was deleted",HttpStatus.OK);
    }
}
