<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form action="saveEmployee" modelAttribute="employee"
	id="checkout-form1" cssClass="smart-form" method="post">
	<fieldset>
		<div class="row">
			<section class="col col-4">
				<label class="label">Employee Code<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <sf:input type="text" path="empId"
						placeholder="" />
				</label>
			</section>
			<section class="col col-8">
				<label class="label">E-mail Address<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-envelope-o"></i>
					<sf:input type="email" path="email" placeholder="" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-4">
				<label class="label">First Name<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="firstName" placeholder="" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Middle Name</label> <label class="input">
					<i class="icon-append fa fa-user"></i> <sf:input type="text"
						path="middleName" placeholder="" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Last Name<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-user"></i> <sf:input
						type="text" path="lastName" placeholder="" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-4">
				<label class="label">DOB</label> <label class="input"> <i
					class="icon-append fa fa-calendar"></i> <sf:input type="text"
						path="dob" placeholder="Date of Birth" class="datepicker"
						data-dateformat="dd/mm/yy" id="dob" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Contact No<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
						type="text" path="contactNumber" placeholder=""
						data-mask="9999999999" />
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Alternate No</label> <label class="input">
					<i class="icon-append fa fa-phone"></i> <sf:input type="text"
						path="alternateNumber" placeholder="" data-mask="9999999999" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-4">
				<label class="label">Gender</label>
				<div class="inline-group">
					<label class="radio"> <sf:radiobutton path="gender"
							value="Male" /> <i></i>Male
					</label> <label class="radio"> <sf:radiobutton path="gender"
							value="Female" /><i></i>Female
					</label>
				</div>
			</section>
			<section class="col col-4">
				<label class="label">Designation<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="select"> <sf:select path="designation.id"
						items="${designations}" itemLabel="designationName" itemValue="id" />
					<i></i>
				</label>
			</section>
			<section class="col col-4">
				<label class="label">Role<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="select"> <sf:select path="role" items="${roles}" />
					<i></i>
				</label>
			</section>
		</div>
	</fieldset>
	<fieldset>
		<div class="row">
			<section class="col col-6">
				<label class="label"
					style="border-bottom: 1px solid #ccc; padding-bottom: 7px;">Correspondence
					Address</label>
			</section>
			<section class="col col-6">
				<label class="label"
					style="border-bottom: 1px solid #ccc; padding-bottom: 7px;">Permanent
					Address</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-6">
				<label class="label">Address<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="textarea"> <sf:textarea path="corredpondenceAddress"
						rows="3" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">Address</label> <label class="textarea">
					<sf:textarea path="permanentAddress" rows="3" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-6">
				<label class="label">Pin Code<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <sf:input type="text"
						path="corredpondencePostalCode" placeholder="" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">Pin Code</label> <label class="input">
					<sf:input type="text" path="permanentPostalCode" placeholder="" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-6">
				<label class="label">State<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <sf:input type="text"
						path="corredpondenceState" placeholder="" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">State</label> <label class="input"> <sf:input
						type="text" path="permanentState" placeholder="" />
				</label>
			</section>
		</div>
		<div class="row">
			<section class="col col-6">
				<label class="label">City<span
					style="color: #f00; padding-left: 4px;">*</span></label> <label
					class="input"> <sf:input type="text"
						path="corredpondenceCity" placeholder="" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">City</label> <label class="input"> <sf:input
						type="text" path="permanentCity" placeholder="" />
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

<script>
	$(document).ready(function() {
		pageSetUp();
	});
</script>