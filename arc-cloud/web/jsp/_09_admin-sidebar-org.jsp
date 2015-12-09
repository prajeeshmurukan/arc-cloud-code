<!DOCTYPE html>
<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Organization"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.arc.cloud.dao.util.UIDBUtil"%>
<html>
<head>

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">

<link href="../css/metro.css" rel="stylesheet">
<link href="../css/metro-icons.css" rel="stylesheet">
<link href="../css/metro-responsive.css" rel="stylesheet">
<script src="../js/jquery-2.1.3.min.js"></script>
<script src="../js/metro.js"></script>

<link href="../assets/css/bootstrap-yeti.min.css" rel="stylesheet" id="theme-file">
<link href="../assets/css/prettify.min.css" rel="stylesheet">
<link href="../assets/css/prettify-bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/font-awesome.min.css" rel="stylesheet">
<link href="../assets/css/custom.css" rel="stylesheet">


<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/prettify.min.js"></script>
<script src="../assets/js/tabledit.min.js"></script>
<script src="../assets/js/custom.js"></script>




	
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

<script type="text/javascript">

$(document).ready(function() {
 
 
	$('#example1').Tabledit({
	    url: '../orgserv',
	    editButton: false,

	    columns: {
	        identifier: [0, 'id'],
	        editable: [[1, 'Organization Code'], 
	                   [2, 'Org - Name'], 
	                   [3, 'Org-Address1'],
	                   [4, 'Org-Address2'],
	                   [5, 'Org-State'],
	                   [6, 'Org-Zip'],
	                   [7, 'Org-Country'],
	                   [8, 'Creditcard'],
	                   [9, 'Credit-Exp date'],
	                   [10, 'Credit-cvv'],
	                   [11, 'Contact Firstname'],
	                   [12, 'Contact Lastname'],
	                   [13, 'Contact E-mail'],
	                   [14, 'Contact-Phone']

	        ]
	    },
	    onDraw: function() {
	        console.log('onDraw()');
	    },
	    onSuccess: function(data, textStatus, jqXHR) {
	        console.log('onSuccess(data, textStatus, jqXHR)');
	        console.log(data);
	        console.log(textStatus);
	        console.log(jqXHR);
	    },
	    onFail: function(jqXHR, textStatus, errorThrown) {
	        console.log('onFail(jqXHR, textStatus, errorThrown)');
	        console.log(jqXHR);
	        console.log(textStatus);
	        console.log(errorThrown);
	    },
	    onAlways: function() {
	        console.log('onAlways()');
			window.location.reload(true);
	    	    
	            
	       
	        
	    },
	    onAjax: function(action, serialize) {
	        console.log('onAjax(action, serialize)');
	        console.log(action);
	        console.log(serialize);
	    }
	}
			
	);
} );
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
					<h1 class="text-light">Organization Management</h1> 
	.				<button class="button info block-shadow-info text-shadow" onClick="showDialog('#org-create-form');">Create Organization</button>
