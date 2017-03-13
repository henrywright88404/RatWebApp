<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page import ="java.util.*, com.rat.app.*" %>

<html>
<head>
	<title>Reserve Apportionment Template</title>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>


<body>
<div id = "wrapper">
	<div id="header">
		<h2>Reserve Apportionment Template View</h2>
	</div>
</div>

<div id="container">
	<div id = "content">

<table>
	<tr>
		<th>
	  	Claim Numbers
	  	</th>
	</tr>
</table>

<table>
	<tr>
		<td> SEPT</td>
		<td> DEC </td>
		<td> FEB</td>
		<td> JUNE</td>
		<td> DEC</td>
	</tr>
	<tr>
		<td>${RAT.getClaimNumber(0) }</td>
		<td>${RAT.getClaimNumber(1) }</td>
		<td>${RAT.getClaimNumber(2) }</td>
		<td>${RAT.getClaimNumber(3) }</td>
		<td>${RAT.getClaimNumber(4) }</td>
	</tr>


</table>

<br><br>

<!-- code for the tables to show the Base Eng,Geo etc on the left and the Cat 3 / retaining wall on the right -->
<table><tr><td>
	<!-- code for table on the left -->
	
		<table>
			<c:forEach var="tempReserveFigures" items="${RAT.getReserveFigures() }">
				<tr>
					<td><c:out value ="${tempReserveFigures.getName() }"/></td>
					<td><c:out value ="${tempReserveFigures.getAmount() }"/></td>
				</tr>
			</c:forEach>
		</table>
	
	
	
	</td><td>
	<!-- code for table on the right -->
		<table>
			<c:forEach var="tempCat3ReserveFigures" items="${RAT.getCat3ReserveFigures() }">
				<tr>
					<td><c:out value ="${tempCat3ReserveFigures.getName() }"/></td>
					<td><c:out value ="${tempCat3ReserveFigures.getAmount() }"/></td>
				</tr>
			</c:forEach>
			
			<c:forEach var="tempRetainingWallFigure" items="${RAT.getRetainingWallFigures() }">
				<tr>
					<td><c:out value ="${tempRetainingWallFigure.getName() }"/></td>
					<td><c:out value ="${tempRetainingWallFigure.getAmount() }"/></td>
				</tr>
			</c:forEach>
		</table>
	
	</td></tr>
</table>

</div></div>
</body>
</html>