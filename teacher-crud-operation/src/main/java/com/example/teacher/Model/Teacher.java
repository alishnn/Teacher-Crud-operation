package com.example.teacher.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Teacher {



        @Id
        private String teacherId;
        private String teacherName;
        private String subject;

        private String city;
        private String Email;

        public String getTeacherId() {

            return teacherId;
        }
        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }
        public String getTeacherName() {
            return teacherName;
        }
        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }
        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }


        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }


        public String getEmail() {
            return Email;
        }
        public void setEmail(String email) {
            this.Email = email;
        }
        public Teacher(String teacherId, String teacherName, String subject, String city,
                       String Email) {
            super();
            this.teacherId = teacherId;
            this.teacherName = teacherName;
            this.subject = subject;
            this.city = city;
            this.Email = Email;
        }
        public Teacher() {
            super();
        }



    }
