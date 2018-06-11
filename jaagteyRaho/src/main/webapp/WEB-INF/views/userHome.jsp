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
<html lang="en" style="background: #fff;">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Khozema Nullwala">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Jaagtey Raho - ${title}</title>

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
	href="${css}/smartadmin-skins.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/smartadmin-production-plugins.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="${css}/smartadmin-production.min.css">
<script src="${js}/libs/jquery-2.1.1.min.js"></script>
<script src="${js}/libs/jquery-ui-1.10.3.min.js"></script>
</head>
<body
	class="desktop-detected pace-done smart-style-3 pace-done fixed-header fixed-navigation">
	<header id="header" style="background: #f2f2f2;">
		<div id="logo-group"
			style="height: 95px; text-align: center; background: #f2f2f2; border-right: 2px solid #ccc; border-bottom: 2px solid #ccc; padding: 8px;">
			<img src="${images}/logoeaglelatest.png" alt="SmartAdmin"
				style="width: 162px;">
		</div>
		<div class="hidden-xs" style="">
			<div style="height: 100%;">
				<span id="logo" style="font-size: 16px; width: auto;"> <i
					class="fa fa-lg fa-exchange"></i> &nbsp;EMPLOYEE
				</span>
			</div>
		</div>

		<div class="pull-right">
			<%-- <div id="logout" class="btn-header transparent pull-right">
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
			</div> --%>
		</div>
	</header>
	<div id="main" role="main" style="margin-left: 0;">
		<div id="content" style="padding-top: 88px;">
			<div class="row">
				<div class="col-sm-12">
					<div class="col-sm-12">
						<div class="text-center error-box">
							<h1 class="error-text tada animated">
								<i class="fa fa-times-circle text-danger error-icon-shadow"></i>
								Error - 401
							</h1>
							<p class="lead semi-bold">
								<strong>Unauthorized Access</strong><br> <br>
							</p>
							<div class="error-search text-center font-md"
								style="list-style: none;">
								<a href="${contextRoot}/logout" class="btn btn-primary">LOGOUT
								</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="page-footer" style="padding-left: 15px;">
		<div class="row">
			<div class="col-xs-12 col-sm-6"></div>

			<div class="col-xs-6 col-sm-6 text-right hidden-xs">
				<span class="txt-color-white">Jaagtey Raho <span
					class="hidden-xs"> - Web Application Framework</span>
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