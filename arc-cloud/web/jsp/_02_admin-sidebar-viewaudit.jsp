<!DOCTYPE html>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Inbox"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.arc.cloud.dao.util.UIDBUtil"%>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Customers"%>
<html>
<head>


<link href="../css/metro.css" rel="stylesheet">
<link href="../css/metro-icons.css" rel="stylesheet">
<link href="../css/metro-responsive.css" rel="stylesheet">

<script src="../js/jquery-2.1.3.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>

<script src="../js/metro.js"></script>

<link href="https://cdn.datatables.net/1.10.10/css/dataTables.jqueryui.min.css" rel="stylesheet">

<link href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">


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

<script>
	function showDialog(id) {
		var dialog = $(id).data('dialog');
		dialog.open();
	}

	function showhglass(id) {
		var dialog = $(id).data('hglass');
		dialog.open();
	}
</script>

	<%
		Customers user = (Customers) session.getAttribute("user");
		int userID = user.getId();
		List lst = UIDBUtil.getAllItemsInbox(String.valueOf(userID));
	%>
	
<script>

$(document).ready(function() {
    $('#audittable2').DataTable({
    		"scrollY":        "320px"		
    });
       
       
	 });
	 
	 
	function showDialog(id) {
		var dialog = $(id).data('dialog');
		dialog.open();
	}
	
	function showDialogOpenDoc(id,param) {
		
		var dialog = $(id).data('dialog');
		//alert('param ' + param);
		document.getElementById("docidhidden").value = param
		document.getElementById("text").innerHTML=param;
		 $("#frame").attr("src", "");
	
		dialog.open();

	}

	function showhglass(id) {
		var dialog = $(id).data('hglass');
		dialog.open();
	}
</script>


</head>
<body class="bg-steel">
	<!--  Include header JSP start-->


	<jsp:include page="_00_header.jsp">
		<jsp:param name="active" value="inbox" />
	</jsp:include>


	<!-- Inclde header JSP complete -->

	<div class="page-content">
		<div class="flex-grid no-responsive-future" style="height: 100%;">
			<div class="row" style="height: 100%">
				<!--  Include menu JSP start-->





				<!-- Inclde menu JSP complete -->

				<div class="cell auto-size padding20 bg-white" id="cell-content">
					<h1 class="text-light">Audit Details</h1>
	

							<div data-role="scrollbox" data-scroll="vertical" class="bg-white">
							<table id="audittable2" class="cell-border" cellspacing="0" width="100%" >
								<thead>
						            <tr>
						                <th>Sl No</th>
						                <th>title</th>
						                <th>content</th>
						                <th>status</th>
						                <th>Audit created date</th>

						            </tr>
									<%
										if(lst != null && lst.size() >0){
											Iterator itr = lst.iterator();
											while(itr.hasNext()){
												Inbox ib = (Inbox)itr.next();
												out.print("<tr>");
												out.print("<td>" + ib.getId() +"</td>");
												out.print("<td>" + ib.getTitle() +"</td>");
												out.print("<td>" + ib.getContent() +"</td>");
												out.print("<td>" + ib.getStatus() +"</td>");
												out.print("<td>" + ib.getCreatedt() +"</td>");
												out.print("</tr>");

												
											}
										}
									%>
       
   
							</table>
						</div>
			
				</div>
			</div>
		</div>
	</div>

	<div data-role="dialog" id="openpurl" data-overlay="true"
		class="padding20" data-close-button="true" data-type="info"
		data-background="bg-darkTeal" data-height="670px"  data-width="1350px" data-on-dialog-close="cleariFrame">
	<table class="table" >
	<tr>
		<td>	<h4>Archive Details</h4>  </td>
		<td align="right">	<p id="purladdedsuccess"></p> <button class="button loading-pulse lighten primary" id="myprl">Add this Archive to "My Purl"</button> </td>
	</tr>
	</table>

		<hr class="thin" />

			<table class="table" border="1">
				<tr >
					<td>Document ID</td>

					<td>
					<input type="hidden" id="docidhidden"></input>
					<p id="text"></p>
				</td>


				</tr>
	


			</table>

			<hr class="thin" />
			<!-- With icon (font) -->
			<div class="panel">
				<div class="heading">
			
					 <div class="heading">
					       
					        <span class="title primary"><a href="#" id="streamarchive">Click here to stream </a></span>
					  </div>
				</div>
					<div id="mydiv"><iframe id="frame" src="" width="100%" height="320px"> </iframe></div>

			</div>



	</div>


        <div data-role="dialog" id="archiveaddconf" class="padding20" data-close-button="true"  data-windows-style="true">
            <h1>Archive has been successfully added to the profile !</h1>
            <p>
                Archive has been successfully added to the profile !
            </p>
        </div>

	<!-- launhc vm complete-->

</body>
</html>