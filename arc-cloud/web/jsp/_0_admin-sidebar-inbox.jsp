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

        @media screen and (max-width: 800px){
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

    $(document).ready(function() {
    	   // put Ajax here.
    	 //  alert('onload');
    	   
			
           $.getJSON("/arc-cloud/api/inbox/json/<%=userID%>",
                   function(data) {
                          $('#projecttable2').dataTable({
                       	   "aaData": data,
                       	   destroy: true,
                       	   "columns": [
                       	               { "data": "id" },
                       	               { "data": "title" },
                       	               { "data": "content" },
                       	        	   { "data": "status" },
                       	        	   { "data": "createdt" }

                       	           ],
                              		"scrollY":        "320px"
                           		
                          }
                          );
                      
           }); 
           
           
    	 });
    
    
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
  		<jsp:param name="active" value="inbox" />
	</jsp:include>


<!-- Inclde menu JSP complete -->
                <div class="cell auto-size padding20 bg-white" id="cell-content">
                    <h1 class="text-light">Inbox</h1>
           
                    	<div data-role="scrollbox" data-scroll="vertical" class="bg-white">
							<table id="projecttable2" class="display"  width="100%">
								<thead>
						            <tr>
						                <th>Sl No</th>
						                <th>Title</th>
						                <th>Content</th>
						                <th>Status</th>
						                <th>Create Date</th>

						            </tr>
						        </thead>
							</table>
						</div>
						
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