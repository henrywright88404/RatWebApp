package com.rat.app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apportionment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * TODO INDEPTH REVIEW
	 */
	final String[] events = { "SEPT2010", "DEC2010", "FEB2011", "JUNE2011", "DEC2011" };
	private double[] apportionment = new double[5];
	DecimalFormat df = new DecimalFormat("#,###,###.00");
	DecimalFormat percentage = new DecimalFormat("##.##%");

	public String[] getEventsList() {
		return events;
	}

	public void calculateAndSetApportionment(double SEPT2010, double DEC2010, double FEB2011, double JUNE2011,
			double DEC2011) {
		setApportionment("SEPT2010", SEPT2010 / (SEPT2010 + DEC2010 + FEB2011 + JUNE2011 + DEC2011));
		setApportionment("DEC2010", DEC2010 / (SEPT2010 + DEC2010 + FEB2011 + JUNE2011 + DEC2011));
		setApportionment("FEB2011", FEB2011 / (SEPT2010 + DEC2010 + FEB2011 + JUNE2011 + DEC2011));
		setApportionment("JUNE2011", JUNE2011 / (SEPT2010 + DEC2010 + FEB2011 + JUNE2011 + DEC2011));
		setApportionment("DEC2011", DEC2011 / (SEPT2010 + DEC2010 + FEB2011 + JUNE2011 + DEC2011));
	}

	/**
	 * @return the apportionment
	 */
	public void printApportionment() {
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		for (int i = 0; i <= 4; i++) {

			if (apportionment[i] < 0.01) {
				// Skip printing if the apportionment is zero
			} else {
				System.out.print(events[i] + " ");
				System.out.print(nf.format(apportionment[i]) + " ");
			}
		}
		System.out.println(" ");

	}

	public double getApportionment(String event, double figure) {

		for (int i = 0; i <= 4; i++) {
			if (event.equalsIgnoreCase(this.events[i])) {
				return figure * apportionment[i];
			}
		}

		return 0.0;
	}

	public String[] getApportionment() {
		String[] apportionmentAsString = new String[5];
		int poss = 0;
		for (double apportionmentPercent : apportionment) {
			apportionmentAsString[poss] = Double.toString(apportionmentPercent);
		}

		return apportionmentAsString;

	}

	public String getApportionment(int poss) {
		return Double.toString(apportionment[poss] * 100);
	}

	/**
	 * @param apportionment
	 *            Set the apportionment for a specific event
	 */
	public void setApportionment(String event, double apportionmentFigure) {

		for (int i = 0; i <= 4; i++) {
			if (event.equalsIgnoreCase(this.events[i])) {

				apportionment[i] = apportionmentFigure;
			}

		}

	}

	public void checkApportionmentInput() {
		double totalapportionment = 0.0;
		for (double elements : apportionment) {
			totalapportionment = totalapportionment + elements;
		}

		if (totalapportionment == 0) {
			return;
		} else if (totalapportionment != 1.0) {
			System.out.println(
					"There is an error with the apportionment %. \n Try entering the apportionment again, the current apportionment is ");
			getApportionment();
		}
	}

	public List<String> returnApportionedReserveFigures(double figure) {
		List<String> returnString = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			if (apportionment[i] == 0) {
				returnString.add("");

			} else {
				returnString.add(" $" + df.format(figure * apportionment[i]) + " ");
			}
		}
		return returnString;
	}
	
	public List<String> returnApportionedReserveFigures(BigDecimal figure) {
		List<String> returnString = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			if (apportionment[i] == 0) {
				returnString.add("");

			} else {
				returnString.add(" $" + df.format(figure.doubleValue() * apportionment[i]) + " ");
			}
		}
		return returnString;
	}
	// public void userInputApportionment(){
	// System.out.println("Do you know the apportionment? Enter Y or N");
	// Scanner reader = new Scanner(System.in);
	//
	// if (reader.hasNext() && (reader.nextLine().equalsIgnoreCase("y"))) {
	//
	// RatData.Rat.addKnownApportionment();
	//
	// } else {
	// RatData.Rat.addUnknownApportionment();
	// }

	@Override
	public String toString() {
		return "Apportionment [events=" + Arrays.toString(events) + ", apportionment=" + Arrays.toString(apportionment)
				+ ", df=" + df + ", percentage=" + percentage + "]";
	}

}
