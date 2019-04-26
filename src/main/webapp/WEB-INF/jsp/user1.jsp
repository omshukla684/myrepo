<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style type="text/css">
#firstName-error{
   color:red;
}
#lastName-error{
   color:red;
}
#email-error{
   color:red;
}
#password-error{
   color:red;
}
#confirmPassword-error{
   color:red;
}
#address-error{
   color:red;
}
#salary-error{
   color:red;
}

</style>

 
<script>
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

</script>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <title>
    Signup
  </title>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <!-- Nucleo Icons -->
  <link href="/assets/css/nucleo-icons.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link href="/assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/assets/demo/demo.css" rel="stylesheet" />
  
 <!--formden.js communicates with FormDen server to validate fields and submit via AJAX -->
<script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>

<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}</style>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="js/jquery.passwordstrength.js"></script>
</head>

<body class="">
  <div class="wrapper">
    <div class="sidebar">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
    -->
      <div class="sidebar-wrapper">
        <div class="logo">
         
          <a href="dashboard" class="simple-text logo-normal">
            Mobiloitte
          </a>
        </div>
      
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle d-inline">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="javascript:void(0)">Signup</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse" id="navigation">
            <ul class="navbar-nav ml-auto">
              <li class="search-bar input-group">
                <button class="btn btn-link" id="search-button" data-toggle="modal" data-target="#searchModal"><i class="tim-icons icon-zoom-split"></i>
                  <span class="d-lg-none d-md-block">Search</span>
                </button>
              </li>
              <li class="dropdown nav-item">
                <a href="javascript:void(0)" class="dropdown-toggle nav-link" data-toggle="dropdown">
                  <div class="notification d-none d-lg-block d-xl-block"></div>
                  <i class="tim-icons icon-sound-wave"></i>
                  <p class="d-lg-none">
                    Notifications
                  </p>
                </a>
                <ul class="dropdown-menu dropdown-menu-right dropdown-navbar">
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Mike John responded to your email</a>
                  </li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">You have 5 more tasks</a>
                  </li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Your friend Michael is in town</a>
                  </li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Another notification</a>
                  </li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Another one</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown nav-item">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                  <div class="photo">
                    <img src="../assets/img/anime3.png" alt="Profile Photo">
                  </div>
                  <b class="caret d-none d-lg-block d-xl-block"></b>
                  <p class="d-lg-none">
                    Log out
                  </p>
                </a>
             
              </li>
              <li class="separator d-lg-none"></li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="modal modal-search fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <i class="tim-icons icon-simple-remove"></i>
              </button>
            </div>
          </div>
        </div>
      </div>
      <!-- End Navbar -->
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h5 class="title">Signup</h5>
              </div>
              <div class="card-body">
                <form action="savedata" method="post" id="sign-up" enctype="multipart/form-data">
                  <div class="row">
                   
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
                        <label>Role</label>
                        <select  name="role"class="form-control " placeholder="Username" >
                         <option >Admin</option>
                         <option >User</option>
                        
                        
                        
                        </select>
                      </div>
                    </div>
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address<span class="asteriskField">
														* </span></label>
                        <input type="email" id="email"name="email" class="form-control" placeholder="mike@email.com" >
                        <div style="color:red;" id="result"></div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
                        <label>First Name<span class="asteriskField">
														* </span></label>
                        <input type="text" name="firstName" class="form-control" placeholder="First Name" >
                      </div>
                    </div>
                    <div class="col-md-6 pl-md-1">
                      <div class="form-group">
                        <label>Last Name<span class="asteriskField">
														* </span></label>
                        <input type="text" name="lastName" class="form-control" placeholder="Last Name" >
                      </div>
                    </div>
                  </div>
                   <div class="row">
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
                        <label>Password<span class="asteriskField">
														* </span></label>
                        <input type="password" name="password" id="password" class="form-control" placeholder="Password" >
                      </div>
                    </div>
                    <div class="col-md-6 pl-md-1">
                      <div class="form-group">
                        <label>Confirm Password<span class="asteriskField">
														* </span></label>
                        <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm Password" >
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
                        <label>Address<span class="asteriskField">
														* </span></label>
                        <input type="text" name="address" id="address" class="form-control" placeholder="Address" >
                      </div>
                    </div>
                    <div class="col-md-6 pr-md-1">
                      <div class="form-group">
												<label for="date"> Date Of Birth<span class="asteriskField">
														* </span></label>
														       <div class="input-group">
       
												<div class="input-group-addon">
													<i class="fa fa-calendar"> </i>
												</div>
												<input class="form-control" id="date" name="dob" placeholder="MM/DD/YYYY" type="text"/>
											</div>
                    </div>
                  </div>
