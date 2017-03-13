package com.rat.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rat implements Serializable{
	

	private static final long serialVersionUID = 1L;
	//TODO REVIEW VARIABLES NEEDED 
	private int id;
	public final String[] events = { "SEPT2010", "DEC2010", "FEB2011", "JUNE2011", "DEC2011" };
	private String [] claimNumbers ={"","","Nothing Loaded","",""};
	private String mainClaim = "Main Claim not selected";
	private String customerName;
	private List<ReserveFigures> ReserveFigures = new ArrayList<>() ;
	private List<ReserveFigures> Cat3ReserveFigures = new ArrayList<>() ;
	private List<ReserveFigures> RetainingWallFigures = new ArrayList<>() ;
	private List<Betterment> Betterment= new ArrayList<>() ;
	private List<Variation> Variation = new ArrayList<>() ;
	private List<Payment> Payment= new ArrayList<>() ;
	private Apportionment Apportionment = new Apportionment();
	private Apportionment Cat3Apportionment= new Apportionment();
	private Apportionment RetainingWallApportionment= new Apportionment();
	private double Total = 0.00;
	
	//TODO REVIEW METHODS TO GET / SET VARIABLES 
	
	public String[] getClaimNumbers() {
		return claimNumbers;
	}
	public String getClaimNumber() {
		return claimNumbers[2];
	}
	public void setClaimNumbers(String[] claimNumbers) {
		this.claimNumbers = claimNumbers;
	}
	public List<ReserveFigures> getReserveFigures() {
		return ReserveFigures;
	}
	public void addReserveFigures(String name, double amount, String sourceOfData ) {
		ReserveFigures temp = new ReserveFigures(name,amount, sourceOfData);
		ReserveFigures.add(temp);
		setTotal(getTotal()+amount);
	}
	public List<Betterment> getBetterment() {
		return Betterment;
	}
	public void addBetterment(String descrpition, double amount, String sourceOfData) {
		Betterment.add(new Betterment(descrpition, amount,sourceOfData));
		setTotal(getTotal()+amount);
	}
	public List<Variation> getVariation() {
		return Variation;
	}
	public void addVariation(String descrpition, double amount, String sourceOfData) {
		Variation.add(new Variation(descrpition,amount,sourceOfData));
		setTotal(getTotal()+amount);
	}
	public List<Payment> getPayment() {
		return Payment;
	}
	public void addPayment(String descrpition, double amount, String note, String event) {
		Payment.add(new Payment( descrpition, amount, note, event));
		setTotal(getTotal()-amount);
	}
	public String[] getApportionment() {
		return Apportionment.getApportionment();
	}
	public void setApportionment(Apportionment apportionment) {
		Apportionment = apportionment;
	}
	public double getTotal() {
		return Total;
	}
	private void setTotal(double total) {
		Total = total;
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
	public void setCat3Apportionment(String event, double apportionmentFigure) {
		Cat3Apportionment.setApportionment(event, apportionmentFigure);
	}
	public Apportionment getRetainingWallApportionment() {
		return RetainingWallApportionment;
	}
	public void setRetainingWallApportionment(Apportionment retainingWallApportionment) {
		RetainingWallApportionment = retainingWallApportionment;
	}
	public List<ReserveFigures> getCat3ReserveFigures() {
		return Cat3ReserveFigures;
	}
	public void addCat3ReserveFigures(String name, double amount, String sourceOfData ) {
		Cat3ReserveFigures.add(new ReserveFigures(name, amount,sourceOfData));
	}
	public List<ReserveFigures> getRetainingWallFigures() {
		return RetainingWallFigures;
	}
	public void addRetainingWallFigures(String name, double amount, String sourceOfData ) {
		RetainingWallFigures.add(new ReserveFigures(name, amount,sourceOfData));
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	//TODO create method to update the total and ensure all possible alterations to the total are dealt with. 

	
	
}
