package com.rat.app;


public class Betterment extends ReserveFigures {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	public Betterment(String name, double amount,String sourceOfData) {
		super(name, amount, sourceOfData);

	}

	@Override
	public String toString() {
		return "Betterment [getName()=" + getName() + ", getAmount()=" + getAmount() + ", getSourceOfData()="
				+ getSourceOfData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
