/**
 * 
 */
package com.rat.control;

/**
 * @author Marc
 *
 */
public class RatControlHelper {
	
	public boolean isAmountWithDescription (int i,String[] A, String[]B){
		
		if(A[i].isEmpty() || B[i].isEmpty()){
			return false;
		}
		else{
			return true;
		}
		
	}

}
