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

    /**
     * Parameterized constructor
     * @param sid
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
}
