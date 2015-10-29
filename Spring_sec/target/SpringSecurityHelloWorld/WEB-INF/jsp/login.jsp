<!-- saved from url=(0022)http://internet.e-mail -->
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" tabindex="0">
<head>
	
	<!-- start: Meta -->
	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
	<meta charset="utf-8">
	<title>MI_Synergy INET</title>
	<meta name="description" content="ACME Dashboard Bootstrap Admin Template.">
	<meta name="author" content="Łukasz Holeczek">
	<meta name="keyword" content="ACME, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if IE]>
       <meta http-equiv="X-UA-Compatible" content="IE=edge" >
<![endif]-->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/logo_half.ico">
	<!-- end: Favicon -->
	
			<style type="text/css">
			body { background: url(img/bg-login.jpg) !important; }
		</style>
	<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>	
		
		
</head>

<body onload='document.f.j_username.focus();'>
		<div class="container-fluid">
		<div class="row-fluid">
				<div class="login-box">
                <h2>Welcome to M I Synergy INET</h2>                
                
                <c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
		<%-- 	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
			${error}
		</div>
	</c:if>
					<div class="icons">
	                    
						<a href="www.mi-synergy.com" tabindex="_blank"><i class="halflings-icon home"></i></a>
					<!-- 	<a href="#"><i class="halflings-icon cog"></i></a> -->
					</div>
					<form name='f' action="<c:url value='j_spring_security_check'/>" method='POST'>

							
					  <div class="input-prepend" title="Username">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" type='text' name='j_username' placeholder="type username"/>
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10"  type='password' name='j_password'  placeholder="type password"/>
							</div>
							<div class="clearfix"></div>
							
							<!-- <label class="remember" for="remember"><input type="checkbox" id="remember" />Remember me</label>
 -->
							<div class="button-login">	
								<button type="submit" class="btn btn-primary">Login</button>
							</div>
							<div class="clearfix"></div>
					</form>
					<hr>
					<!-- <h3>Forgot Password?</h3>
					<p>
						No problem, <a href="#">click here</a> to get a new password.
					</p>-->	
				</div><!--/span-->
				</div><!--/fluid-row-->
				
	</div><!--/.fluid-container-->

	<!-- start: JavaScript-->

		<script src="js/jquery-1.9.1.min.js"></script>
		<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	
	
	<!-- end: JavaScript-->
	
</body>
</html>
