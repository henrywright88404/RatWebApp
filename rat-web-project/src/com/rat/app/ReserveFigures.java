package com.rat.app;

import java.io.Serializable;

public class ReserveFigures implements Serializable{


	private static final long serialVersionUID = 1L;
	/**
	 * TODO REVIEW
	 */

	private String name;
	private double amount;
	private String sourceOfData;

	public ReserveFigures(String name, double amount, String sourceOfData ) {
		this.name = name;
		this.amount = amount;
		this.sourceOfData = sourceOfData;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getSourceOfData() {
		return sourceOfData;
	}

	public void setSourceOfData(String sourceOfData) {
		this.sourceOfData = sourceOfData;
	}

	@Override
	public String toString() {
		return "ReserveFigures [name=" + name + ", amount=" + amount + ", sourceOfData=" + sourceOfData + "]";
	}
	
	

}
