<!DOCTYPE html>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Customers"%>
<html>
<head>


<link href="../css/metro.css" rel="stylesheet">
<link href="../css/metro-icons.css" rel="stylesheet">
<link href="../css/metro-responsive.css" rel="stylesheet">

<script src="../js/jquery-2.1.3.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>

<script src="../js/metro.js"></script>

<style>
html, body {
	height: 100%;
}

body {
	
}

.page-content {
	padding-top: 3.125rem;
	min-height: 100%;
	height: 100%;
}

.table .input-control.checkbox {
	line-height: 1;
	min-height: 0;
	height: auto;
}

@media screen and (max-width: 800px) {
	#cell-sidebar {
		flex-basis: 52px;
	}
	#cell-content {
		flex-basis: calc(100% - 52px);
	}
}
</style>
	<%
		Customers user = (Customers) session.getAttribute("user");
		int userID = user.getId();
	%>
<script>
	function pushMessage(t) {
		var mes = 'Info|Implement independently';
		$.Notify({
			caption : mes.split("|")[0],
			content : mes.split("|")[1],
			type : t
		});
	}

	$(function() {
		$('.sidebar').on('click', 'li', function() {
			if (!$(this).hasClass('active')) {
				$('.sidebar li').removeClass('active');
				$(this).addClass('active');
			}
		})
	})
</script>
<script>

$(document).ready(function() {
	   // put Ajax here.
	 //  alert('onload');
	   
       $.getJSON("/arc-cloud/api/user/json/purl/<%=userID%>",
               function(data) {
                      $('#projecttable2').dataTable({
                   	   "aaData": data,
                   	   destroy: true,
                   	   "columns": [
                   	               { "data": "id" },
                   	               { "data": "custid" },
                   	               { "data": "purlurl" }

                   	           ],
                          		"scrollY":        "320px"
                       		
                      }
                      );
                  
       }); 
       
       
	 });
	 
	 
	function showDialog(id) {
		var dialog = $(id).data('dialog');
		dialog.open();
	}

	function showhglass(id) {
		var dialog = $(id).data('hglass');
		dialog.open();
	}
	
	function showDialogOpenPurlWIn(purlID){
		window.open('../api/archive/'+purlID);
	}
</script>


</head>
<body class="bg-steel">
	    <!--  Include header JSP start-->

	
	<jsp:include page="_00_header.jsp" >
  		<jsp:param name="active" value="inbox" />
	</jsp:include>


<!-- Inclde header JSP complete -->

	<div class="page-content">
		<div class="flex-grid no-responsive-future" style="height: 100%;">
			<div class="row" style="height: 100%">
				<!--  Include menu JSP start-->


				<jsp:include page="_00_menu.jsp">
					<jsp:param name="active" value="purl" />
				</jsp:include>


				<!-- Inclde menu JSP complete -->


				<div class="cell auto-size padding20 bg-white" id="cell-content">
				<h1 class="text-light">PURL Management</h1>
          		<div class="input-control text  full-size" >

            </div>

							<div data-role="scrollbox" data-scroll="vertical" class="bg-white">
							<table id="projecttable2" class="display"  width="100%">
								<thead>
						            <tr>
						                <th>Sl No</th>
						                <th>Cust ID</th>
						                <th>Purl ID</th>

						            </tr>
						        </thead>

       
   
							</table>
						</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Stop all vm complete-->
	<!-- hour glass div-->
	<!--<div data-role="preloader" data-type="metro" data-style="dark" id="hglass"></div>-->
	<!--hour glass complete-->
</body>
</html>