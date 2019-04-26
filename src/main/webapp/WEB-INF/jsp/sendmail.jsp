<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta charset="utf-8">


<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<title>Om Shukla</title>
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<!-- Nucleo Icons -->
<link href="../assets/css/nucleo-icons.css" rel="stylesheet" />
<!-- CSS Files -->
<link href="../assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../assets/demo/demo.css" rel="stylesheet" />
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Employee-List</title>
</head><body>
	<main class="main-container bg_gray">
	<section class="inner_section common_section">
		<div class="container">
			<div class="max-WT-600 center-box">
				<div class="global_box">
					<div class="head_box2 head_box2_border">
						<h4>Forget Password</h4>

					</div>
					<div class="row justify-content-center">
						<div class="col-md-12">

							<div class="form-box center-box max-WT-500">
								<h5 style="color: green">${delete}</h5>
								<h3 style="color: green">${success}</h3>
								<h3 style="color: red">${invalid}</h3>
								<form class="common-form" id="signup" method="post" action="sendmail">

									<!-- <div class="form-group">
											   <div class="profile-pic">
											    <img src="images/profile-pic.jpg">
										      </div>
											  </div> -->
									<div class="form-group mb20">
									<h5 style="text-align: center">Please enter your email we will send your password on your email</h5>
										<br> <input type="email" name="email"
											class="form-control" placeholder="Enter your Email"
											maxlength="200" />
									</div>

									<div class="text-center">
										<a href="sendmail"><button type="submit"
												class="btn mt20 btnproperty">Submit</button></a>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
	</main>
	<!-- main End -->
	<footer class="footer-inner">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8">
					<div class="footer-content">
						<div class="footer-text">
							<p class="copyright">Mobiloitte portal © 2019 - All Rights
								Reserved.</p>
						</div>
					</div>
				</div>
			
			</div>
		</div>
	</footer>
	


	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/popper.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/marquee.js"></script>
	<script src="/resources/js/slick.min.js"></script>
	<script src="/resources/js/common.js"></script>
	<script src="/resources/js/validation.js"></script>

</body>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>
</html>