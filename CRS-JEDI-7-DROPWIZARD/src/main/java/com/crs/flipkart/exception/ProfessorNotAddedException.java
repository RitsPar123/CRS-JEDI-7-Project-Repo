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
	private String professorId;
	Professor professor; 
	
    /**
     * Parameterized constructor
     * @param prof : professor object
     */
	public ProfessorNotAddedException(Professor prof) {
		this.professor = prof;
	}

    /**
	 * @return the professorId
	 */
	public String getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getMessage(){
        return "Professor with id : "+professor.getId()+"/tDepartment: "+professor.getDepartment()+" cannot be created";
    }
	
	public ProfessorNotAddedException(String professorId) {
		this.professorId = professorId;
	}
}
