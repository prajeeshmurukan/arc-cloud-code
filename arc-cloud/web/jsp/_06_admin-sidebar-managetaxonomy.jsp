<!DOCTYPE html>
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
	
	function cleariFrame() {
		$("#frame").attr("src", "");
	}

	$(document).ready(function() {
		$('#taxonomytable').DataTable({
			"scrollY" : "270px",
			"scrollCollapse" : true,
			"paging" : false
		});
		
		$("#streamarchive").click(function () { 
		      $("#frame").attr("src", "http://www.manoramaonline.com");
		});
	});
	

	
	
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


				<jsp:include page="_00_menu.jsp">
					<jsp:param name="active" value="taxonomy" />
				</jsp:include>


				<!-- Inclde menu JSP complete -->

				<div class="cell auto-size padding20 bg-white" id="cell-content">
					<h1 class="text-light">Manage Taxonomy</h1>

					<div class="input-control text  full-size">
						<input type="text" placeholder="Please enter search string"
							required maxlength="150" />
						<button class="button">
							<span class="mif-search mif-2x fg-blue"></span>
						</button>

					</div>
					<div class="input-control ">
						<button class="button fg-blue"
							onclick="showDialog('#create-new-tax');">Create a New
							Taxonomy</button>
					</div>
						

					<table id="taxonomytable"
						class="striped hovered  cell-hovered display">

						<thead>
							<tr>
								<td style="width: 20px"></td>
								<td class="sortable-column sort-asc" style="width: 100px">ID</td>
								<td class="sortable-column">Machine name</td>
								<td class="sortable-column">Address</td>
								<td class="sortable-column" style="width: 20px">Status</td>

							</tr>
						</thead>
						<tbody>

							<%
								for (int i = 0; i < 200; i++) {
							%>
							<tr>
								<td><label
									class="input-control checkbox small-check no-margin"> <input
										type="checkbox"> <span class="check"></span>
								</label></td>
								<td>123890723212</td>
								<td>Machine number <%=i%></td>
								<td><a href="#" onclick="showDialog('#openpurl');">Open
										Archive</a></td>
								<td class="align-center"><span class="mif-stop fg-red"></span></td>

							</tr>
							<%
								}
							%>


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- launch vm dialog-->
	<div data-role="dialog" id="create-new-tax" data-overlay="true"
		class="padding20" data-close-button="true" data-type="info"
		data-background="bg-darkTeal" data-height="480px" data-width="1000px">
		<h4>Please select a project ID to create a new taxonomy</h4>

		<form>

			<div class="input-control select modern">
				<select class="input-control modern">
					<option>Project1</option>
					<option>Project2</option>
					<option>Project3</option>
				</select>
			</div>
			<hr class="thin" />
			<br />
			<div class="input-control modern text iconic" data-role="input">
				<input type="text" class="fg-white" data-validate-func="email"
					data-validate-hine="This field can not be empty!"> <span
					class="label fg-white">Enter Taxonomy Level1</span> <span
					class="informer fg-white">Enter Taxonomy Level1</span> <span
					class="placeholder fg-white">Enter Taxonomy Level1</span> <span
					class="icon mif-stack fg-white"></span>
			</div>
			<div class="input-control modern text iconic" data-role="input">
				<input type="text" class="fg-white" data-validate-func="password"
					data-validate-hine="This field can not be empty!"> <span
					class="label fg-white">Enter Taxonomy Level2</span> <span
					class="informer fg-white">Enter Taxonomy Level2</span> <span
					class="placeholder fg-white">Enter Taxonomy Level1</span> <span
					class="icon mif-stack fg-white"></span>
			</div>

			<br /> <br /> <br /> <br />
			<hr class="thin" />
			<div class="form-actions">
				<button type="submit" class="button primary" onclick="runPB1();">Create..</button>
				<button type="button" class="button secondary">Cancel</button>
			</div>
		</form>

	</div>




	<!-- launhc vm complete-->

	<div data-role="dialog" id="openpurl" data-overlay="true"
		class="padding20" data-close-button="true" data-type="info"
		data-background="bg-darkTeal" data-height="630px"  data-width="1350px" data-on-dialog-close="cleariFrame">
	
		<h4>Archive Details</h4>
		<hr class="thin" />
		<form>
			<br />
			<table class="table">
				<tr>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
				</tr>
				<tr>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
					<td>Document name</td>
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

		</form>

	</div>




	<!-- launhc vm complete-->

	<!-- hour glass div-->
	<!--<div data-role="preloader" data-type="metro" data-style="dark" id="hglass"></div>-->
	<!--hour glass complete-->
</body>
</html>