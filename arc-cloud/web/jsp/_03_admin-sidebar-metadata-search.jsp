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
	function showDialog(id) {
		var dialog = $(id).data('dialog');
		dialog.open();
	}

	function showhglass(id) {
		var dialog = $(id).data('hglass');
		dialog.open();
	}
	
	function showDialogOpenDoc(id,param) {
		
		var dialog = $(id).data('dialog');
		//alert('param ' + param);
		document.getElementById("docidhidden").value = param
		document.getElementById("text").innerHTML=param;
		
	
		dialog.open();

	}
</script>

    
</script>
	<script type="text/javascript" class="init">
	function cleariFrame() {
		$("#frame").attr("src", "");
		
	}
	
$(document).ready(function() {
	$('#metadatatable').DataTable( {
		"scrollY":        "270px",
		"scrollCollapse": true,
		"paging":         false
	} );
	
	$("#streamarchive").click(function () { 
		//alert($('#text').val());
		var docid = document.getElementById("docidhidden").value;
	      $("#frame").attr("src", "/arc-cloud/api/archive/"+docid);
	});
	   
	
	$("#myprl").click(function () { 
		
		var docid = document.getElementById("docidhidden").value;
		var url = "/arc-cloud/api/user/purl/"+<%=userID%>+"/" + docid;
		
		$.ajax({
		    url: url,
		    method: 'POST',

		    success: function (data) {
		    	//alert(data);
		        console.log(data);
		    },
		    error: function (errm) {
		        // Uh oh, something went wrong
		       //alert(errm.responseText);
				var dialog = $("#archiveaddconf").data('dialog');
				dialog.open();
				
		    }
		});
	

                

	     
	});
	
	
    $('#plink').click(function(){ 
    	var metadata = $("#txtmetadataname").val();
    	
    	if(metadata == null || metadata.trim().length==0 ){
    		$("#txtmetadataname").css('background-color','#FC0');
    	}else{
            $.getJSON("/arc-cloud/api/archive/json/metadata/"+metadata,
                    function(data) {
                           $('#metadatatable').dataTable({
                        	   "aaData": data,
                        	   destroy: true,
                        	   "columns": [
                        	               { "data": "id" },
                        	               { "data": "docid" },
                        	               { "data": "docname" },
                        	               { "data": "doccreatedt" },
                        	               { "data": "custid" },
                        	               { "data": "txProject" },
                        	               { "data": "txSubDiv1" },
                        	               { "data": "txSubDiv2" }
                        	           ],
                               		"scrollY":        "320px"
                            		
                           }
                           );
                       
            });    		
    	}
    	
 
    });
	
} );

</script>
	
</head>
<body class="bg-steel">
	    <!--  Include header JSP start-->

	
	<jsp:include page="_00_header.jsp" >
  		<jsp:param name="active" value="metadata" />
	</jsp:include>


<!-- Inclde header JSP complete -->

	<div class="page-content">
		<div class="flex-grid no-responsive-future" style="height: 100%;">
			<div class="row" style="height: 100%">
				<!--  Include menu JSP start-->


				<jsp:include page="_00_menu.jsp">
					<jsp:param name="active" value="metadata" />
				</jsp:include>


				<!-- Inclde menu JSP complete -->

				<div class="cell auto-size padding20 bg-white" id="cell-content">
					<h1 class="text-light">Metadata Search ..</h1>
         	  <div class="input-control text  full-size" >
                <input type="text"  placeholder="Please enter search string" required maxlength="150" id="txtmetadataname"/>
				<button class="button"><span class="mif-search mif-2x fg-blue" id="plink"></span></button>

            </div>
		  				<div data-role="scrollbox" data-scroll="vertical" class="bg-white">
							<table id="metadatatable" class="display"  width="100%">
								<thead>
						            <tr>
						                <th>Sl No</th>
						                <th>Document ID(Click to open)</th>
						                <th>Document Name</th>
						                <th>Document Created Date</th>
						                <th>Document Created by (User ID)</th>
						                <th>Project Name</th>
						                <th>Tax. Level 1</th>
						                <th>Tax. Level 2</th>
						            </tr>
						        </thead>

       
   
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

	<!-- hour glass div-->
	<!--<div data-role="preloader" data-type="metro" data-style="dark" id="hglass"></div>-->
	<!--hour glass complete-->
</body>
</html>