$(function() {
	$(window).load(function() {
		$("#before").css("display", "none");
		$("#content").css("display", "block");
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

	$('#dob').datepicker();

	switch (menu) {
	case 'HOME':
		$('#home').addClass('active');
		break;
	case 'Employees':
		$("#employees").css("display", "block");
		$('#addEmp').addClass('active');
		break;
	case 'Clients':
		$("#clientManagement").css("display", "block");
		$('#manageClient').addClass('active');
		break;
	case 'Sites':
		$("#clientManagement").css("display", "block");
		$('#manageSite').addClass('active');
		break;
	case 'Employee Site Report':
		$("#clientManagement").css("display", "block");
		$('#employeeSiteReport').addClass('active');
		break;
	case 'Designation':
		$("#systemSetup").css("display", "block");
		$('#manageDesignation').addClass('active');
		break;
	case 'Auto Checkin Setting':
		$("#systemSetup").css("display", "block");
		$('#autoCheckinSetting').addClass('active');
		break;
	case 'Manage Checklist':
		$("#systemSetup").css("display", "block");
		$('#manageChecklist').addClass('active');
		break;
	case 'Manage Contact':
		$("#systemSetup").css("display", "block");
		$('#manageContact').addClass('active');
		break;
	case 'REPORT':
		$("#movementAnalysis").css("display", "block");
		$('#report').addClass('active');
		break;
	default:
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

	var $designationForm = $("#designationForm").validate({
		rules : {
			designationCode : {
				required : true
			},
			designationName : {
				required : true
			}
		},
		messages : {
			designationCode : {
				required : 'Please enter Designation Code'
			},
			designationName : {
				required : 'Please enter Designation Name'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $contactPersonForm = $("#contactPersonForm").validate({
		rules : {
			name : {
				required : true
			},
			contactNo : {
				required : true
			}
		},
		messages : {
			name : {
				required : 'Please Enter Contact Person Name'
			},
			contactNo : {
				required : 'Please Enter Contact No'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $checklist = $("#checklist").validate({
		rules : {
			checklist : {
				required : true
			}
		},
		messages : {
			checklist : {
				required : 'Please Add Checklist'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $autoCheckinSettingForm = $("#autoCheckinSettingForm").validate({
		rules : {
			'client.id' : {
				required : true
			},
			'employee.id' : {
				required : true
			}
		},
		messages : {
			'client.id' : {
				required : 'Please Select Client'
			},
			'employee.id' : {
				required : 'Please Select Employee'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $client = $("#client").validate({
		rules : {
			clientCode : {
				required : true
			},
			clientName : {
				required : true
			},
			contactPerson : {
				required : true
			},
			contactNo : {
				required : true
			},
			emailId : {
				required : true,
				email : true
			},
			address : {
				required : true
			}
		},
		messages : {
			clientCode : {
				required : 'Please Enter Client Code'
			},
			clientName : {
				required : 'Please Enter Client Name'
			},
			contactPerson : {
				required : 'Please Enter Contact Person'
			},
			contactNo : {
				required : 'Please Enter Contact Number'
			},
			emailId : {
				required : 'Please Enter Email Id',
				email : 'Please Enter a Valid Email Id'
			},
			address : {
				required : 'Please Enter Address'
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});

	var $site = $("#site").validate({
		rules : {
			siteCode : {
				required : true
			},
			siteName : {
				required : true
			},
			contactPerson : {
				required : true
			},
			contactNo : {
				required : true
			},
			emailId : {
				required : true,
				email : true
			},
			address : {
				required : true
			},
			'client.id' : {
				required : true
			}
		},
		messages : {
			siteCode : {
				required : 'Please Enter Site Code'
			},
			siteName : {
				required : 'Please Enter Site Name'
			},
			contactPerson : {
				required : 'Please Enter Contact Person'
			},
			contactNo : {
				required : 'Please Enter Contact Number'
			},
			emailId : {
				required : 'Please Enter Email Id',
				email : 'Please Enter a Valid Email Id'
			},
			address : {
				required : 'Please Enter Address'
			},
			'client.id' : {
				required : 'Please select Client'
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
			empId : {
				required : true
			},
			firstName : {
				required : true
			},
			lastName : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			contactNumber : {
				required : true
			},
			corredpondenceState : {
				required : true
			},
			corredpondenceCity : {
				required : true
			},
			corredpondencePostalCode : {
				required : true,
				digits : true
			},
			corredpondenceAddress : {
				required : true
			},
			gender : {
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
			empId : {
				required : 'Please Enter Employee code'
			},
			firstName : {
				required : 'Please enter First name'
			},
			lastName : {
				required : 'Please enter Last name'
			},
			email : {
				required : 'Please enter Email address',
				email : 'Please enter a VALID email address'
			},
			contactNumber : {
				required : 'Please enter Contact Number'
			},
			corredpondenceState : {
				required : 'Please Enter State'
			},
			corredpondenceCity : {
				required : 'Please enter City'
			},
			corredpondencePostalCode : {
				required : 'Please enter code',
				digits : 'Digits only please'
			},
			corredpondenceAddress : {
				required : 'Please enter Full address'
			},
			gender : {
				required : 'Please Select Gender'
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