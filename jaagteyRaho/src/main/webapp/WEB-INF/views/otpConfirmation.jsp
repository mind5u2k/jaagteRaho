<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty error}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-danger"
			style="margin-bottom: 14px; width: 277px; margin: auto;">${error}</div>
	</div>
</c:if>
<c:if test="${not empty sentOtp}">
	<div>
		<div style="color: #297d29; font-size: 16px;">
			<i class="fa fa-check-square-o"></i> ${sentOtp}
		</div>
	</div>
</c:if>
<form id="smart-form-register" class="smart-form"
	novalidate="novalidate">
	<header> Please Enter the OTP you have received in your MailId
	</header>
	<fieldset>
		<div class="row">
			<section class="col col-3"></section>
			<section class="col col-6">
				<label class="input"> <i class="icon-append fa fa-lock"></i>
					<input type="text" name="oneTimePassword" placeholder="OTP"
					id="oneTimePassword"> <b
					class="tooltip tooltip-bottom-right">Please Enter OTP you have
						received</b>
				</label>
			</section>
		</div>
	</fieldset>
	<footer style="background: none; border: 0; text-align: center;">
		<button class="btn btn-primary" onclick="sendOtp();"
			style="float: none;">Send One Time Password</button>
		<button type="button" onclick="checkOtp();" class="btn btn-primary"
			style="float: none;">Confirm</button>
	</footer>
</form>