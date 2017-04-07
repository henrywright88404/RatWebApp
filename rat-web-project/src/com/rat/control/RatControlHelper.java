/**
 * 
 */
package com.rat.control;

import com.rat.app.Apportionment;

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

	public static Apportionment setApportionment(String[] claimapportionment) {
		
		Apportionment temp = new Apportionment();
		String[] events = temp.getEventsList();
		boolean appUpdated = false;
		
		for (int i = 0; i < claimapportionment.length ;i++){
			System.out.println("Apportionment " + events[i] + " " + claimapportionment[i]);
			
			if (!claimapportionment[i].isEmpty()){
				temp.setApportionment(events[i], Double.parseDouble(claimapportionment[i])/100);
				appUpdated = true;
			}
		}
		
		if (appUpdated = true ){
			temp.checkApportionmentInput();
		}
		
		return temp;
		
	}

}
