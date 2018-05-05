$(function() {
	$(window).load(function() {
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);
	});
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if ((token != undefined && header != undefined)
			&& (token.length > 0 && header.length > 0)) {
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}
	$alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'Users':
		$('#users').addClass('active');
		break;
	case 'SalesManager':
		$("#adminUserBlock").css("display", "block");
		$('#salesManager').addClass('active');
		break;
	case 'SalesOrganizer':
		$("#adminUserBlock").css("display", "block");
		$('#salesOrganization').addClass('active');
		break;
	case 'SalesRepresentatives':
		$('#salesRepresentatives').addClass('active');
		break;
	case 'Clients':
		$('#clients').addClass('active');
		break;
	case 'Products':
		$('#products').addClass('active');
		break;
	case 'Assign Products':
		$('#assignProducts').addClass('active');
		break;
	case 'Payment History':
		$('#paymentHistoryClient').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	function errorPlacement(error, element) {
		// Add the 'help-block' class to the error element
		error.addClass("help-block");

		// add the error label after the input element
		error.insertAfter(element);

		// add the has-feedback class to the
		// parent div.validate in order to add icons to inputs
		element.parents(".validate").addClass("has-feedback");

	}

	pageSetUp();

	var $registerForm = $("#smart-form-register").validate({

		// Rules for form validation
		rules : {
			contactNumber : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 3,
				maxlength : 20
			},
			confirmPassword : {
				required : true,
				minlength : 3,
				maxlength : 20,
				equalTo : '#password'
			},
			firstName : {
				required : true
			},
			lastName : {
				required : true
			},
			dob : {
				required : true
			},
			addressLineOne : {
				required : true
			},
			city : {
				required : true
			},
			postalCode : {
				required : true,
				digits : true
			},
			state : {
				required : true
			},
			country : {
				required : true
			},
			addressLineTwo : {
				required : true
			},
			companyName : {
				required : true
			},
			companyUrl : {
				required : true
			},
			termsAndCondition : {
				required : true
			}
		},

		messages : {
			contactNumber : {
				required : 'Please enter your Contact Number'
			},
			email : {
				required : 'Please enter your email address',
				email : 'Please enter a VALID email address'
			},
			password : {
				required : 'Please enter your password'
			},
			confirmPassword : {
				required : 'Please enter your password one more time',
				equalTo : 'Please enter the same password as above'
			},
			firstName : {
				required : 'Please select your first name'
			},
			lastName : {
				required : 'Please select your last name'
			},
			dob : {
				required : 'Please select your Date Of Birth'
			},
			addressLineOne : {
				required : 'Please Enter Address Line 1'
			},
			addressLineTwo : {
				required : 'Please enter Address Line 2'
			},
			city : {
				required : 'Please enter city'
			},
			postalCode : {
				required : 'Please enter postal code',
				digits : 'Digits Only Please'
			},
			state : {
				required : 'please enter state'
			},
			country : {
				required : 'please enter country'
			},
			companyName : {
				required : 'Please enter Company Name'
			},
			companyUrl : {
				required : 'Please enter Company URL'
			},
			termsAndCondition : {
				required : 'You must agree with Terms and Conditions'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $checkoutForm1 = $('#checkout-form1').validate({
		// Rules for form validation
		rules : {
			fname : {
				required : true
			},
			lname : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			phone : {
				required : true
			},
			country : {
				required : true
			},
			city : {
				required : true
			},
			code : {
				required : true,
				digits : true
			},
			address : {
				required : true
			},
			name : {
				required : true
			},
			card : {
				required : true,
				creditcard : true
			},
			cvv : {
				required : true,
				digits : true
			},
			month : {
				required : true
			},
			year : {
				required : true,
				digits : true
			}
		},

		// Messages for form validation
		messages : {
			fname : {
				required : 'Please enter your first name'
			},
			lname : {
				required : 'Please enter your last name'
			},
			email : {
				required : 'Please enter your email address',
				email : 'Please enter a VALID email address'
			},
			phone : {
				required : 'Please enter your phone number'
			},
			country : {
				required : 'Please select your country'
			},
			city : {
				required : 'Please enter your city'
			},
			code : {
				required : 'Please enter code',
				digits : 'Digits only please'
			},
			address : {
				required : 'Please enter your full address'
			},
			name : {
				required : 'Please enter name on your card'
			},
			card : {
				required : 'Please enter your card number'
			},
			cvv : {
				required : 'Enter CVV2',
				digits : 'Digits only'
			},
			month : {
				required : 'Select month'
			},
			year : {
				required : 'Enter year',
				digits : 'Digits only please'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $checkoutForm = $('#checkout-form').validate({
		rules : {
			organizationName : {
				required : true
			},
			firstName : {
				required : true
			},
			lastName : {
				required : true
			},
			productName : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			contactNumber : {
				required : true
			},
			country : {
				required : true
			},
			city : {
				required : true
			},
			code : {
				required : true,
				digits : true
			},
			address : {
				required : true
			},
			name : {
				required : true
			},
			role : {
				required : true
			},
			Gender : {
				required : true
			},
			description : {
				required : true
			}
		},

		// Messages for form validation
		messages : {
			organizationName : {
				required : 'Please enter Organization name'
			},
			firstName : {
				required : 'Please enter your first name'
			},
			lastName : {
				required : 'Please enter your last name'
			},
			productName : {
				required : 'Please enter the Product Name'
			},
			email : {
				required : 'Please enter your email address',
				email : 'Please enter a VALID email address'
			},
			contactNumber : {
				required : 'Please enter your contact number'
			},
			country : {
				required : 'Please enter your country'
			},
			city : {
				required : 'Please enter your city'
			},
			code : {
				required : 'Please enter code',
				digits : 'Digits only please'
			},
			address : {
				required : 'Please enter your full address'
			},
			name : {
				required : 'Please enter name on your card'
			},
			role : {
				required : 'Please select Role'
			},
			Gender : {
				required : 'Please select Gender'
			},
			description : {
				required : 'Please enter Description'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	$addClientForm = $('#addClientForm');
	if ($addClientForm.length) {
		$addClientForm.validate();
		$("#firstName").rules('add', {
			required : true,
		});
		$("#lastName").rules('add', {
			required : true,
		});
		$("#emailId").rules('add', {
			required : true,
		});
		$("#productId").rules('add', {
			required : true,
		});
	}

	/* validating the loginform */

	// validating the product form element
	// fetch the form element
	$loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username : {
					required : true,
					email : true

				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your email!',
					email : 'Please enter a valid email address!'
				},
				password : {
					required : 'Please enter your password!'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}
		}

		);

	}

	/*------*/
	/* for fading out the alert message after 3 seconds */

	/*------*/
	/* handle refresh cart */
	$('button[name="refreshCart"]')
			.click(
					function() {
						var cartLineId = $(this).attr('value');
						var countField = $('#count_' + cartLineId);
						var originalCount = countField.attr('value');
						// do the checking only the count has changed
						if (countField.val() !== originalCount) {
							// check if the quantity is within the specified
							// range
							if (countField.val() < 1 || countField.val() > 3) {
								// set the field back to the original field
								countField.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Product Count should be minimum 1 and maximum 3!'
										});
							} else {
								// use the window.location.href property to send
								// the request to the server
								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ countField.val();
								window.location.href = updateUrl;
							}
						}
					});
});