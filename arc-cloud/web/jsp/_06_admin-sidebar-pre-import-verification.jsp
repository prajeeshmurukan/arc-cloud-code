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
					<jsp:param name="active" value="preimportveri" />
				</jsp:include>


				<!-- Inclde menu JSP complete -->
				<div class="cell auto-size padding20 bg-white" id="cell-content">
				<h1 class="text-light">Pre-Import Verification</h1>
				
				<div class="input-control file full-size"  data-role="input" >
				    <input type="file" placeholder="Please browze the csv file input for bulk migration.." >
				    <button class="button"><span class="mif-folder icon"></span></button>
				</div>
					<div class="input-control">
						<button class="button fg-red">Upload and validate </button>
					</div>
					<table class="dataTable border bordered" data-auto-width="false">
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
							<tr>
								<td><label
									class="input-control checkbox small-check no-margin"> <input
										type="checkbox"> <span class="check"></span>
								</label></td>
								<td>123890723212</td>
								<td>Prajee</td>
								<td><a href="http://virtuals.com/machines/123890723212">link</a></td>
								<td class="align-center"><span
									class="mif-checkmark fg-green"></span></td>

							</tr>
							<tr>
								<td><label
									class="input-control checkbox small-check no-margin"> <input
										type="checkbox"> <span class="check"></span>
								</label></td>
								<td>123890723212</td>
								<td>Machine number 2</td>
								<td><a href="http://virtuals.com/machines/123890723212">link</a></td>
								<td class="align-center"><span class="mif-stop fg-red"></span></td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>