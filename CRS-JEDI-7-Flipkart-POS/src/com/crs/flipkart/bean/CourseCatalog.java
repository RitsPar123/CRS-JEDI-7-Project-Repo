package com.crs.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    List<Course> courses;

    public CourseCatalog() {
        courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
