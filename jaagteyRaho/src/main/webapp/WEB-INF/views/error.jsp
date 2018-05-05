<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
			<div style="border-left: 2px solid #4e4d4d; height: 100%;">
				SALES</div>
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
				<div class="col-sm-12">
					<div class="col-sm-12">
						<div class="text-center error-box">
							<h1 class="error-text tada animated">
								<i class="fa fa-times-circle text-danger error-icon-shadow"></i>
								${title}
							</h1>
							<h2 class="font-xl">
								<strong>${errorTitle}</strong>
							</h2>
							<br>
							<p class="lead semi-bold">
								<strong>${errorDescription}</strong><br> <br>
							</p>
							<ul class="error-search text-left font-md"
								style="list-style: none;">
								<li><a href="${contextRoot}/home" class="btn btn-primary">
										Go to Home &nbsp;&nbsp; <i class="fa fa-arrow-right"></i>
								</a></li>

							</ul>
						</div>

					</div>
				</div>
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
	<%-- <div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>


		<div class="content">

			<div class="container">

				<div class="row">

					<div class="col-xs-12">


						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />

							<blockquote style="word-wrap: break-word">

								${errorDescription}</blockquote>

						</div>


					</div>

				</div>

			</div>

		</div>

		<%@include file="./shared/footer.jsp"%>

	</div> --%>


</body>


</html>