/**
 * 
 */
package com.crs.flipkart.exception;

import com.crs.flipkart.bean.Professor;

/**
 * @author srini
 *
 */
@SuppressWarnings("serial")
public class ProfessorNotAddedException extends Exception{
	
	Professor professor; 
	
    /**
     * Parameterized constructor
     * @param prof : professor object
     */
	public ProfessorNotAddedException(Professor prof) {
		this.professor = prof;
	}

    public String getMessage(){
        return "Professor with id : "+professor.getId()+"/tDepartment: "+professor.getDepartment()+" cannot be created";
    }
	
	
}
