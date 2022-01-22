package com.crs.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class SemesterRegistration {
    private String studentId;
    private String registrationDate;
    private List<Course> courses;
    private boolean feepaid;

    public SemesterRegistration(String studentId) {
        this.studentId = studentId;
        courses = new ArrayList<>();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isFeepaid() {
        return feepaid;
    }

    public void setFeepaid(boolean feepaid) {
        this.feepaid = feepaid;
    }

}
