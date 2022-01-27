package com.crs.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class SemesterRegistration {
    private String studentId;
    private String registrationDate;
    private List<Course> courses;
    private boolean feepaid;

    /**
     * Parameterized Constructor
     * @param studentId
     */
    public SemesterRegistration(String studentId) {
        this.studentId = studentId;
        courses = new ArrayList<>();
    }

    
    /** 
     * Method to get registration date
     * @return String
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    
    /** 
     * Method to set registration date
     * @param registrationDate
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    
    /** 
     * Method to get courses
     * @return List of courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    
    /** 
     * Method to set courses
     * @param Listofcourses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    
    /** 
     * Method to get feePaid status
     * @return boolean
     */
    public boolean isFeepaid() {
        return feepaid;
    }

    
    /** 
     * Method to set feePaid status
     * @param feepaid
     */
    public void setFeepaid(boolean feepaid) {
        this.feepaid = feepaid;
    }

}
