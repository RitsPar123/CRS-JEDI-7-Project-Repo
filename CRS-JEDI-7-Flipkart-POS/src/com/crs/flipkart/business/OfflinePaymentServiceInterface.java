/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.OfflinePayment;

/**
 * @author hardik.kothari
 *
 */
public interface OfflinePaymentServiceInterface {

	/* Method to return offlinePayment object when invoked
	  * @input : None 
	  * @Return : offlinePayment object
	  */
	public OfflinePayment offlineMode();

}
