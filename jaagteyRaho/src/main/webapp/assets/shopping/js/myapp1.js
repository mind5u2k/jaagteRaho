var $feedbackForm = $("#feedbackForm");
if ($feedbackForm.length) {
	$feedbackForm
			.validate({
				rules : {
					group : {
						required : true
					},
				},
				messages : {
					group : {
						required : 'Please Select Group',
					},
				},
				submitHandler : function(form) {
					$('#dialog-message').dialog('open');
					$
							.ajax({
								type : "POST",
								url : "SubmitFeedbackForm",
								data : $("#feedbackForm").serialize(),
								success : function(response) {
									$('#dialog-message').dialog('close');
									$("#feedbackForm").addClass('submited');
									$("#feedbackForm")
											.html(
													'<div class="message"> <i class="fa fa-thumbs-up"></i> <p>Your Response has been Submitted Successfully!</p><br> <button class="btn btn-primary" onclick="window.location.href=\'FeedbackForm\'" style="padding: 6px 9px;">Press Here to give another Feedback</button></div>');
								},
								error : function(e) {
									console.log('Error: ' + e);
								}
							});
					/*
					 * $(form).ajaxSubmit({ url : 'SubmitFeedbackForm', data :
					 * $("#feedbackForm").serialize(), success :
					 * function(response) {
					 * $("#feedbackForm").addClass('submited'); } });
					 */
				},
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			});
}