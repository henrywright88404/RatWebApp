/**
 * 
 */
package com.rat.control;

/**
 * @author Marc
 *
 */
public class RatControlHelper {

	public static boolean isAmountWithDescription(int i, String[] A, String[] B) {

		boolean hasValues = false;
		if (A[i].isEmpty() || B[i].isEmpty() || A[i] == "" || B[i] == "") {
			//leave as false
		} else {
			hasValues = true;
		}
		return hasValues;
	}

}