<div data-role="scrollbox" data-scroll="vertical" class="bg-white">
<table id="example1" class="table striped hovered cell-hovered border bordered">

        <thead>
            <tr>
                <th>id</th>
                <th>Organization Code</th>
                <th>Org - Name</th>
                <th>Org-Address1</th>
                <th>Org-Address2</th>
                <th>Org-State</th>  
                <th>Org-Zip</th>    
                <th>Org-Country</th>    
                <th>Creditcard</th>    
                <th>Credit-Exp date</th>    
                <th>Credit-cvv</th>    
                <th>Contact Firstname</th>    
                <th>Contact Lastname</th>    
                <th>Contact E-mail</th>    
                <th>Contact-Phone</th>    
                                       
          </tr>
                    </thead>
            <tbody> 
            
            <%
            List lst = UIDBUtil.getAllItemsOrg();
            if(lst!=null && lst.size() > 0){
            	Iterator itr = lst.iterator();
            	while(itr.hasNext()){
            		Organization org = (Organization)itr.next();
            		%>
            		<tr>
           		<td><%=org.getId() %></td>
                <td><%=org.getOrgcode() %></td>
                <td><%=org.getOrgname()%></td>
                <td><%=org.getOrgaddr1() %></td>
                <td><%=org.getOrgaddr2() %></td>
                <td><%=org.getOrgstate() %></td>  
                <td><%=org.getOrgzip() %></td>    
                <td><%=org.getOrgcountry() %></td>    
                <td><%=org.getCreditcardno() %></td>    
                <td><%=org.getCreditcardexpdt() %></td>    
                <td><%=org.getCreditcardcvv() %></td>    
                <td><%=org.getContactfirstname() %></td>    
                <td><%=org.getContactlastname() %></td>    
                <td><%=org.getContactemail() %></td>    
                <td><%=org.getContactphone() %></td>  
       </tr>
            		<% 
            	}
            }
            %>
    
   </tbody>


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
	
	 <!-- Registration Form -->
	<!-- launch vm dialog-->
	
	<div data-role="dialog" id="org-create-form" data-overlay ="true"  class="padding20" data-close-button="true" data-type="info"  data-background ="bg-darkTeal" data-height="480px" data-width="1000px">
            <h4> All fields are mandatory. Please Enter the Organization details</h4>
            	<div class="form-actions" data-role="validator" id="register-form">
                       <form method="POST" action="../orgserv" name="orgFrm" >
                       <input type="hidden" name ="action" value ="create" />
     <div class="input-control modern text iconic" data-role="input">
        <input name="orgcode" type="text" class="fg-white"  data-validate-func="required"  data-validate-hine="This field can not be empty!">
           <span class="input-state-error mif-warning"></span>
            <span class="input-state-success mif-checkmark"></span>
        <span class="label fg-white">Your Org Code(ID)</span>
        <span class="informer fg-white">Your Org ID</span>
        <span class="placeholder fg-white"> Your Org ID </span>
        <span class="icon mif-lock fg-white"></span>
    </div>
       <div class="input-control modern text iconic" data-role="input">
        <input value="Concordia" name="orgname" type="text" class="fg-white"  data-validate-func="required"  data-validate-hine="This field can not be empty!"/>
                <span class="input-state-error mif-warning"></span>
            <span class="input-state-success mif-checkmark"></span>
        <span class="label fg-white">Organization name</span>
        <span class="informer fg-white">Organization name</span>
        <span class="placeholder fg-white"> Organization name </span>
        <span class="icon mif-lock fg-white"></span>
    </div>
           <br>
    <div class="input-control modern text iconic" data-role="input">
        <input value ="100 Rue Quebeec" name="address1" type="text" class="fg-white" data-validate-func="email" data-validate-hine="This field can not be empty!"/>
        <span class="label fg-white">Organization Address1</span>
        <span class="informer fg-white">Organization Address1</span>
        <span class="placeholder fg-white">Organization Address1</span>
        <span class="icon mif-user fg-white"></span>
    </div>
    <div class="input-control modern text iconic" data-role="input">
        <input value="Quebec City" name="address2" type="text" class="fg-white" data-validate-func="password" data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Organization Address2</span>
        <span class="informer fg-white">Organization Address2</span>
        <span class="placeholder fg-white">Organization Address2</span>
        <span class="icon mif-user fg-white"></span>
    </div>
       <div class="input-control modern text iconic" data-role="input">
        <input name="state" value="Quebec" type="text" class="fg-white" data-validate-func="password" data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Organization State</span>
        <span class="informer fg-white">Organization State</span>
        <span class="placeholder fg-white">Organization State</span>
        <span class="icon mif-user fg-white"></span>
    </div>   
    
     <div class="input-control modern text iconic" data-role="input">
        <input name="zip" value = "H3E1E4" type="text" class="fg-white" data-validate-func="password" data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Organization Zip</span>
        <span class="informer fg-white">Organization Zip</span>
        <span class="placeholder fg-white">Organization Zip</span>
        <span class="icon mif-user fg-white"></span>
    </div> 
        <div class="input-control modern text iconic" data-role="input">
        <input name="country"  value ="Canada" type="text" class="fg-white" data-validate-func="password" data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Organization Country</span>
        <span class="informer fg-white">Organization Country</span>
        <span class="placeholder fg-white">Organization Country</span>
        <span class="icon mif-user fg-white"></span>
    </div> 
         
        <br><br>
    <div class="input-control modern text iconic" data-role="input">
        <input name="creditno" value = "1111-1111-1111-1111" type="text" class="fg-white" data-validate-func="required"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white"> Credit card #</span>
        <span class="informer fg-white"> Credit card #</span>
        <span class="placeholder fg-white"> Credit card #</span>
        <span class="icon mif-user fg-white"></span>
    </div>                      
    <div class="input-control modern text iconic" data-role="input">
        <input name="creditdt" type="text" value ="Dec-09-2018" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white"> Credit card Exp Date</span>
        <span class="informer fg-white"> Credit card Exp Date</span>
        <span class="placeholder fg-white"> Credit card Exp Date</span>
        <span class="icon mif-user fg-white"></span>
    </div>
       
    <div class="input-control modern text iconic" data-role="input">
        <input name="creditcvv" type="text" value="xxx" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white"> Credit card CVV</span>
        <span class="informer fg-white"> Credit card CVV</span>
        <span class="placeholder fg-white"> Credit card CVV</span>
        <span class="icon mif-user fg-white"></span>
    </div>                      
    <br> <br>
    <div class="input-control modern text iconic" data-role="input">
        <input name="contactFirstname"  value = "Adam" type="text" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white"> Contact First Name </span>
        <span class="informer fg-white">Contact First Name </span>
        <span class="placeholder fg-white">Contact First Name </span>
        <span class="icon mif-user fg-white"></span>
    </div>        
    <div class="input-control modern text iconic" data-role="input">
        <input name="contactLastname"  value = "Smith" type="text" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Contact last Name </span>
        <span class="informer fg-white">Contact Last Name </span>
        <span class="placeholder fg-white">Contact Last Name </span>
        <span class="icon mif-user fg-white"></span>
    </div>                      
    <div class="input-control modern text iconic" data-role="input">
        <input name="contactEmail" type="text" value="admin@concordia.ca" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white"> Contact Email</span>
        <span class="informer fg-white">Contact Email</span>
        <span class="placeholder fg-white">Contact Email</span>
        <span class="icon mif-user fg-white"></span>
    </div>
        <div class="input-control modern text iconic" data-role="input">
        <input name="contactPhone" type="text" value = "514-111-1111" class="fg-white" data-validate-func="email"  data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Contact phone #</span>
        <span class="informer fg-white">Contact phone #</span>
        <span class="placeholder fg-white">Contact phone #</span>
        <span class="icon mif-user fg-white"></span>
    </div>                      

               <br/>
            <br/>
            <br/>
            <br/>
			 <hr class="thin"/>
          		            <button class="button primary block-shadow-success text-shadow">Create Organization..</button>
                <button type="reset" class="button secondary">Cancel</button>
                 </form>
             </div>

                        
         </div>



    
	<!-- launhc vm complete-->

<!-- Registration form complete-->  


</body>
</html>