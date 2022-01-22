/**
 * 
 */
package com.crs.flipkart.bean;

import java.util.HashMap;

/**
 * @author harsh
 *
 */
public class ReportCard {
	// id
	// String , double
	// gpa
	
	int id;
	HashMap<String,Double> m; // Subject Code, gpa
	double gpa;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the m
	 */
	public HashMap<String, Double> getM() {
		return m;
	}
	/**
	 * @param m the m to set
	 */
	public void setM(HashMap<String, Double> m) {
		this.m = m;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}
