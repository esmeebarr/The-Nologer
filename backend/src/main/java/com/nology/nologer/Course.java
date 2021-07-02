package com.nology.nologer;
public class Course {
    private String courseId;
    private String name;
    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}