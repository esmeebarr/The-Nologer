package com.nology.nologer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        String[] interests = {"Skiing", "Holidays"};
        Student john = new Student(0, "John", "Doe", 50, "London", interests);
        students.add(john);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        int idAsInt = Integer.parseInt(studentId);
        return this.students.get(idAsInt);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        this.students.add(student);

        return student;
    }

    // delete a student by id as well
    @DeleteMapping("/students/delete")
    public Student deleteStudent(@PathVariable String studentId) {
        int idAsInt = Integer.parseInt(studentId);
        return this.students.remove(idAsInt);
    }
}
