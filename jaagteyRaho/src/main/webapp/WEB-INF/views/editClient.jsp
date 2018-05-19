<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form action="updateClient" modelAttribute="selectedClient"
	id="client1" cssClass="smart-form client" method="post">
	<fieldset>
		<div class="row">
			<section class="col col-3">
				<label class="label">Client Code<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="clientCode" placeholder="" />
				</label>
			</section>
			<section class="col col-3">
				<label class="label">Client Name<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="clientName" placeholder="" />
				</label>
			</section>
			<section class="col col-3">
				<label class="label">Contact Person<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="contactPerson" placeholder="" />
				</label>
			</section>
			<section class="col col-3">
				<label class="label">Contact No.<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
						type="text" path="contactNo" placeholder="" data-mask="9999999999" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-6">
				<label class="label">Email<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-envelope-o"></i>
					<sf:input type="email" path="emailId" placeholder="" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">Address<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <sf:input type="text" path="address"
						placeholder="" />
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
	var $client1 = $("#client1").validate({
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
</script>