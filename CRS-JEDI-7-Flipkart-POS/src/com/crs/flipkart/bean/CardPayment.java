/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author hardik.kothari
 *
 */
public class CardPayment extends OnlinePayment{
	private String cardNumber;
	private String cardType;
	/**
	 * @return the cardNumber
	 */
	
	public CardPayment(String cardNumber, String cardType) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
}
