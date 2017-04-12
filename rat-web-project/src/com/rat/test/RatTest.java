package com.rat.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.rat.app.Apportionment;
import com.rat.app.Betterment;
import com.rat.app.Payment;
import com.rat.app.Rat;
import com.rat.app.ReserveFigures;
import com.rat.app.Variation;

public class RatTest {

	@Test
	public final void testHashCode() {
		Rat rat = new Rat();
		rat.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });
		Rat rat2 = new Rat();
		rat2.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });

		assertEquals(rat.hashCode(), rat2.hashCode());
	}

	@Test
	public final void testGetClaimNumbers() {
		Rat rat = new Rat();
		rat.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });
		Rat rat2 = new Rat();
		rat2.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });

		assertArrayEquals(rat.getClaimNumbers(), rat2.getClaimNumbers());
	}

	@Test
	public final void testGetClaimNumber() {

		Rat rat = new Rat();
		rat.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });
		Rat rat2 = new Rat();
		rat2.setClaimNumbers(new String[] { "1", "2", "3", "4", "5" });
		assertEquals(rat.getClaimNumber(0), rat2.getClaimNumber(0));
		assertEquals(rat.getClaimNumber(1), rat2.getClaimNumber(1));
		assertEquals(rat.getClaimNumber(2), rat2.getClaimNumber(2));
		assertEquals(rat.getClaimNumber(3), rat2.getClaimNumber(3));
		assertEquals(rat.getClaimNumber(4), rat2.getClaimNumber(4));
	}

	@Test
	public final void testGetReserveFigures() {
		Rat rat = new Rat();
		rat.addReserveFigures("Test", 300, "N/a");

		List<ReserveFigures> rvList = new ArrayList<>();
		ReserveFigures rv = new ReserveFigures("Test", 300, "N/a");
		rvList.add(rv);

		assertEquals(rat.getReserveFigures().toString(), rvList.toString());
	}

	@Test
	public final void testAddReserveFigures() {
		Rat rat = new Rat();
		rat.addReserveFigures("Test", 300, "N/a");

		List<ReserveFigures> rvList = new ArrayList<>();
		ReserveFigures rv = new ReserveFigures("Test", 300, "N/a");
		rvList.add(rv);

		assertEquals(rat.getReserveFigures().toString(), rvList.toString());
	}

	@Test
	public final void testGetBetterment() {
		Rat rat = new Rat();
		rat.addBetterment("Test", 300, "N/a");
		List<Betterment> test = rat.getBetterment();

		Betterment btmt = new Betterment("Test", 300, "N/a");

		assertEquals(test.get(0), btmt);
	}

	@Test
	public final void testAddBetterment() {
		Rat rat = new Rat();
		rat.addBetterment("Test", 300, "N/a");
		List<Betterment> test = rat.getBetterment();

		Betterment btmt = new Betterment("Test", 300, "N/a");

		assertEquals(test.get(0), btmt);
	}

	@Test
	public final void testGetVariation() {
		Rat rat = new Rat();
		rat.addVariation("Test", 300, "N/a");
		List<Variation> test = rat.getVariation();

		Variation var = new Variation("Test", 300, "N/a");

		assertEquals(test.get(0), var);
	}

	@Test
	public final void testAddVariation() {
		Rat rat = new Rat();
		rat.addVariation("Test", 300, "N/a");
		List<Variation> test = rat.getVariation();

		Variation var = new Variation("Test", 300, "N/a");

		assertEquals(test.get(0), var);
	}

	@Test
	public final void testGetPayment() {
		Rat rat = new Rat();
		rat.addPayment("Test", 300, "N/a", "SEPT2010");
		List<Payment> test = rat.getPayments();

		Payment pay = new Payment("Test", 300, "N/a");

		assertEquals(test.get(0), pay);
	}

	@Test
	public final void testAddPayment() {
		Rat rat = new Rat();
		rat.addPayment("Test", 300, "N/a", "SEPT2010");
		List<Payment> test = rat.getPayments();

		Payment pay = new Payment("Test", 300, "N/a");

		assertEquals(test.get(0), pay);
		assertEquals(rat.getTotal(), -300,0.01);
	}

	@Test
	public final void testGetApportionment() {

		Rat rat = new Rat();
		Apportionment app = new Apportionment();
		app.calculateAndSetApportionment(0, 2000, 300000, 100, 0);
		rat.setApportionment(app);

		String[] inRat = rat.getApportionment();
		String[] direct = app.getApportionment();

		assertEquals(inRat[0], direct[0]);
		assertEquals(inRat[1], direct[1]);
		assertEquals(inRat[2], direct[2]);
		assertEquals(inRat[3], direct[3]);
		assertEquals(inRat[4], direct[4]);

	}

	@Test
	public final void testSetApportionment() {
		Rat rat = new Rat();
		Apportionment app = new Apportionment();
		app.calculateAndSetApportionment(0, 2000, 300000, 100, 0);
		rat.setApportionment(app);

		String[] inRat = rat.getApportionment();
		String[] direct = app.getApportionment();

		assertEquals(inRat[0], direct[0]);
		assertEquals(inRat[1], direct[1]);
		assertEquals(inRat[2], direct[2]);
		assertEquals(inRat[3], direct[3]);
		assertEquals(inRat[4], direct[4]);
	}

	@Test
	public final void testGetTotal() {
		Rat rat = new Rat();
		rat.addReserveFigures("Test", 3000, "N/a");
		rat.addReserveFigures("Test", 3020, "N/a");
		rat.addReserveFigures("Test", 3010, "N/a");
		rat.addReserveFigures("Test", 3100, "N/a");
		rat.addReserveFigures("Test", 3100, "N/a");
		rat.addReserveFigures("Test", 3100, "N/a");
		rat.addReserveFigures("Test", 3100, "N/a");
		rat.addReserveFigures("Test", 3100.98, "N/a");
		rat.addPayment("Test", 5992.98, "Test", "FEB2011");

		BigDecimal bd = new BigDecimal(18538);

		assertEquals(rat.getTotal(), bd.doubleValue(),0.01);

	}

	@Test
	public final void testGetEvents() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMainClaim() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetMainClaim() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCustomerName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCustomerName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCat3Apportionment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCat3Apportionment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRetainingWallApportionment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetRetainingWallApportionment() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCat3ReserveFigures() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddCat3ReserveFigures() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRetainingWallFigures() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddRetainingWallFigures() {
		fail("Not yet implemented"); // TODO
	}

}
