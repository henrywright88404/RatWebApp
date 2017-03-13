<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page import ="java.util.*, com.rat.app.*" %>



<html>
<head>
	<title>Reserve Apportionment Template</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
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
			
			<c:url var="updateLink" value="RatControlServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="ratMainClaim" value="${tempRat.getMainClaim() }"/>
			</c:url>
			
			<c:url var="deleteLink" value="RatControlServlet">
				<c:param name="command" value="DELETE"/>
				<c:param name="id" value="${tempRat.getId() }"/>
			</c:url>
			
			 	<tr>
			 		<td> ${tempRat.getMainClaim()} </td>
			 		<td> ${tempRat.getCustomerName()}  </td>
			 		<td> ${tempRat.getTotal() }
			 		<td> <a href="${updateLink }">Update</a> | <a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this RAT?'))) return false" >Delete</a> </td>
			 	</tr>
			</c:forEach>
			
			
		</table>
	</div>
</div>


</body>




</html>