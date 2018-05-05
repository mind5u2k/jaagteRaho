<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/shopping/css" />
<spring:url var="js" value="/resources/shopping/js" />
<spring:url var="images" value="/resources/shopping/img" />
<spring:url var="fonts" value="/resources/shopping/fonts" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" style="background: #b8dcc7;">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Website Using Spring MVC and Hibernate">

<title>Jaagtey Raho</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/font-awesome.min.css">

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/smartadmin-production-plugins.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/smartadmin-production.min.css">
<script src="${js}/libs/jquery-2.1.1.min.js"></script>
<script src="${js}/libs/jquery-ui-1.10.3.min.js"></script>
</head>
<body
	class="animated fadeInDown  desktop-detected menu-on-top pace-done fixed-page-footer">
	<div id="main" role="main"
		style="background: #b8dcc7; height: 100%; margin-top: 35px !important;">
		<div id="content" class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-5 col-md-offset-4">
					<div
						style="text-align: center; font-size: 21px; color: #316848; padding-bottom: 12px;">Admin
						Panel Login</div>
					<c:if test="${not empty message}">
						<div class="card card-login mx-auto mt-5">
							<div class="alert alert-danger" style="margin-bottom: 14px;">${message}</div>
						</div>
					</c:if>
					<c:if test="${not empty logout}">
						<div class="card card-login mx-auto mt-5">
							<div class="alert alert-success" style="margin-bottom: 14px;">${logout}</div>
						</div>
					</c:if>
					<div class="well no-padding"
						style="border: 1px solid #029643; box-shadow: 4px 5px 11px #019642;">
						<form action="${contextRoot}/login" method="POST" id="loginForm"
							class="smart-form client-form" novalidate="novalidate">
							<header
								style="text-align: center; color: #fff; background: #eff8f3; border-bottom: 1px solid #019642;">
								<img src="${images}/logoeaglelatest.png">
							</header>
							<fieldset>
								<section>
									<label class="label">E-mail</label> <label class="input">
										<i class="icon-append fa fa-user"></i> <input type="email"
										name="username" id="username" /> <b
										class="tooltip tooltip-top-right"><i
											class="fa fa-user txt-color-teal"></i> Please enter email
											address/username</b>
									</label>
								</section>
								<section>
									<label class="label">Password</label> <label class="input">
										<i class="icon-append fa fa-lock"></i> <input type="password"
										name="password" id="password" /> <b
										class="tooltip tooltip-top-right"><i
											class="fa fa-lock txt-color-teal"></i> Enter your password</b>
									</label>
									<div class="note" style="margin-top: 22px;">
										<a href="forgotpassword.html">Forgot password?</a>
									</div>
								</section>
							</fieldset>
							<footer
								style="background: #eff8f3; border-top: 1px solid #47b075;">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<button type="submit" class="btn btn-success">Sign in</button>
							</footer>
						</form>

					</div>

				</div>
			</div>
		</div>

	</div>

	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="${contextPath}/comDash/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
		}
	</script>
	<script src="${js}/app.config.js"></script>
	<script src="${js}/bootstrap/bootstrap.min.js"></script>
	<script src="${js}/notification/SmartNotification.min.js"></script>
	<script src="${js}/plugin/jquery-validate/jquery.validate.min.js"></script>
	<script src="${js}/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
	<script src="${js}/app.min.js"></script>
	<script src="${js}/plugin/bootstrapvalidator/bootstrapValidator.min.js"></script>
	<script src="${js}/myapp.js"></script>
	<!-- jQuery -->


</body>

</html>