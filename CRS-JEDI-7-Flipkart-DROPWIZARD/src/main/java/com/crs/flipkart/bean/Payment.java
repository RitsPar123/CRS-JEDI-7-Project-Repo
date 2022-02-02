/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class Payment {

	
	private String studentId;
	private	String  paymentId;
	private String paymentMethod;
	private double amount;
	private String dateOfTransaction;
	private Boolean status;
	
	public Payment()
	{
		
	}
	/**
	 * Parameterized constructor
	 * @param Id
	 * @param paymentId
	 * @param method
	 * @param amount
	 * @param dateT
	 * @param status
	 */
	public Payment(String Id,String paymentId,String method,double amount,String dateT,Boolean status){
		this.studentId = Id;
		this.paymentId = paymentId;
		this.paymentMethod = method;
		this.amount = amount;
		this.dateOfTransaction = dateT;
		this.status = status;
	}
	

	/**Method to get studentId
	 * @return studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**Method to set studentId
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**Method to get PaymentId
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**Method to set PaymentId
	 * @param paymentId
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**Method to get Amount
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**Method to set the amount
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**Method to get dateOfTransaction
	 * @return the dateOfTransaction
	 */
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}

	/**Method to set dateOfTransaction
	 * @param dateOfTransaction the dateOfTransaction to set
	 */
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	/**Method to get paymentStatus
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**Method to set paymentStatus
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	/**
	 * Method to get type of Payment
	 * @return Student Id
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Method to set paymentMethod
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
