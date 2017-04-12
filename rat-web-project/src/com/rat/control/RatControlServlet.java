package com.rat.control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.rat.app.Rat;
import com.rat.dbutil.RatDbUtil;

/**
 * Servlet implementation class RatControlServlet
 */
@WebServlet("/RatControlServlet")
public class RatControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RatDbUtil ratDbUtil;
	

	@Resource(name = "jdbc/rat-web-project")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create our ratDbUtil ... and pass in the conn pool / data source
		try {
			ratDbUtil = new RatDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the command param
			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LIST";
			}
			// route to appopriate method
			switch (theCommand) {
			case "LIST":
				listRats(request, response);
				break;
			case "ADD":
				addRat(request, response);
				break;
			case "DELETE":
				deleteRat(request, response);
				break;
			case "LOAD":
				loadRat(request, response);

			}

			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// read the command param
			String theCommand = request.getParameter("command");

			Enumeration<String> params = request.getParameterNames();
			while (params.hasMoreElements()) {
				String paramName = (String) params.nextElement();
				System.out
						.println("Parameter Name - " + paramName + ", \t\t Value - " + request.getParameter(paramName));
			}

			if (theCommand == null) {
				theCommand = "LIST";
			}
			// route to appropriate method
			switch (theCommand) {
			case "LIST":
				listRats(request, response);
				break;
			case "ADD":
				addRat(request, response);
				break;
			case "DELETE":
				deleteRat(request, response);
				break;
			case "LOAD":
				loadRat(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void loadRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id
		String ratId = request.getParameter("ratId");

		// get rat from database(dbUtil)
		Rat theRat = ratDbUtil.getSelectedRat(ratId);

		System.out.print(theRat.getCat3ReserveFigures().toString());

		// place student in the request attribute
		request.setAttribute("THE_RAT", theRat);

		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-rat.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id of selected Rat
		String id = request.getParameter("id");

		// delete student from db
		ratDbUtil.deleteRatFromDataBase(id);

		System.out.println("Deleting rat id " + id);
		// reload the student list.
		listRats(request, response);

	}

	private void addRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO read form data

		String[] claimNumbers = request.getParameterValues("claimnumbers");

		String[] claimapportionment = request.getParameterValues("apportionment");

		// get all reserve figure descriptions
		String[] resFigureDescription = request.getParameterValues("reserveFiguresDescripton");
		//
		String[] resFigureSource = request.getParameterValues("reserveFiguresNote");
		// get all reserve figure amounts
		String[] resFigureAmounts = request.getParameterValues("reserveFiguresAmount");

		// get Cat 3 amounts
		String[] cat3amount = request.getParameterValues("cat3Amount");
		// get Cat 3 note
		String[] cat3Note = request.getParameterValues("cat3Note");
		// get Cat 3 apportionment
		String[] cat3Apportionment = request.getParameterValues("cat3apportionment");

		// get retaining wall amounts
		String[] retainingWallAmount = request.getParameterValues("retainingwallamount");
		// get Retaining wall note
		String[] retWallNote = request.getParameterValues("retWallNote");
		// get retaining wall apportionment
		String[] retainingWallApportionment = request.getParameterValues("retainingWallApportionment");

		String[] paymentType = request.getParameterValues("PaymentType");

		String[] paymentName = request.getParameterValues("Paymentname");

		String[] paymentAmount = request.getParameterValues("Paymentamount");

		String[] paymentEvent = request.getParameterValues("PaymentEvent");

		// create Rat object

		Rat tempRat = new Rat();

		// System.out.println(claimNumbers.toString());

		tempRat.setClaimNumbers(claimNumbers);
		for (int i = 0; i < claimNumbers.length; i++) {
			if (claimNumbers[i].contains("*")) {
				tempRat.setMainClaim(claimNumbers[i]);
			}
		}

		tempRat.setApportionment(RatControlHelper.setApportionment(claimapportionment));

		for (int i = 0; i < resFigureDescription.length; i++) {
			if (RatControlHelper.isAmountWithDescription(i, resFigureDescription, resFigureAmounts)) {

				System.out.println(resFigureDescription[i] + " " + Double.parseDouble(resFigureAmounts[i]));
				tempRat.addReserveFigures(resFigureDescription[i], Double.parseDouble(resFigureAmounts[i]),
						resFigureSource[i]);
			}

		}

		if (cat3Note != null) {
			for (int i = 0; i < cat3Note.length; i++) {
				if (RatControlHelper.isAmountWithDescription(i, cat3Note, cat3amount)) {
					System.out.println(cat3Note[i] + " " + Double.parseDouble(cat3amount[i]));
					tempRat.addCat3ReserveFigures(cat3Note[i], Double.parseDouble(cat3amount[i]), cat3Note[i]);
				}
			}
		}

		tempRat.setCat3Apportionment(RatControlHelper.setApportionment(cat3Apportionment));

		if (retWallNote != null) {
			for (int i = 0; i < retWallNote.length; i++) {
				if (RatControlHelper.isAmountWithDescription(i, retWallNote, retainingWallAmount)) {
					tempRat.addRetainingWallFigures(retWallNote[i], Double.parseDouble(retainingWallAmount[i]),
							retWallNote[i]);
				}
			}
		}

		tempRat.setRetainingWallApportionment(RatControlHelper.setApportionment(retainingWallApportionment));

		if (paymentName != null) {
			for (int i = 0; i < paymentName.length; i++) {
				if (RatControlHelper.isAmountWithDescription(i, paymentName, paymentAmount)) {
					tempRat.addPayment(paymentName[i], Double.parseDouble(paymentAmount[i]), paymentType[i],
							paymentEvent[i]);
				}
			}
		} else {
			System.out.println("No payment or not picking it up. ");
		}

		// add the rat to the Db
		ratDbUtil.addRat(tempRat);

		System.out.println("Cat 3 added =" + tempRat.getCat3ReserveFigures().toString());

		// send back to main page
		listRats(request, response);
	}

	private void listRats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Rat> rats = ratDbUtil.getRats();

		// add students to request
		request.setAttribute("RAT_LIST", rats);

		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-rats.jsp");
		dispatcher.forward(request, response);
		return;

	}

	@SuppressWarnings("unused")
	private boolean arrIsEqual(String[] arr1, String[] arr2) {
		if (arr1.length > arr2.length || arr1.length < arr2.length) {
			System.out.println("arrays are not equal");
			return false;
		} else {
			return true;
		}
	}

}
