<!DOCTYPE html>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Organization"%>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Customers"%>
<%@page import="java.util.Date"%>
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
					<jsp:param name="active" value="contupload" />
				</jsp:include>


				<!-- Inclde menu JSP complete -->
				<div class="cell auto-size padding20 bg-white" id="cell-content">
					<h1 class="text-light">Content Upload..</h1>
					<br> <h2 class="text-light"><%if(request.getParameter("msg") !=null ){
						out.print(request.getParameter("msg"));
					}
					%></h2>
					<div class="example" data-text="Manual Content Upload">
						<div class="wizard" data-role="wizard"
							data-buttons='{"next": "true", "prior": "true" }'
							data-stepper-clickable="true">
						
							<div class="steps">
								<!--  -->
							<div class="step">
							<%
							Date d = new  Date();
							int id = d.hashCode();
							%>			
					<form method="POST" name="docFrm" action = "../api/archive/upload" enctype="multipart/form-data">
										
							<div class="form-actions cell auto-size padding20 bg-blue" data-role="validator" id="register-form">
							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="objID" class="fg-white" value="<%=id %>" data-validate-func="required"   readonly ="true" "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Document ID</span>
							        <span class="informer fg-white">Document ID</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>
 							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="projectName" class="fg-white"  data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Please enter project Name</span>
							        <span class="informer fg-white">Please enter project Name</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>  
							    <br>
 							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="tax1" class="fg-white"  data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Please enter Taxonomy1</span>
							        <span class="informer fg-white">Please enter Taxonomy1</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>   
 							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="tax2" class="fg-white"  data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Please enter Taxonomy2</span>
							        <span class="informer fg-white">Please enter Taxonomy2</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>   							    							     		
								</div>							
			                   </div>
								<!-- Step2 -->
								<div class="step">
								<div class="form-actions cell auto-size padding20 bg-blue" data-role="validator" id="register-form">
							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="documentName" class="fg-white" data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Document Name</span>
							        <span class="informer fg-white">Document Name</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>
 							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="documentTitle" class="fg-white"  data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Please enter Document Title</span>
							        <span class="informer fg-white">Please enter Document Title</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>  
							    <br>
 							    <div class="input-control modern password iconic" data-role="input">
							        <input type="text" name="documentcrDt" value="<%=new Date().toGMTString() %>" class="fg-white"  data-validate-func="required"    "This field can not be empty!"/>
							                <span class="input-state-error mif-warning"></span>
							            <span class="input-state-success mif-checkmark"></span>
							        <span class="label fg-white">Create Date (GMT)</span>
							        <span class="informer fg-white">Create Date (GMT)</span>
							        <span class="placeholder fg-white"></span>
							        <span class="icon mif-lock fg-white"></span>
							    </div>   
 		
								
								</div>
								</div>
								<!--  Step 3 -->
								<div class="step">
								<div class="form-actions cell auto-size padding20 bg-blue" data-role="validator" id="register-form">
									Enter Metadata
									<div class="input-control textarea">
									    <textarea name="documentMetadata" id="metadataTxtId"></textarea>
									</div>		
								Enter Keywords
									<div class="input-control textarea">
									    <textarea name="documentKeyWords">
									    </textarea>
									</div>				
								</div>
								</div>
								<!--  Step 3 complete-->
								<!--  Step4 -->
								<div class="step">
								<p class="modern fg-blue"> Document ID : <script type="text/javascript"> document.write(document.docFrm.docid.value);</script></p><br>
								<p class="modern fg-blue"> Project Name : <script type="text/javascript"> document.write(document.docFrm.projectName.value);</script></p><br>
								<p class="modern fg-blue"> Taxonomy 1 : <script type="text/javascript"> document.write(document.docFrm.tax1.value);</script></p><br>
								<p class="modern fg-blue"> Taxonomy 2 : <script type="text/javascript"> document.write(document.docFrm.tax2.value);</script></p><br>
								<p class="modern fg-blue"> Document Name : <script type="text/javascript"> document.write(document.docFrm.docname.value);</script></p><br>
								<p class="modern fg-blue"> Document Title : <script type="text/javascript"> document.write(document.docFrm.doctitle.value);</script></p><br>
								<p class="modern fg-blue"> Document Crt Dt : <script type="text/javascript"> document.write(document.docFrm.createDt.value);</script></p><br>
								<p class="modern fg-blue"> Document metadata : <script type="text/javascript"> document.write(document.getElementById("metadataTxtId").value);</script></p><br>
								<p class="modern fg-blue"> Document Keywords : <script type="text/javascript"> document.write(document.docFrm.keywords.value);</script></p><br>
								<br><br>
								<p class="modern fg-blue"> Please select the document and upload </p> 
								<div class="input-control file" data-role="input">
								    <input type="file" name="file" id="file" >
								    <button class="button"><span class="mif-folder"></span></button>
								</div>
								 <button type="submit" class="button primary">Upload Content..</button>
								</div>
								<%
								Customers cust = (Customers) session.getAttribute("user");
								Organization org = cust.getOrganization();
								
								%>
							<input type = "hidden" name="userId" value="<%=cust.getId()%>"/>
							<input type = "hidden" name="orgId" value="<%=org.getId()%>"/>
						</div>
					</div>
				</div>
			</div>
</form>
			
</body>
</html>