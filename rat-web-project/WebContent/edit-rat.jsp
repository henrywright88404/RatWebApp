<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*, com.rat.app.*"%>

<html>
<head>
<title>Reserve Apportionment Template</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>


	<form action="RatControlServlet" method="post">
		<input type="hidden" name="command" value="EDIT" />
		

		<div class="row">
			<h2 class="text-center">Reserve Apportionment Template View</h2>
		</div>
		<div class="row">
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<td class="col-sm-2">
						<td>
						<th class="col-sm-2 nopadding">Events</th>
						<td class="col-sm-1 nopadding">SEPT</td>
						<td class="col-sm-1 nopadding">DEC</td>
						<td class="col-sm-1 nopadding">FEB</td>
						<td class="col-sm-1 nopadding">JUNE</td>
						<td class="col-sm-1 nopadding">DEC</td>
						<td class="col-sm-2">
						<td>
					</tr>
					<tr>
						<td class="col-sm-2">
						<td>
						<th class="col-sm-2 nopadding">Claim Numbers</th>
						<td class="col-sm-1 nopadding"><input type="text" value="${THE_RAT.getClaimNumber(0) }" name="claimNumbers" class="form-control"/></td>
						<td class="col-sm-1 nopadding"><input type="text" value="${THE_RAT.getClaimNumber(1) }" name="claimNumbers" class="form-control"/></td>
						<td class="col-sm-1 nopadding"><input type="text" value="${THE_RAT.getClaimNumber(2) }" name="claimNumbers" class="form-control"/></td>
						<td class="col-sm-1 nopadding"><input type="text" value="${THE_RAT.getClaimNumber(3) }" name="claimNumbers" class="form-control"/></td>
						<td class="col-sm-1 nopadding"><input type="text" value="${THE_RAT.getClaimNumber(4) }" name="claimNumbers" class="form-control"/></td>
						<td class="col-sm-2">
						<td>
					</tr>
					<tr>
						<td class="col-sm-2">
						<td>
						<th class="col-sm-2 nopadding">Apportionment</th>
						<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getApportionment(0) }" name="apportionment" class="form-control" /></td>
						<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getApportionment(1) }" name="apportionment" class="form-control" /></td>
						<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getApportionment(2) }" name="apportionment" class="form-control" /></td>
						<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getApportionment(3) }" name="apportionment" class="form-control" /></td>
						<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getApportionment(4) }" name="apportionment" class="form-control" /></td>
						<td class="col-sm-2">
						<td>
					</tr>

				</table>
			</div>



			<br> <br>

			<!-- code for the tables to show the Base Eng,Geo etc on the left and the Cat 3 / retaining wall on the right -->

			<div class="col-xs-6">
				<div class="table-responsive">
					<table>
						<tr>
							<td class="col-sm-2 nopadding">
								<h4>Reserve Figures</h4>
							</td>
						</tr>
					</table>
					<table class="table table-striped">


						<tr>
							<!-- code for table on the left -->


							<c:forEach var="tempReserveFigures"
								items="${THE_RAT.getReserveFigures() }">
								<tr>
									<td class="col-sm-2 nopadding">
											<input type="text" value="${tempReserveFigures.getName() }" name="reserveFiguresDescripton" class="form-control"/></td>
									<td class="col-sm-2 nopadding">
											<input type="number" value="${tempReserveFigures.getAmount() }" step="0.01" name="reserveFiguresAmount" class="form-control"/> </td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</div>
			</div>

			<!-- code for table on the right -->


			<div class="col-sx-6">
				<div class="table-responsive">
					<table>
						<tr>
							<td class="col-sm-6 nopadding">
								<h4>Cat 3 Figures</h4>
							</td>

						</tr>
						<tr>
							<th class="col-sm-2 nopadding">Apportionment</th>
							<td class="col-sm-1 nopadding">SEPT</td>
							<td class="col-sm-1 nopadding">DEC</td>
							<td class="col-sm-1 nopadding">FEB</td>
							<td class="col-sm-1 nopadding">JUNE</td>
							<td class="col-sm-1 nopadding">DEC</td>
							<td class="col-sm-2">
						</tr>
						<tr>
							<th class="col-sm-2 nopadding"></th>
							<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getCat3Apportionment(0) }" name="cat3apportionment" class="form-control"/></td>
							<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getCat3Apportionment(1) }" name="cat3apportionment" class="form-control"/></td>
							<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getCat3Apportionment(2) }" name="cat3apportionment" class="form-control"/></td>
							<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getCat3Apportionment(3) }" name="cat3apportionment" class="form-control"/></td>
							<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getCat3Apportionment(4) }" name="cat3apportionment" class="form-control"/></td>
							<td class="col-sm-2">
						</tr>

					</table>
					<table class="table table-striped">
						<c:forEach var="tempCat3ReserveFigures"
							items="${THE_RAT.getCat3ReserveFigures() }">
							<tr>
								<td><input type="text" value="${tempCat3ReserveFigures.getName() }" name="cat3Note" class="form-control"/></td>
								<td><input type="number" value="${tempCat3ReserveFigures.getAmount() }" step="0.01" name="cat3Amount" class="form-control"/></td>
							</tr>
						</c:forEach>
					</table>

					<div class="row">
						<table class="table-responsive">

							<tr>
								<td class="col-sm-6 nopadding">
									<h4>Retaining Wall Figures</h4>
								</td>
							</tr>
							<tr>
								<th class="col-sm-2 nopadding">Apportionment</th>
								<td class="col-sm-1 nopadding">SEPT</td>
								<td class="col-sm-1 nopadding">DEC</td>
								<td class="col-sm-1 nopadding">FEB</td>
								<td class="col-sm-1 nopadding">JUNE</td>
								<td class="col-sm-1 nopadding">DEC</td>
								<td class="col-sm-2">
							</tr>
							<tr>

								<th class="col-sm-2 nopadding"></th>
								<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getRetainingWallApportionment(0) }" name="retainingWallApportionment" class="form-control"/></td>
								<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getRetainingWallApportionment(1) }" name="retainingWallApportionment" class="form-control"/></td>
								<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getRetainingWallApportionment(2) }" name="retainingWallApportionment" class="form-control"/></td>
								<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getRetainingWallApportionment(3) }" name="retainingWallApportionment" class="form-control"/></td>
								<td class="col-sm-1 nopadding"><input type="number" value="${THE_RAT.getRetainingWallApportionment(4) }" name="retainingWallApportionment" class="form-control"/></td>
								<td class="col-sm-2">
							</tr>

							<c:forEach var="tempRetainingWallFigure"
								items="${THE_RAT.getRetainingWallFigures() }">
								<tr>
									<td><input type="text" value="${tempRetainingWallFigure.getName() }" name="retWallNote" class="form-control"/></td>
									<td><input type="number" value="${tempRetainingWallFigure.getAmount() }" step="0.01" name="retainingwallamount" class="form-control"/></td>
								</tr>
							</c:forEach>




						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<h3 class="text-center">Reserve</h3>
		</div>
		<div class="table-responsive">
			<table class="table text-center">
				<tr>
					<th class="col-sm-1 nopadding text-center">SEPT</th>
					<th class="col-sm-1 nopadding text-center">DEC</th>
					<th class="col-sm-1 nopadding text-center">FEB</th>
					<th class="col-sm-1 nopadding text-center">JUNE</th>
					<th class="col-sm-1 nopadding text-center">DEC</th>
				</tr>
				<tr>
					<c:forEach items="${THE_RAT.getApportionedClaimReserve() }"
						var="tempApportionedReserves">
						<td>${tempApportionedReserves }</td>
					</c:forEach>
				</tr>
			</table>
		</div>



		<div class="row">
			<h3 class="text-center">Payments</h3>
		</div>

		<div class="col-xs-12">
			<div class="table-responsive">
				<table class="table-striped">
					<tr>
						<th class="col-sm-3 nopadding">Reason for Payment</th>
						<th class="col-sm-3 nopadding">Source of Data</th>
						<th class="col-sm-3 nopadding">Event paid under</th>
						<th class="col-sm-3 nopadding">Amount Paid</th>
					</tr>
					<c:forEach var="tempPaymentsList" items="${THE_RAT.getPayments() }">
						<tr>
							<td class="col-sm-3 nopadding">
									<input type="text" class="form-control" id="PaymentName"
										name="Paymentname" value="${tempPaymentsList.getName()}">
							</td>
							<td class="col-sm-3 nopadding">
								<div class="input-group">
									<select class="form-control" id="PaymentType" name="PaymentType">
										<option value="${tempPaymentsList.getSourceOfData()}">${tempPaymentsList.getSourceOfData()}</option>
										<option value="Claim_Payment">Claim Payment</option>
										<option value="Legal_Payment">Legal Fees</option>
										<option value="LOR_Payment">Loss Of Rent</option>
										<option value="Accommodation">Accommodation</option>
									</select>
								</div>
							</td>
							<td class="col-sm-3 nopadding">
									<div class="input-group">
										<select class="form-control" id="PaymentEvent" name="PaymentEvent">
											<option value="${tempPaymentsList.getEvent()}">${tempPaymentsList.getEvent()}</option>
											<option value="SEPT2010">SEPT2010</option>
											<option value="DEC2010">DEC2010</option>
											<option value="FEB2011">FEB2011</option>
											<option value="JUNE2011">JUNE2011</option>
											<option value="DEC2011">DEC2011</option>
										</select>
									</div>
							</td>
							<td class="col-sm-3 nopadding">
								<input type="number" step="0.01" class="form-control" id="PaymentAmount"
									name="Paymentamount" value="${tempPaymentsList.getAmount()}" placeholder="Payment Amount">
							</td>
						</tr>

					</c:forEach>


				</table>
			</div>
		</div>



		<p>
			<a href="RatControlServlet">Back to List</a>
		</p>

		<p>
			<c:out value="${THE_RAT.toString() }" />
		</p>

	</form>
</body>
</html>