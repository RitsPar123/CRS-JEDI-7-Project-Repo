package com.crs.flipkart.bean;

public class SemesterRegistration {
    private String studentId;
    private String registrationDate;
    private boolean feepaid;
    
    public SemesterRegistration(String studentId) {
    	this.studentId = studentId;
    	this.registrationDate = (new java.sql.Date(System.currentTimeMillis())).toString();
    	this.feepaid = false;
    }
    
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the registrationDate
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	/**
	 * @return the feepaid
	 */
	public boolean isFeepaid() {
		return feepaid;
	}
	/**
	 * @param feepaid the feepaid to set
	 */
	public void setFeepaid(boolean feepaid) {
		this.feepaid = feepaid;
	}

    
}
