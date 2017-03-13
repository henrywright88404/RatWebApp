package com.rat.app;

public class Variation extends ReserveFigures {


	private static final long serialVersionUID = 1L;

	public Variation(String name, double amount, String sourceOfData) {
		super(name, amount, sourceOfData);

	}

	@Override
	public String toString() {
		return "Variation [getName()=" + getName() + ", getAmount()=" + getAmount() + ", getSourceOfData()="
				+ getSourceOfData() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	

}
