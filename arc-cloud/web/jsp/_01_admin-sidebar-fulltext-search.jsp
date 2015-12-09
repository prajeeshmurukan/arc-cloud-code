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

        @media screen and (max-width: 800px){
            #cell-sidebar {
                flex-basis: 52px;
            }
            #cell-content {
                flex-basis: calc(100% - 52px);
            }
        }
    </style>

    <script>
        function pushMessage(t){
            var mes = 'Info|Implement independently';
            $.Notify({
                caption: mes.split("|")[0],
                content: mes.split("|")[1],
                type: t
            });
        }

        $(function(){
            $('.sidebar').on('click', 'li', function(){
                if (!$(this).hasClass('active')) {
                    $('.sidebar li').removeClass('active');
                    $(this).addClass('active');
                }
            })
        })
		
    </script>
	<script>
    function showDialog(id){
        var dialog = $(id).data('dialog');
        dialog.open();
    }
	
	    function showhglass(id){
        var dialog = $(id).data('hglass');
        dialog.open();
    }
	
	
</script>
    
	<script type="text/javascript" class="init">

$(document).ready(function() {
	$('#fulltexttable').DataTable( {
		"scrollY":        "270px",
		"scrollCollapse": true,
		"paging":         false
	} );
} );

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

	
	<jsp:include page="_00_menu.jsp" >
  		<jsp:param name="active" value="fulltext" />
	</jsp:include>


<!-- Inclde menu JSP complete -->
 
                <div class="cell auto-size padding20 bg-white" id="cell-content">
               <h1 class="text-light">Inline Content Search..</h1>
           <div class="input-control text  full-size" >
                <input type="text"  placeholder="Please enter search string" required maxlength="150"/>
				<button class="button"><span class="mif-search mif-2x fg-red"></span></button>

            </div>

                
  							<table id="fulltexttable" class="striped hovered  cell-hovered"  width="90%">
								
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
											class="input-control checkbox small-check no-margin">
												<input type="checkbox"> <span class="check"></span>
										</label></td>
										<td>123890723212</td>
										<td>Machine number <%=i%></td>
										<td><a href="http://virtuals.com/machines/123890723212">link</a></td>
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
	<div data-role="dialog" id="dialog" data-overlay ="true" class="padding20" data-close-button="true" data-type="info"  data-background ="bg-darkTeal" data-height="550px" data-width="1000px">
            <h3>Automated Provisioning of IT Software Development Instrastructure using AWS</h3>
           <form>

            <hr class="thin"/>
            <br />
               
            <div class="input-control select error">
            <label for="ami_type">AMI Type</label>
            <select name="ami_type">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            </div>
            
            <div class="input-control select error">
            <label for="ins_type">Instance Type</label>
            <select name="ins_type">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            </div>
            
            <div class="input-control select error ">
            <label for="network_type">Network</label>
            <select name="network_type">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            </div>
               
            <div class="input-control select error">
            <label for="storage_type">Storage</label>
            <select name="storage_type">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            </div>
               
            <br /><br />  <br /> 
            
            <div class="input-control text error" >
                <input type="text" placeholder="Additional Tag Key" required maxlength="15"/>
            </div>
            <div class="input-control text error" >
                <input type="text" placeholder="Additional Tag value" required maxlength="15">
            </div>
               
            <br />
            <br />

               
            <div class="example" data-text=" User Data">
                <div class="input-control textarea full-size">
                    <textarea></textarea>
                </div>
            </div>     
               
            <br />
            <br />
			 <hr class="thin"/>
            <div class="form-actions" >
                <button type="submit" class="button primary" onclick="runPB1();">Launch VM</button>
                <button type="button" class="button secondary">Cancel</button>
            </div>
<div class="progress small" id="pb1" data-role="progressBar" data-value="0" data-color="bg-blue" data-on-progress="$('#sct-1').html(value+'%')"></div>

                        <script>
                            var interval1;
                            function runPB1(){
                                clearInterval(interval1);
                                var pb = $("#pb1").progressBar();
                                var val = 0;
                                interval1 = setInterval(function(){
                                    val += 1;
                                    pb.progressBar('progress', val);
                                    if (val >= 100) {
                                        val = 0;
                                        clearInterval(interval1);
                                    }
                                }, 100);
                            }

                            function flashPB1(){
                                clearInterval(interval1);
                                var pb = $("#pb1").progressBar();
                                pb.progressBar('progress', 0);
                            }

                            function stopPB1(){
                                clearInterval(interval1);
                            }
                        </script>
                    </div>

        </form>
        </div>
    
	<!-- launhc vm complete-->
    <!-- Start vm -->
    <div data-role="dialog" id="id-start-vm" data-overlay ="true" class="padding20" data-close-button="true" data-type="success" data-close-button="true"   >
            <h3>Are you sure to start the selected services ?</h3>
        
			 <hr class="thin"/>
            <div class="form-actions" >
                <button type="submit" class="button primary" onclick="runPB1();">OK</button>
                <button type="button" class="button secondary">Cancel</button>
            </div>        
    </div>
    <!-- start vm complete-->
    <!-- stop vm -->
    <div data-role="dialog" id="id-start-vm" data-overlay ="true" class="padding20" data-close-button="true" data-type="alert" data-close-button="true" >
            <h3>Are you sure to Stop the selected services ?</h3>
        
			 <hr class="thin"/>
            <div class="form-actions" >
                <button type="submit" class="button primary" onclick="runPB1();">OK</button>
                <button type="button" class="button secondary">Cancel</button>
            </div>        
    </div>
    <!-- stop vm complete-->
    <!-- Restart vm -->
    <div data-role="dialog" id="id-start-vm" data-overlay ="true" class="padding20" data-close-button="true" data-type="info" data-close-button="true" >
            <h3>Are you sure to Stop the selected services ?</h3>
        
			 <hr class="thin"/>
            <div class="form-actions" >
                <button type="submit" class="button primary" onclick="runPB1();">OK</button>
                <button type="button" class="button secondary">Cancel</button>
            </div>        
    </div>
    <!-- Restart vm complete-->
    
    <!-- Stop all vm -->
    <div data-role="dialog" id="id-start-vm" data-overlay ="true" class="padding20" data-close-button="true" data-type="info" data-close-button="true" >
            <h3>Are you sure to Stop the selected services ?</h3>
        
			 <hr class="thin"/>
            <div class="form-actions" >
                <button type="submit" class="button primary" onclick="runPB1();">OK</button>
                <button type="button" class="button secondary">Cancel</button>
            </div>        
    </div>
    <!-- Stop all vm complete-->    
	<!-- hour glass div-->
	<!--<div data-role="preloader" data-type="metro" data-style="dark" id="hglass"></div>-->
	<!--hour glass complete-->
</body>
</html>