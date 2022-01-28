/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class CourseNotFoundException extends Exception{

    String courseid;

    /**
     * Parameterized constructor
     * @param courseid
     */
    public CourseNotFoundException(String courseid){
        this.courseid = courseid;
    }

    /**
     *Message thrown by exception
     */
    public String getMessage(){
        return "Course with courseid : "+courseid+" is not found";
    }
}
