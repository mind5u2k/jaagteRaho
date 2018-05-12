<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form action="updatedContactPerson"
	modelAttribute="selectedContactPerson" id="contactPersonForm1"
	cssClass="smart-form" method="post">
	<fieldset>
		<div class="row">
			<section class="col col-4">
				<label class="label">Contact Person Name<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="name" placeholder="" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Contact No.<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
						type="text" path="contactNo" placeholder="" data-mask="9999999999" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Alternate Contact No.</label> <label
					class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
						type="text" path="alternateNo" placeholder=""
						data-mask="9999999999" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-12" style="float: right;">
				<label class="input"> <sf:hidden path="id" />
					<button type="submit" name="submit" class="btn btn-primary"
						style="padding: 7px 10px 7px 10px; margin-top: 18px;">
						Submit</button>
				</label>
			</section>
		</div>
	</fieldset>
</sf:form>
<script src="${js}/plugin/jquery-form/jquery-form.min.js"></script>
<script>
	$(document).ready(function() {
		pageSetUp();
	});
	var $contactPersonForm1 = $("#contactPersonForm1").validate({
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
</script>