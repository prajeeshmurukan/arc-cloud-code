<%@page import="com.arc.cloud.dao.hib2.hib.codegen.Customers"%>
<div class="app-bar fixed-top darcula" data-role="appbar">
        
        <span class="app-bar-divider"></span>
        <ul class="app-bar-menu">
            <li>
                <a href="" class="dropdown-toggle">Audit</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="_02_admin-sidebar-viewaudit.jsp">View Audit</a></li>
                   
                </ul>
            </li>
             <li>
                <a href="" class="dropdown-toggle">Billing</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="_02_admin-sidebar-viewbilling.jsp">Total cost</a></li>
                </ul>
            </li>
            <li>

            <li>
                <a href="" class="dropdown-toggle">Help</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="javascript:showDialog('#arccloudabt');">About</a></li>
                </ul>
            </li>
        </ul>
    	
<script>

$(document).ready(function() {
	function showDialog(id) {
		var dialog = $(id).data('dialog');
		dialog.open();
	}
});
</script>
        
	<%
		Customers user = (Customers) session.getAttribute("user");
		int userID = user.getId();
	%>

        <div class="app-bar-element place-right">
            <span class="dropdown-toggle"><span class="mif-cog"></span><%=user.getFirstname() + " "+ user.getLastname() %></span>
            <div class="app-bar-drop-container padding10 place-right no-margin-top block-shadow fg-dark" data-role="dropdown" data-no-close="true" style="width: 220px">
               
                <ul class="unstyled-list fg-dark">
                    <li><a href="" class="fg-white1 fg-hover-yellow">Profile</a></li>

                    <li><a href="../login.arc" class="fg-white3 fg-hover-yellow">Log Out</a></li>
                </ul>
            </div>
        </div>
    </div>
    
            <div data-role="dialog" id="arccloudabt" class="padding20" data-close-button="true"  data-windows-style="true"> 
            <h1>Arc cloud</h1>
            <p align="center">
                Arc cloud beta . 2015 
            </p>
        </div>