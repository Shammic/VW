<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MI-Synergy Intranet</title>
<link rel="shortcut icon" href="images/logo2.png">
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="templatemo_site_title_bar">

		<div id="site_title">
			<h1>
				<a href="index.html"> <img src="images/logo.png" alt="Portfolio" />


				</a>
			</h1>
		</div>
		<!-- end of menu -->

	</div>
	<!-- end of templatemo_site_title_bar -->

	<!-- end of templatemo_site_title_bar_wrapper -->


	<!-- end of templatemo_banner_wrapper -->


	<div id="templatemo_follow_me_wrapper">

		<!-- end of templatemo_menu -->

	</div>
	<!-- end of templatemo_menu_wrapper -->

	<div id="templatemo_content">


		<div class="temp2" style="padding-left: 135px;">
			<div class="product_box margin_r_10">
				<a href="https://mail.mi-synergy.com:2096/" title="Mail"><img
					src="images/Mail.png" alt="image" /></a>
			</div>

			<div class="product_box margin_r_10">
				<a href="http://www.mi-synergy.com/support/Login.jsp"
					title="Support System"><img src="images/support.png"
					alt="image" /></a>
			</div>

			<div class="product_box margin_r_10">

				<a
					href="http://blogspot.mi-synergy.com/wp-login.php?qevoiqrg6tngpmoon0kpe"
					title="Knowledge Sharing Blog"><img src="images/blog.png"
					alt="image" /></a>


			</div>

			<div class="product_box">

				<a href="downloadPdf.htm" title="Circular"><img
					src="images/leave.png" alt="image" /></a>

			</div>

			<div class="cleaner"></div>

			<div class="product_box margin_r_10">
				<a href="Comingsoon.html" title="Staff Contacts"><img
					src="images/staffcon.png" alt="image" /></a>
			</div>

			<div class="product_box margin_r_10">
				<a href="Comingsoon.html" title="Medical Claim Report"> <img
					src="images/medicalCleims.png" alt="image" />
				</a>

			</div>

			<div class="product_box margin_r_10">

				<a href="Comingsoon.html" title="Client Contacts"><img
					src="images/clientContacts.png" alt="image" /></a>


			</div>

			<div class="product_box">

				<a href="http://wts.misynergy.com/login.jsp"
					title="Work Tracking System"><img src="images/wrkTrack.png"
					alt="image" /></a>
			</div>


			<sec:authorize access="hasRole('addUser')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> ADD USer
			</sec:authorize>
			<sec:authorize access="hasRole('editUser')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> EDIT USer
			</sec:authorize>
			<sec:authorize access="hasRole('deleteUser')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> DELETE USer
			</sec:authorize>
			<sec:authorize access="hasRole('readUser')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> READ USer
			</sec:authorize>
			<sec:authorize access="hasRole('addRole')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> ADD ROLE
			</sec:authorize>
			<sec:authorize access="hasRole('readRole')">
				<div class="product_box">

					<a href="http://wts.misynergy.com/login.jsp"
						title="Work Tracking System"><img src="images/wrkTrack.png"
						alt="image" /></a>
				</div> READ ROLE
			</sec:authorize>
		</div>

		<div class="cleaner_h20"></div>


		<div class="cleaner"></div>
	</div>
	<!-- end of templatemo_content -->
	<div id="templatemo_content_bottom"></div>

	<div id="templatemo_footer_wrapper">
		<div id="templatemo_footer">
			<div class="cleaner" align="center">© Copyright 2006 - 2012.
				MI-Synergy (pvt) Ltd.All Rights Reserved.</div>
		</div>
		<!-- end of footer -->

		<div class="cleaner"></div>
	</div>
	<!-- end of templatemo_footer_wrapper -->

</body>
</html>