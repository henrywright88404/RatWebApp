package com.rat.app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rat implements Serializable {

	private static final long serialVersionUID = 1L;
	// TODO REVIEW VARIABLES NEEDED
	private int id;
	public final String[] events = { "SEPT2010", "DEC2010", "FEB2011", "JUNE2011", "DEC2011" };
	private String[] claimNumbers = { "", "", "Nothing Loaded", "", "" };
	private String mainClaim = "Main Claim not selected";
	private String customerName;
	private List<ReserveFigures> ReserveFigures = new ArrayList<>();
	private List<ReserveFigures> Cat3ReserveFigures = new ArrayList<>();
	private List<ReserveFigures> RetainingWallFigures = new ArrayList<>();
	private List<Betterment> Betterment = new ArrayList<>();
	private List<Variation> Variation = new ArrayList<>();
	private List<Payment> Payment = new ArrayList<>();
	private Apportionment Apportionment = new Apportionment();
	private Apportionment Cat3Apportionment = new Apportionment();
	private Apportionment RetainingWallApportionment = new Apportionment();
	private BigDecimal Total = new BigDecimal(0);

	// TODO REVIEW METHODS TO GET / SET VARIABLES

	public String[] getClaimNumbers() {
		return claimNumbers;
	}

	public String getClaimNumber(int poss) {
		return claimNumbers[poss];
	}

	public void setClaimNumbers(String[] claimNumbers) {
		this.claimNumbers = claimNumbers;
	}

	public List<ReserveFigures> getReserveFigures() {
		return ReserveFigures;
	}

	public void addReserveFigures(String name, double amount, String sourceOfData) {
		ReserveFigures temp = new ReserveFigures(name, amount, sourceOfData);
		ReserveFigures.add(temp);
		addToTotal(BigDecimal.valueOf(amount));
	}

	public List<Betterment> getBetterment() {
		return Betterment;
	}

	public void addBetterment(String descrpition, double amount, String sourceOfData) {
		Betterment.add(new Betterment(descrpition, amount, sourceOfData));
		addToTotal(BigDecimal.valueOf(amount));
	}

	public List<Variation> getVariation() {
		return Variation;
	}

	public void addVariation(String descrpition, double amount, String sourceOfData) {
		Variation.add(new Variation(descrpition, amount, sourceOfData));
		addToTotal(BigDecimal.valueOf(amount));
	}

	public List<Payment> getPayments() {
		return Payment;
	}

	public void addPayment(String descrpition, double amount, String note, String event) {
		Payment.add(new Payment(descrpition, amount, note, event));
		subFromTotal(BigDecimal.valueOf(amount));
	}

	public String[] getApportionment() {
		return Apportionment.getApportionment();
	}

	public String getApportionment(int poss) {
		return Apportionment.getApportionment(poss);
	}

	public void setApportionment(Apportionment apportionment) {
		Apportionment = apportionment;
	}

	public double getTotal() {
		return Total.doubleValue();
	}

	@SuppressWarnings("unused")
	private void setTotal(BigDecimal total) {
		Total = total;
	}

	private void addToTotal(BigDecimal addition) {
		Total = Total.add(addition);
	}

	private void subFromTotal(BigDecimal subtract) {
		Total = Total.subtract(subtract);
	}

	public String[] getEvents() {
		return events;
	}

	public String getMainClaim() {
		return mainClaim;
	}

	public void setMainClaim(String mainClaim) {
		this.mainClaim = mainClaim;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String name) {
		this.customerName = name;
	}

	public String[] getCat3Apportionment() {
		return Cat3Apportionment.getApportionment();
	}
	public String getCat3Apportionment(int poss) {
		return Cat3Apportionment.getApportionment(poss);
	}

	// public void setCat3Apportionment(String event, double
	// apportionmentFigure) {
	// Cat3Apportionment.setApportionment(event, apportionmentFigure);
	// }
	public void setCat3Apportionment(Apportionment c3) {
		this.Cat3Apportionment = c3;
	}

	public String[] getRetainingWallApportionment() {
		return RetainingWallApportionment.getApportionment();
	}
	public String getRetainingWallApportionment(int poss) {
		return RetainingWallApportionment.getApportionment(poss);
	}

	public void setRetainingWallApportionment(Apportionment retainingWallApportionment) {
		RetainingWallApportionment = retainingWallApportionment;
	}

	public List<ReserveFigures> getCat3ReserveFigures() {
		return Cat3ReserveFigures;
	}

	public void addCat3ReserveFigures(String name, double amount, String sourceOfData) {
		Cat3ReserveFigures.add(new ReserveFigures(name, amount, sourceOfData));
		addToTotal(BigDecimal.valueOf(amount));
	}

	public List<ReserveFigures> getRetainingWallFigures() {
		return RetainingWallFigures;

	}

	public void addRetainingWallFigures(String name, double amount, String sourceOfData) {
		RetainingWallFigures.add(new ReserveFigures(name, amount, sourceOfData));
		addToTotal(BigDecimal.valueOf(amount));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(claimNumbers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rat other = (Rat) obj;
		if (!Arrays.equals(claimNumbers, other.claimNumbers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rat [id=" + id + ", events=" + Arrays.toString(events) + ", claimNumbers="
				+ Arrays.toString(claimNumbers) + ", mainClaim=" + mainClaim + ", customerName=" + customerName
				+ ", ReserveFigures=" + ReserveFigures + ", Cat3ReserveFigures=" + Cat3ReserveFigures
				+ ", RetainingWallFigures=" + RetainingWallFigures + ", Betterment=" + Betterment + ", Variation="
				+ Variation + ", Payment=" + Payment + ", Apportionment=" + Apportionment + ", Cat3Apportionment="
				+ Cat3Apportionment + ", RetainingWallApportionment=" + RetainingWallApportionment + ", Total=" + Total
				+ "]";
	}

	// TODO create method to update the total and ensure all possible
	// alterations to the total are dealt with.

}
