package com.nology.nologer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class CourseController {
    List<Course> courses = new ArrayList<Course>();
    public CourseController() {
        Course webdev = new Course("1234", "Web Development");
        courses.add(webdev);
    }
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courses;
    }
    @GetMapping("/course/{courseID}")
    public Course getCourse(@PathVariable String courseID) {
        try {
            for (Course course : courses) {
                if ((course.getCourseId().equals(courseID))) return course;
            }
            return null;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }
    @PostMapping("/course")
    public Course createStudent(@RequestBody Course course) {
        System.out.println("The name is: " + course.getName());
        this.courses.add(course);
        return course;
    }
    @DeleteMapping("/student/{courseID}")
    public Course deleteCourse(@PathVariable String courseId) {
        for (int i= 0; i < this.courses.size(); i++){
            Course course = this.courses.get(i);
            if (course.getCourseId().equals(courseId)){
                this.courses.remove(i);
            }
        }


        try {
            for (Course course : courses) {
                if ((course.getCourseId().equals(courseId))) {
                    System.out.println(course);
                    this.courses.remove(course);
                    System.out.println(courses);
                    return course;
                }
            }
            return null;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }
}