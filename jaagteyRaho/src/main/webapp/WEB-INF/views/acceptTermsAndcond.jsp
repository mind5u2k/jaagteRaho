<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form modelAttribute="assignedProduct" cssClass="smart-form"
	id="smart-form-register">
	<header>
		<strong> Product Details</strong>
	</header>
	<fieldset>
		<div class="row" style="padding-bottom: 33px;">
			<div class="col-lg-12">
				<table style="width: 100%;">
					<tr>
						<td style="padding: 12px 9px 2px 13px;">Product</td>
						<td style="padding: 12px 9px 2px 13px;">${assignedProduct.product.productName}</td>
					</tr>
					<tr>
						<td style="padding: 2px 9px 2px 13px;">Description</td>
						<td style="padding: 2px 9px 2px 13px;">${assignedProduct.product.description}</td>
					</tr>
				</table>
			</div>
		</div>
		<section>
			<label class="checkbox"> <sf:checkbox
					path="termsAndCondition" /> <i></i>I agree with the Terms and
				Conditions
			</label>
		</section>
	</fieldset>
	<footer>
		<button class="btn btn-primary" type="submit">Submit</button>
	</footer>
	<sf:hidden path="id" />
</sf:form>

<script>
	var $registerForm = $("#smart-form-register").validate({
		rules : {
			termsAndCondition : {
				required : true
			}
		},

		messages : {
			termsAndCondition : {
				required : 'You must agree with Terms and Conditions'
			}
		},
		submitHandler : function($registerForm) {
			$.ajax({
				type : "POST",
				url : "AcceptTermsAndCondition",
				data : $("#smart-form-register").serialize(),
				success : function(response) {
					$("#trailPeriodBody").html(response);
				},
				error : function(e) {
					console.log('Error: ' + e);
				}
			});
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
</script>