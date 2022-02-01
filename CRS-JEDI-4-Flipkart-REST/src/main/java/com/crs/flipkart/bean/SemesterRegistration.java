package com.crs.flipkart.bean;

public class SemesterRegistration {
    private String studentId;
    private String registrationDate;
    private boolean feepaid;
    
    public SemesterRegistration()
    {
    	
    }
    /**
     * Parameterized Constructor
     * @param studentId
     */
    
    public SemesterRegistration(String studentId) {
        this.studentId = studentId;
    	this.registrationDate = (new java.sql.Date(System.currentTimeMillis())).toString();
    	this.feepaid = false;
    }

    /**
     * Method to get studentId
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
    } 

    /**
     * Method to set studentId 
     * @param studentId
     */
    public void setStudentId(String studentId){
        this.studentId = studentId;
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
