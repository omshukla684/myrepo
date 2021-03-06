$.validator.addMethod("regex",function(value,element,regexp){
	var re= new RegExp(regexp);
	return this.optional(element)||re.test(value);
}
		);
$("#sign-up").validate({
	rules : {
		firstName:{
			regex : "^[A-Za-z]+$",
			required:true,
		    minlength:5,
			maxlength:16
		},
		lastName:{
			regex : "^[A-Za-z]+$",
			required:true,
			minlength:5,
			maxlength:16
		},
		email:{
			required:true,
			regex :  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
			
		},
		password:{
			regex : "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
			required:true,
			minlength:8,
			maxlength:16
		},
		confirmPassword:{
			required:true,
			equalTo :"#password"
		},
		
		salary:{
		     required : true,
		     regex : /^\d{1,6}(?:\.\d{0,2})?$/,
			 number : true
			
		},
		
		address:{
			required:true,
		}
	},
  messages:{
	  firstName:{
		  regex : "Please Enter a valid First Name. ",
			required : "Please provide your name.",
			minlength : "First Name should be atleast 5 characters long.",
			maxlength : "First Name should not be too long."
		},
		lastName:{
			regex : "Please Enter a valid Last Name. ",
			required : "Please provide your name.",
			minlength : "Last Name should be atleast 3 characters long.",
			maxlength : "Last Name should not be too long."
		},
		

	  email:{
		  required : "This field is required.",
			regex : "Enter correct email id.",
	  },
		  
	  password:{
		  regex : "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters",
			required : "Please provide a password.",
			minlength : "Your password must be atleast 8 characters long.",
			maxlength : "Your password is too long."
	  },
	  confirmPassword:{
		  required : "Please provide a password.",
		  equalTo : "Confirm Password must be same as Password."
	  },
	  salary:{
		     required:"This field is required.",
             regex: "Enter a valid salary(eg:20000.33)",
             
            
	  },
	  address:{
		  required:"This field is required",
	  },
	
	  
  }
	
	
});