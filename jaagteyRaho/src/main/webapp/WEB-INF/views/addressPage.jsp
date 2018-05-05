<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<spring:url var="css" value="/resources/shopping/css" />
<spring:url var="js" value="/resources/shopping/js" />
<spring:url var="images" value="/resources/shopping/img" />
<spring:url var="fonts" value="/resources/shopping/fonts" />
<spring:url var="img" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Khozema Nullwala">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>

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
	class="desktop-detected voice-command-active service-not-allowed pace-done fixed-header fixed-navigation">
	<header id="header" style="background: #313131 !important;">
		<div id="logo-group">
			<!-- PLACE YOUR LOGO HERE -->
			<span
				style="color: #fff; font-size: 24px; padding: 10px 0px 0px 9px;"><span
				style="cursor: pointer;"
				onclick="window.location.href='${contextRoot}/home'"
				class="glyphicon glyphicon-book"></span> </span>
		</div>
		<div class="hidden-xs" style="border-left: 1px solid #000;">
			<div style="border-left: 2px solid #4e4d4d; height: 100%;"></div>
		</div>

		<div class="pull-right">
			<ul id="mobile-profile-img"
				class="header-dropdown-list hidden-xs padding-5">
				<li class=""><a href="#"
					class="dropdown-toggle no-margin userdropdown"
					data-toggle="dropdown"> </a>
					<ul class="dropdown-menu pull-right">
						<li><a href="javascript:void(0);"
							class="padding-10 padding-top-0 padding-bottom-0"><i
								class="fa fa-cog"></i> Setting</a></li>
						<li class="divider"></li>
						<li><a href="profile.html"
							class="padding-10 padding-top-0 padding-bottom-0"> <i
								class="fa fa-user"></i> <u>P</u>rofile
						</a></li>
						<li class="divider"></li>
						<li><a href="javascript:void(0);"
							class="padding-10 padding-top-0 padding-bottom-0"
							data-action="toggleShortcut"><i class="fa fa-arrow-down"></i>
								<u>S</u>hortcut</a></li>
						<li class="divider"></li>
						<li><a href="javascript:void(0);"
							class="padding-10 padding-top-0 padding-bottom-0"
							data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i>
								Full <u>S</u>creen</a></li>
						<li class="divider"></li>
						<li><a href="${contextPath}/logout"
							class="padding-10 padding-top-5 padding-bottom-5"
							data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i>
								<strong><u>L</u>ogout</strong></a></li>
					</ul></li>
			</ul>
			<div id="logout" class="btn-header transparent pull-right">
				<span> <a href="${contextRoot}/logout" title="Sign Out"
					data-action="userLogout"
					data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i
						class="fa fa-sign-out"></i></a>
				</span>
			</div>
			<div id="hide-menu" class="btn-header pull-right">
				<span> <a href="javascript:void(0);" data-action="toggleMenu"
					title="Collapse Menu"><i class="fa fa-reorder"></i></a>
				</span>
			</div>
			<div id="fullscreen" class="btn-header transparent pull-right">
				<span> <a href="javascript:void(0);"
					data-action="launchFullscreen" title="Full Screen"><i
						class="fa fa-arrows-alt"></i></a>
				</span>
			</div>
		</div>
	</header>
	<div id="main" role="main" style="margin-left: 0;">
		<div id="content">
			<div class="row">
				<div class="col-lg-12"
					style="padding: 17px; text-align: center; font-size: 21px;">Update
					Details</div>
				<article class="col-md-6 col-md-offset-3 sortable-grid ui-sortable">
					<div
						style="border-top: 1px solid #ccc; box-shadow: 5px 5px 5px #504f4f;"
						class="jarviswidget jarviswidget-color-darken jarviswidget-sortable"
						id="wid-id-0" data-widget-editbutton="false"
						data-widget-deletebutton="false" role="widget">
						<div role="content">
							<div class="widget-body fuelux">
								<sf:form action="${contextRoot}/cl/updateAddress"
									modelAttribute="address" id="smart-form-register"
									cssClass="smart-form" method="post">
									<sf:hidden path="id" />
									<div class="wizard">
										<ul class="steps">
											<li data-target="#step1"><span class="badge badge-info">1</span>Step
												1<span class="chevron"></span></li>
											<li data-target="#step2" class="active"><span
												class="badge">2</span>Step 2<span class="chevron"></span></li>
											<li data-target="#step3"><span class="badge">3</span>Step
												3<span class="chevron"></span></li>
											<li data-target="#step4"><span class="badge">4</span>Step
												4<span class="chevron"></span></li>
										</ul>
										<div class="actions">
											<%-- <button type="button" class="btn btn-sm btn-primary btn-prev"
												onclick="window.location.href='${contextRoot}/cl/home'">
												<i class="fa fa-arrow-left"></i>Prev
											</button> --%>
											<button type="submit" class="btn btn-sm btn-success btn-next"
												data-last="Finish">
												Next <i class="fa fa-arrow-right"></i>
											</button>
										</div>
									</div>
									<div class="step-content">

										<header>
											<strong>Step 2 - </strong> Address
										</header>
										<fieldset>
											<section>
												<label class="input"> <sf:input type="text"
														path="addressLineOne" placeholder="Address Line 1" />
												</label>
											</section>
											<section>
												<label class="textarea"> <sf:textarea
														path="addressLineTwo" rows="3"
														placeholder="Address Line 2" />
												</label>
											</section>
											<div class="row">
												<section class="col col-6">
													<label class="input"> <sf:input type="text"
															path="city" placeholder="City" />
													</label>
												</section>
												<section class="col col-6">
													<label class="input"> <sf:input type="text"
															path="postalCode" placeholder="Postal code" />
													</label>
												</section>
											</div>
											<div class="row">
												<section class="col col-6">
													<label class="input"> <sf:input type="text"
															path="state" placeholder="State" />
													</label>
												</section>
												<section class="col col-6">
													<label class="input"> <sf:input type="text"
															path="country" placeholder="Country" />
													</label>
												</section>
											</div>
										</fieldset>
									</div>
								</sf:form>
							</div>
						</div>
					</div>
				</article>
			</div>
		</div>
	</div>
	<div class="page-footer" style="padding-left: 15px;">
		<div class="row">
			<div class="col-xs-12 col-sm-6">
				<span class="txt-color-white">Sales <span class="hidden-xs">
						- Web Application Framework</span>
				</span>
			</div>

			<div class="col-xs-6 col-sm-6 text-right hidden-xs">
				<span class="txt-color-white">Designed & Developed by <span
					class="hidden-xs"> - Anurag Ghosh</span>
				</span>

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
	<script src="${js}/plugin/masked-input/jquery.maskedinput.min.js"></script>
	<script src="${js}/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
	<script src="${js}/app.min.js"></script>
	<script src="${js}/plugin/bootstrapvalidator/bootstrapValidator.min.js"></script>
	<script src="${js}/plugin/jquery-form/jquery-form.min.js"></script>
	<script
		src="${js}/plugin/bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
	<script src="${js}/myapp.js"></script>
	<script>
		$('#dob').datepicker({
			dateFormat : 'dd/mm/yy',
			prevText : '<i class="fa fa-chevron-left"></i>',
			nextText : '<i class="fa fa-chevron-right"></i>',
		});
	</script>
</body>
</html>