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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sourceOfData == null) ? 0 : sourceOfData.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ReserveFigures))
			return false;
		ReserveFigures other = (ReserveFigures) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sourceOfData == null) {
			if (other.sourceOfData != null)
				return false;
		} else if (!sourceOfData.equals(other.sourceOfData))
			return false;
		return true;
	}
	
	

}
