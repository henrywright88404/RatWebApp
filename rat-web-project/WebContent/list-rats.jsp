<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page import ="java.util.*, com.rat.app.*" %>



<html>
<head>
	<title>Reserve Apportionment Template</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>




<body>


 <h2 class="text-center">Reserve Apportionment Template List</h2>





<div id="container">
	<div id = "content">
	
	<!-- put a new button Add Rat -->

  <a href="add-rat.jsp" class="btn btn-info" role="button">New Rat</a>

		<table class="table table-striped">
			<tr>
				<th>Main claim</th>
				<th>Name</th>
				<th>Total Reserve</th>
				<th>Action</th>
			</tr>
			
			
			<c:forEach var = "tempRat" items="${RAT_LIST }">
			
			<c:url var="viewLink" value="RatControlServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="ratId" value="${tempRat.getId() }"/>
			</c:url>
			
			
			<c:url var="deleteLink" value="RatControlServlet">
				<c:param name="command" value="DELETE"/>
				<c:param name="id" value="${tempRat.getId() }"/>
			</c:url>
				<!-- //TODO implement Edit Rat page -->			
			<c:url var="editLink" value="RatControlServlet">
				<c:param name="command" value="EDIT"/>
				<c:param name="id" value="${tempRat.getId() }"/>
			</c:url>
			
			 	<tr>
			 		<td> ${tempRat.getMainClaim()} </td>
			 		<td> ${tempRat.getCustomerName()}  </td>
			 		<td> ${tempRat.getTotal() }
			 		<td> <a href="${viewLink }">View</a> | <a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this RAT?'))) return false" >Delete</a> </td>
			 	</tr>
			</c:forEach>
			
			
		</table>
	</div>
</div>


</body>




</html>