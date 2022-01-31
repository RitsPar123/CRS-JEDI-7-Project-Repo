/**
 * 
 */
package com.crs.flipkart.exception;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception{

    String sid; 
    String courseid;
    
    public StudentNotFoundException(String id,int s) {
    	this.courseid = id;
    }
    /**
     * Parameterized constructor
     * @param sid : student id
     */
    public StudentNotFoundException(String sid){
        this.sid = sid; 
    }

    /**
     * Message thrown by exception
     */
    public String getMessage(){
        return "Student with id : "+sid+" cannot be found";
    }
    
    public String getMessageWithCourse() {
    	return "No students are registered for course with id : "+ this.courseid;
    } 
}