</div>
                  <div class="row">
                  <div class="col-md-6">
                  <div class="container-fluid">
                  
                    	<div class="form-group">
											<label >Gender<span class="asteriskField">
														* </span></label> <label class="d-block pdlft20"
												for="radio1"> <input type="radio"
												class="form-check-input" id="radio1" name="gender"
												value="Male" checked>Male
											</label> <label class=" -block pdlft20" for="radio1"> <input
												type="radio" class="form-check-input" id="radio1"
												name="gender" value="Female">Female
											</label> <label class="d-block pdlft20" for="radio1"> <input
												type="radio" class="form-check-input" id="radio1"
												name="gender" value="Others">Others
											</label>
										</div></div></div></div>


                   <div class="row">
                    <div class="col-md-12 ">
                      <div class="form-group">
                        <label>Salary<span class="asteriskField">
														* </span></label>
                        <input type="text" class="form-control" placeholder="salary" name="salary" >
                      </div>
                    </div></div>
                    <div class="row">
                   <div class="col-md-3">
                   
                   
                   <img id="blah" src="#" alt="your image" width="50" height="40px"/>
                    </div></div>
                   <div class="row">
                   <div class="col-md-3">
                   
                   <label>Upload Profile<span class="asteriskField">
														* </span></label>
                       <input name="multipartimage" onchange="readURL(this);" class="btn btn-fill btn-primary" id="img-upload-input"
													 accept="image/*" type="file"  >
                   
                   
                   
                   
                   
                   </div>
                   
                   
                   
                   </div>
                    <div class="card-footer">
                        <button type="submit" id="btnSubmit" class="btn btn-fill btn-primary">Save</button>
                                                <a href="login" class="btn btn-fill btn-primary">Log In</a>
                        
                      </div>
                    
                    
                 
                </form>
                 <h4>${error}</h4> 
              </div>
             
            </div>
          </div>
         <!-- <div class="col-md-4">
            <div class="card card-user">
              <div class="card-body">
                <p class="card-text">
                  <div class="author">
                    <div class="block block-one"></div>
                    <div class="block block-two"></div>
                    <div class="block block-three"></div>
                    <div class="block block-four"></div>
                    <a href="javascript:void(0)">
                      <img class="avatar" src="../assets/img/emilyz.jpg" alt="...">
                      <h5 class="title">Mike Andrew</h5>
                    </a>
                    <p class="description">
                      Ceo/Co-Founder
                    </p>
                  </div>
                </p>
                <div class="card-description">
                  Do not be scared of the truth because we need to restart the human foundation in truth And I love you like Kanye loves Kanye I love Rick Owensâ bed design but the back is...
                </div>
              </div>
              <div class="card-footer">
                <div class="button-container">
                  <button href="javascript:void(0)" class="btn btn-icon btn-round btn-facebook">
                    <i class="fab fa-facebook"></i>
                  </button>
                  <button href="javascript:void(0)" class="btn btn-icon btn-round btn-twitter">
                    <i class="fab fa-twitter"></i>
                  </button>
                  <button href="javascript:void(0)" class="btn btn-icon btn-round btn-google">
                    <i class="fab fa-google-plus"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>-->
        </div>
      </div>
    
    </div>
  </div>
  <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
      <a href="#" data-toggle="dropdown">
        <i class="fa fa-cog fa-2x"> </i>
      </a>
      <ul class="dropdown-menu">
        <li class="header-title"> Sidebar Background</li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger background-color">
            <div class="badge-colors text-center">
              <span class="badge filter badge-primary active" data-color="primary"></span>
              <span class="badge filter badge-info" data-color="blue"></span>
              <span class="badge filter badge-success" data-color="green"></span>
            </div>
            <div class="clearfix"></div>
          </a>
        </li>
        <li class="adjustments-line text-center color-change">
          <span class="color-label">LIGHT MODE</span>
          <span class="badge light-badge mr-2"></span>
          <span class="badge dark-badge ml-2"></span>
          <span class="color-label">DARK MODE</span>
        </li>
      
       
      </ul>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="/assets/js/core/jquery.min.js"></script>
  <script src="/assets/js/core/popper.min.js"></script>
  <script src="/assets/js/core/bootstrap.min.js"></script>
  <script src="/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <!-- Place this tag in your head or just before your close body tag. -->
 
  <!-- Chart JS -->
  <script src="/assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/assets/js/black-dashboard.min.js?v=1.0.0"></script>
  <!-- Black Dashboard DEMO methods, don't include it in your project! -->
  <script src="/assets/demo/demo.js"></script>
  
  <script>
    $(document).ready(function() {
    	
    	
    	  $('#email').change(function (event) {
   	       var email=$('#email').val();
// 			alert(email);
   	       $.ajax({
   	    	url :"checkemail?email="+email,
   			type : "GET",
   			contentType : 'application/json;charset=utf-8',
   			dataType : 'json',
   			async : false,
   	    	success : function(response) {
//    				alert(response);
   				if(response==200){
   		          $('#result').html("Email Allready Exist");
   		       $("#btnSubmit").attr("disabled", true);
   				}else{
   				 $('#result').html("");
   				 $("#btnSubmit").attr("disabled", false);
   				}
   			},
   			error : function(e) {
//    				alert(e)
   				  $('result').html(e);
   				console.log('error:' + JSON.stringify(e));
   			}
   	    	  
   	       });

   	    });
      $().ready(function() {
        $sidebar = $('.sidebar');
        $navbar = $('.navbar');
        $main_panel = $('.main-panel');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');
        sidebar_mini_active = true;
        white_color = false;

        window_width = $(window).width();

        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

      

        $('.fixed-plugin a').click(function(event) {
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .background-color span').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data', new_color);
          }

          if ($main_panel.length != 0) {
            $main_panel.attr('data', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data', new_color);
          }
        });
        function fire_ajax_submit() {

    	    var search = {}
    	    search["email"] = $("#email").val();

    	    $("#btn-search").prop("disabled", true);

    	    $.ajax({
    	        type: "get",
    	        contentType: "application/json",
    	        url: "/checkemail/checkemail",
    	        data: JSON.stringify(search),
    	        dataType: 'json',
    	        cache: false,
    	        timeout: 600000,
    	        success: function (data) {

    	            var json = "<h4>Ajax Response</h4><pre>"
    	                + JSON.stringify(data, null, 4) + "</pre>";
    	            $('#feedback').html(json);

    	            console.log("SUCCESS : ", data);
    	            $("#btn-search").prop("disabled", false);

    	        },
    	        error: function (e) {

    	            var json = "<h4>Ajax Response</h4><pre>"
    	                + e.responseText + "</pre>";
    	            $('#feedback').html(json);

    	            console.log("error", "Email is available to use");
    	            $("#btn-search").prop("disabled", false);

    	        }
    	    });

    	}

        $('.switch-sidebar-mini input').on("switchChange.bootstrapSwitch", function() {
          var $btn = $(this);

          if (sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            sidebar_mini_active = false;
            blackDashboard.showSidebarMessage('Sidebar mini deactivated...');
          } else {
            $('body').addClass('sidebar-mini');
            sidebar_mini_active = true;
            blackDashboard.showSidebarMessage('Sidebar mini activated...');
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);
        });

        $('.switch-change-color input').on("switchChange.bootstrapSwitch", function() {
          var $btn = $(this);

          if (white_color == true) {

            $('body').addClass('change-background');
            setTimeout(function() {
              $('body').removeClass('change-background');
              $('body').removeClass('white-content');
            }, 900);
            white_color = false;
          } else {

            $('body').addClass('change-background');
            setTimeout(function() {
              $('body').removeClass('change-background');
              $('body').addClass('white-content');
            }, 900);

            white_color = true;
          }


        });

        $('.light-badge').click(function() {
          $('body').addClass('white-content');
        });

        $('.dark-badge').click(function() {
          $('body').removeClass('white-content');
        });
      });
    });
    
  </script>
  
  <script>
  

	
  
  
  
  </script>
  <script>

       function activateautoplaces(){
                  
                 var input=document.getElementById('address');
                 var autocomplete=new google.maps.places.Autocomplete(input);

           }



  </script>
 
  	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/sign-up.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAy66DX6smB2kLoaYWscpxxcgEduOvfoBA&libraries=places&callback=activateautoplaces"></script>	
<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	<script
		src="http://52.221.54.107/PROJECTS/Elevate/public/js/validation.js"></script>
<script>
	$(document).ready(function(){
		var dt = new Date();
		dt.setFullYear(new Date().getFullYear()-18);
				
		var date_input=$('input[name="dob"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'mm/dd/yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
	       
			endDate:dt
		});
	});
</script>

</body>

</html>