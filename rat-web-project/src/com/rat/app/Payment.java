package com.rat.app;


public class Payment extends ReserveFigures {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * TODO REVIEW
	 */

	String event;


	public Payment(String name, double amount, String note, String event) {
		super(name, amount,note);
		this.event = event;
	}

	public Payment(String name, double amount, String note) {
		super(name, amount,note);
	}

	@Override
	public String toString() {
		return "Payment [event=" + event + ", getName()=" + getName() + ", getAmount()=" + getAmount()
				+ ", getSourceOfData()=" + getSourceOfData() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
