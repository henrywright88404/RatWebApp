package com.rat.control;

import java.io.IOException;
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
	private RatControlHelper rCHelper;
	
	@Resource (name = "jdbc/rat-web-project")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		
		//create our ratDbUtil ... and pass in the conn pool / data source
		try{
			ratDbUtil = new RatDbUtil(dataSource);
		}catch (Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			// read the command param 
			String theCommand = request.getParameter("command");
			
			if(theCommand == null){
				theCommand = "LIST";
			}
			// route to appopriate method 
			switch (theCommand){
			case"LIST":
				listRats(request,response);
				break;
			case"ADD":
				addRat(request,response);
				break;
			case"DELETE":
				deleteRat(request,response);
				break;

				
			default:
				listRats(request,response);
			}
			
			
			// list the students ... in MVC fashion
			listRats(request,response);
		}catch (Exception e){
			throw new ServletException(e);
		}
	}

	private void deleteRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read Rat id of selected Rat
				String id = request.getParameter("id");
				
				// delete student from db 
				ratDbUtil.deleteRatFromDataBase(id);
				
				System.out.println("Deleting rat id " +id);
				// reload the student list. 
				listRats(request,response);
		
	}

	private void addRat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO read form data
				// get all reserve figure descriptions 
		String[] resFigureDescription = request.getParameterValues("reserveFiguresDescripton");
				//
		String[] resFigureSource = request.getParameterValues("reserveFiguresNote");
				// get all reserve figure amounts 
		String[] resFigureAmounts = request.getParameterValues("reserveFiguresAmount");
		
				// get Cat 3 description
		String[] cat3description = request.getParameterValues("cat3");
				// get Cat 3 amounts 
		String[] cat3amount = request.getParameterValues("cat3Amount");
				// get Cat 3 note
		String[] cat3Note = request.getParameterValues("cat3Note");
		

				
				// get retaining wall descriptions 
		String[] retainingWallDescription = request.getParameterValues("retainingwall");
				// get retaining wall amounts 
		String[] retainingWallAmount = request.getParameterValues("retainingwallamount");	
				// get Rtaining wall note 
		String[] retWallNote = request.getParameterValues("retWallNote");
		
				// get LA fee descriptions 
		String[] laDescription = request.getParameterValues("lossadjuster");		
				// get LA fee amounts 
		String[] laAmount = request.getParameterValues("lossadjusteramount");	
				// get LA note
		String[] laNote = request.getParameterValues("laNote");		
		
				// get legal fee descriptions 
		String[] legalFeeDescription = request.getParameterValues("legalfees");		
				// get legal fee amounts 
		String[] legalFeeAmount = request.getParameterValues("legalfeesAmount");	
				// get legal note
		String[] legalNote = request.getParameterValues("legalNote");
				
				// get LOR descrptions 
		String[] lossOfRentDescription = request.getParameterValues("lossofrent");		
				// get LOR fee amounts 		
		String[] lossOfRentAmount = request.getParameterValues("lossofrentamount");		
		

		String[] claimNumbers = request.getParameterValues("claimnumbers");
		//TODO implement 
		
		String[] paymentType = request.getParameterValues("payment_type");
		
		String[] paymentDescription = request.getParameterValues("payment_description");
		
		String[] paymentAmount = request.getParameterValues("payment_amount");
		
		
		// TODO add payments capture
		
		
		
		//TODO create Rat object
		
		
		Rat tempRat = new Rat();
		
		
			//System.out.println(claimNumbers.toString());
		
	
			tempRat.setClaimNumbers(claimNumbers);
		for (int i = 0 ; i< claimNumbers.length ; i++){
			if (claimNumbers[i].contains("*")){
				tempRat.setMainClaim(claimNumbers[i]);
			}
		}
		
		
		for ( int i = 0; i < resFigureDescription.length; i++){
			if (rCHelper.isAmountWithDescription(i, resFigureDescription, resFigureAmounts) ){
				System.out.println(resFigureDescription[i]+ " " + Double.parseDouble(resFigureAmounts[i]));
				tempRat.addReserveFigures(resFigureDescription[i], Double.parseDouble(resFigureAmounts[i]), resFigureSource[i]);
			}else{

			}
			
		}
		
		for ( int i = 0; i < cat3description.length; i++){
			if(rCHelper.isAmountWithDescription(i, cat3description, cat3amount)){
				System.out.println(cat3description[i]+ " " + Double.parseDouble(cat3amount[i]));
				tempRat.addCat3ReserveFigures(cat3description[i], Double.parseDouble(cat3amount[i]),cat3Note[i]);
			}
		}
		
		for ( int i = 0; i < retainingWallDescription.length; i++){
			if(rCHelper.isAmountWithDescription(i, retainingWallDescription, retainingWallAmount)){
				System.out.println(retainingWallDescription[i]+ " " + Double.parseDouble(retainingWallAmount[i]));
				tempRat.addReserveFigures(retainingWallDescription[i], Double.parseDouble(retainingWallAmount[i]),retWallNote[i]);
			}
		}
		
		for ( int i = 0; i < laDescription.length; i++){
			if(rCHelper.isAmountWithDescription(i, laDescription, laAmount)){
				System.out.println(laDescription[i]+ " " + Double.parseDouble(laAmount[i]));
				tempRat.addReserveFigures(laDescription[i], Double.parseDouble(laAmount[i]),laNote[i]);
			}
			
		}
		
		for ( int i = 0; i < legalFeeDescription.length; i++){
			if (rCHelper.isAmountWithDescription(i, legalFeeDescription, legalFeeAmount)){
				System.out.println(legalFeeDescription[i]+ " " + Double.parseDouble(legalFeeAmount[i]));
				tempRat.addReserveFigures(legalFeeDescription[i], Double.parseDouble(legalFeeAmount[i]),legalNote[i]);
			}
			
		}
//		if (lossOfRentDescription.length >0 ){
//			for ( int i = 0; i < lossOfRentDescription.length; i++){
//				//System.out.println(lossOfRentDescription[i]+ " " + Double.parseDouble(lossOfRentAmount[i]));
//				tempRat.addReserveFigures(lossOfRentDescription[i], Double.parseDouble(lossOfRentAmount[i]));
//			}
//		}
		
	
		
		//TODO add the rat to the Db 
		ratDbUtil.addRat(tempRat);
		
		//TODO send back to main page
		listRats(request,response);
	}

	private void listRats(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// get students from db util 
		List<Rat> rats = ratDbUtil.getRats();
		
		
		// add students to request 
		request.setAttribute("RAT_LIST", rats);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-rats.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private boolean arrIsEqual(String[] arr1, String[] arr2){
		if(arr1.length > arr2.length ||arr1.length < arr2.length){
			System.out.println("arrays are not equal");
			return false;
		}else{
			return true;
		}
	}
	

}
