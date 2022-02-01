package com.crs.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    List<Course> courses;

    /**Default Constructor 
    */
    public CourseCatalog() {
        courses = new ArrayList<>();
    }

    
    /** Method to get <List>Courses
     * @return List<Course>
     */
    public List<Course> getCourses() {
        return courses;
    }

    
    /** Method to set <List>Courses
     * @param courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
