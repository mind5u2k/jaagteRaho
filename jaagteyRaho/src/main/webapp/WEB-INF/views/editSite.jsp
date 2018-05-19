<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form action="updateSite" modelAttribute="selectedSite" id="site1"
	cssClass="smart-form" method="post">
	<fieldset>
		<div class="row">
			<section class="col col-4">
				<label class="label">Site Code<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="siteCode" placeholder="" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Site Name<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="siteName" placeholder="" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Client<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="select"> <sf:select path="client.id"
						items="${clients}" itemLabel="clientName" itemValue="id" /> <i></i>
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-4">
				<label class="label">Contact Person<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="contactPerson" placeholder="" />
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
				<label class="label">Email<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-envelope-o"></i>
					<sf:input type="email" path="emailId" placeholder="" />
				</label>
			</section>
		</div>
		<div class="row">
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

	var $site1 = $("#site1").validate({
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
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
</script>