/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.HashMap;
import java.util.List;

/**
 * @author harsh
 *
 */
public class ReportCard {
	// id
	// String , double
	// gpa
	
	private int id;
	private HashMap<String,Double> m; // Subject Code, gpa
	private double gpa;
	
	//gpa range 0-5 and subject range 100-107
	/**
	 * 
	 * Parameterized Constructor
	 * @param id
	 * @param subjectcode
	 * @param grade
	 */
	public ReportCard(int id,List<String> subjectcode,List<Double> grade){
		this.id = id;
		float temp=0;
		this.m = new HashMap<String,Double>();
		for(int i=0;i < grade.size();i++) {
			m.put(subjectcode.get(i),grade.get(i));
			temp+=grade.get(i);
		}
		this.gpa = temp/grade.size();
	}
	
	/**
	 * Method to get studentId
	 * @return studentId
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method to set studentId
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
	 * Method to get the Subjectcode: gpa hashmap
	 * @return hashmap
	 */
	public HashMap<String, Double> getM() {
		return m;
	}

	/**
	 * Method to get the Subjectcode: gpa hashmap
	 * @param hashmap (subjectcode : gpa)
	 */
	public void setM(HashMap<String, Double> m) {
		this.m = m;
	}

	/**
	 * Method to get GPA
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	/**
	 * Method to set GPA
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}
