<!DOCTYPE html>

<html>
<head>
<title>Reserve Apportionment Template</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>


<body onload ="add_reserve_figure_fields();" >
	<form action="RatControlServlet" method="get">
	<input type="hidden" name="command" value="ADD" />
	
<div class="container-fluid">



	
		<h2 class="text-center">Reserve Apportionment Template</h2>
	


	
		<h3 class="text-center">New Rat</h3>
	



	
					<div class="col-lg-2"><h6 class="text-center">Claim Numbers</h6></div>
					<div class="col-lg-2">
						<input type="text" class="form-control"
							name="claimnumbers" value="0" />
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control"
							name="claimnumbers" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control"
							name="claimnumbers" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control"
							name="claimnumbers" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control"
							name="claimnumbers" value="0"  />
					</div><br><br>
	


	
					<div class="col-lg-2"><h6 class="text-center">Claim Apportionment</h6></div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="apportionment" value="0" />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="apportionment" value="0"  />
					</div><br><br>
	

				
				<h4 class="text-center">Reserve Figures</h4>

					<div class="col-lg-12"></div>
					<div id="reserveFigureFields"></div>

				
				<div class="form-group">
				<div class="row">	
					<div class="col-lg-1"><h5 class="text-center">Cat 3 Figures</h5></div>				
						<div class="col-lg-3">
							<input type="text" class="form-control"
								name="cat3Note" placeholder="Enter source of data"  />
						</div>
						
						<div class="col-lg-3" id="figureamount">
							<input type="number" step="0.01" class="form-control" 
								name="cat3Amount" placeholder="Amount"  />
						</div>
					</div>	
				</div>
		
				<div class="row">
				<div class="col-lg-1"><h5 class="text-center">Cat 3 Apportionment</h5></div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="cat3apportionment" value="0" />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="cat3apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="cat3apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="cat3apportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="cat3apportionment" value="0"  />
					</div>
				</div>
	
	
				<div class="form-group">
				<div class="row">
				
					<div class="col-lg-1"><h5 class="text-center">Retaining Wall Figures</h5></div>
				    <div class="col-lg-3">
						<input type="text" class="form-control"
							name="retWallNote" placeholder="Enter source of data"  />
					</div>
					<div class="col-lg-3" id="figureamount">
						<input type="number" step="0.01" class="form-control" 
							name="retainingwallamount" placeholder="Amount"  />
					</div>
				</div>
				</div>
	
					<div class="form-group">
						<div class="col-lg-1"><h5 class="text-center">Retaining wall Apportionment</h5></div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="retainingWallApportionment" value="0" />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="retainingWallApportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="retainingWallApportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="retainingWallApportionment" value="0"  />
					</div>
					<div class="col-lg-2">
						<input type="number" class="form-control"
							name="retainingWallApportionment" value="0"  />
					</div>
				</div>

	

				<div class="row">
					<div class="col-lg-12"><h5 class="text-center">Payments</h5></div>
				</div>
	
				
				<div class="form-group">
				<div id="paymentFigureFields">
					<div class="row">
					<input type="hidden" name="paymentType" value="notselected">
						<div class="col-lg-2">
							<div class="dropdown">
		  						<button onclick="payment_dropdown_title()" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span id="dropdown_title" name="payment_type"> Payment type </span><span class="caret"></span></button>
							 	<ul class="dropdown-menu" id="dropdown-menu">
							  	  	<li><a>Progress payment</a></li>
							    	<li><a>legal fees</a></li>
							    	<li><a>Loss Adjustor fees</a></li>
							  	</ul>
							</div>
						</div>
					
						
						<div class="col-lg-3">
							<input type="text" class="form-control"
								name="paymentNote" placeholder="Enter source of data"  />
						</div>
						
						<div class="col-lg-3" id="figureamount">
							<input type="number" step="0.01" class="form-control" 
								name="paymentAmount" placeholder="Amount"  />
						</div>
					</div>
				</div>
			</div>


				<input type="button" id="more_payment_figure_fields"
					onclick="add_payment_figure_fields();" value="Add more lines" />

				
		<div class="form-group">
			<div class="col-lg-12 col-lg-offset-11">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>

		<div style="clear: both;"></div>
		<p>
			<a href="RatControlServlet">Back to List</a>
		</p>


	
	</div>
</form>

<!--Function to generate the reserve figure fields  -->
	<script type="text/javascript">
	
		function add_reserve_figure_fields() {
			var fields = ['Base Estimate or SI', 'Betterment (deducted) <$30k or 10%', 'Deductions (if incl in Base Est)', 'Variations', 'Demolition', 'TC Foundation Costs', 'Scoping Report Costs', 'Geotech Report Costs', 'Engineering Costs', 'CWI Premium Costs', 'Architectural / Design Costs', 'Other', 'Other', 'Other','LA Fees Costs','Legal Fees'];

			for(i = 0;i< fields.length;i++){
				var objTo = document.getElementById("reserveFigureFields");
				var divtest = document.createElement("div");
				divtest.innerHTML = '<div class="reserveFigureFields"><div class="col-lg-2"> <input type="text" class="form-control" name="reserveFiguresDescripton" value="'+ fields[i] +'" readonly/></div><div class="col-lg-3"><input type="text" class="form-control" name="reserveFiguresNote" placeholder="Enter source of data"  /></div><div class="col-lg-3"><input type="number" step="0.01" class="form-control" name="reserveFiguresAmount" placeholder="Amount" /></div><div class="col-lg-12"></div></div>';
				objTo.appendChild(divtest)
			}
			
		}
	</script>
	
	<script type="text/javascript">
	function payment_dropdown_title(){
		$(".dropdown-menu").on('click', 'li', function(){
			// this dropdown menus row, find the dropdown_title's html content and sets it as the option that was clicked 
	  		$(this).closest('.row').find("#dropdown_title").html($(this).find('a').html());
	  		var type = $(this).closest('.row').find("#paymentType")
	  		
	  		type.value = $(this).find('a').html();
	
		});
	}
	</script>

	
	<script type="text/javascript">
		
		function add_payment_figure_fields() {
			    
				var objTo = document.getElementById("paymentFigureFields");
				var divtest = document.createElement("div");
				divtest.innerHTML = '<div class="row"><div class="col-lg-2"><div class="dropdown"><button onclick="payment_dropdown_title()" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span id="dropdown_title" name="payment_type"> Payment type </span><span class="caret"></span></button><ul class="dropdown-menu" id="dropdown-menu"><li><a>Progress payment</a></li><li><a>legal fees</a></li><li><a>Loss Adjustor fees</a></li></ul></div></div><div class="col-lg-3"><input type="text" class="form-control" name="paymentNote" placeholder="Enter source of data"  /></div><div class="col-lg-3" id="figureamount"><input type="number" step="0.01" class="form-control" name="paymentAmount" placeholder="Amount"  /></div></div><br>';
				objTo.appendChild(divtest)
			
				
		}
	</script>
		

<!-- TODO add validation for input fields relating to money - ensuring a number is passed in and not any illegal characters.  -->

</body>
</html>