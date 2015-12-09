<!DOCTYPE html>
<html>
<head>


    <link rel='shortcut icon' type='image/x-icon'/>

    <title>Arc Cloud</title>

    <link href="../css/metro.css" rel="stylesheet">
    <link href="../css/metro-icons.css" rel="stylesheet">
    <link href="../css/metro-responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="../css/fakeLoader.css">
    <script src="../js/jquery-2.1.3.min.js"></script>
    <script src="../js/metro.js"></script>
	<script src="../js/fakeLoader.min.js"></script>
	
 <script>
    function showDialog(id){
        var dialog = $(id).data('dialog');
        dialog.open();
        

    }
</script>
   
    <style>
        .login-form {
            width: 50rem;
            height: 19.75rem;
            position: fixed;
            top: 50%;
            margin-top: -9.375rem;
            left: 50%;
            margin-left: -12.5rem;
            background-color: #ffffff;
            opacity: 10;
            -webkit-transform: scale(.8);
            transform: scale(.8);
        }
    </style>

    <script>



        $(function(){
            var form = $(".login-form");

            form.css({
                opacity: 1,
                "-webkit-transform": "scale(1)",
                "transform": "scale(1)",
                "-webkit-transition": ".5s",
                "transition": ".5s"
            });
        });
    </script>
    
           


    
</head>
<body class="bg-darkTeal">
<div id="fakeLoader"></div>
<div class="panel">
    <div class="heading">
        <img class="icon" src="../icons/loading_image.gif">
        <span class="title">Arc Cloud - Electronic Content Archival Management System</span>
    </div>

</div>
<div class="cell" >
                        <br><br>
    

        <div class="bg-darkTeal">
            <div class="presenter" data-role="presenter"  data-easing="swing" data-width="450px" data-height="570px">
                <div class="scene">
                    <div class="act bg-pink fg-white">
                        <img src="../logo/Arc1.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
                        <p class="actor" data-position="150,50">Arc - Cloud is a highly scalable content archival management system which allows business users to archive their electronic content in any format .</p>
                        <p class="actor" data-position="350,50">Arc - Cloud provides one of the most reliable and cost-effective method of legacy content archival. It is based on AWS cloud , which is known for scalability, reliability and low cost of ownership</p>
                        
                        <img src="../logo/Arc2.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
<p class="actor" data-position="350,50">Arc - cloud has additional capabilities to match our custom business requirements</p>                        
                        
                        <img src="../logo/Arc3.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
<p class="actor" data-position="350,50">Arc - Cloud provides bulk custom document upload features..</p>                        
                        
                        <img src="../logo/Arc4.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
<p class="actor" data-position="350,50">Arc - Cloud provides extensive monitoring and auditing features</p>                        
                        
                        <img src="../logo/Arc5.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
<p class="actor" data-position="350,50">Arc - Cloud provides creation and management of custom content taxonomy </p>                        
                        
                        <img src="../logo/Arc6.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>
<p class="actor" data-position="350,50">Arc - Cloud provides a custom functionality - PURL - An unique URL for the imported content which can be used to access the content using a RESTful Webservice</p>                           
                        
                        <img src="../logo/Arc7.jpg" class="actor" data-position="0,0" data-width="550px" data-height="570px">
                        <h3 class="actor" data-position="50,50">Content Archival Management System</h3>                        
                     
                    </div>
                </div>
            </div>
        </div>

    <!-- Login Form -->
<div class="form-actions" data-role="validator" id="login-form">
    <div class="login-form padding20 block-shadow bg-darkTeal">
        <form action="start-screen-admin.jsp">
                <h2 class="title fg-white">Arc Cloud - Electronic Content Archival System Login</h2> 
                <hr class="thin"/>
                <br />
    <div class="input-control modern text iconic" data-role="input">
        <input type="text" class="fg-white" data-validate-func="email"  value="prajeesh.ms@gmail.com" data-validate-hine="This field can not be empty!">
        <span class="label fg-white">Your login</span>
        <span class="informer fg-white">Please enter your email</span>
        <span class="placeholder fg-white">Please enter your E-Mail </span>
        <span class="icon mif-user fg-white"></span>
    </div>
    <div class="input-control modern password iconic" data-role="input">
        <input type="password" class="fg-white"  data-validate-func="required" value="Acc"  data-validate-hine="This field can not be empty!"/>
                <span class="input-state-error mif-warning"></span>
            <span class="input-state-success mif-checkmark"></span>
        <span class="label fg-white">Your Password</span>
        <span class="informer fg-white">Please enter your Password</span>
        <span class="placeholder fg-white"> Enter your Password </span>
        <span class="icon mif-lock fg-white"></span>
    </div>


    <div class="margin40">
            <button class="button primary block-shadow-success text-shadow">Login</button>
            <a class="button rounded block-shadow-info text-shadow" onClick="showDialog('#registration-form');">New User ? Register Now..</a>
        </div>
    </form>    
    </div>

</div>
    <!-- Login form complete-->
    
  

<script type="text/javascript">
$("#fakeloader").fakeLoader();
</script>
</body>
</html>