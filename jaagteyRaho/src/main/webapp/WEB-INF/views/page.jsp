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

<title>Jaagtey Raho</title>
<link rel="icon" type="image/png" href="${images}/logoeaglelatest.png">
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
	<%@include file="./shared/header.jsp"%>
	<div id="main" role="main">

		<c:if test="${userClickAdminHome == true }">
			<%@include file="report.jsp"%>
		</c:if>
		<c:if test="${userClickAdminAddEmployees == true }">
			<%@include file="employees.jsp"%>
		</c:if>
		<c:if test="${userClickAdminManageClient == true }">
			<%@include file="manageClients.jsp"%>
		</c:if>
		<c:if test="${userClickAdminManageSite == true }">
			<%@include file="manageSites.jsp"%>
		</c:if>
		<c:if test="${userClickAdminEmployeeSiteReport == true }">
			<%@include file="employeeSiteReport.jsp"%>
		</c:if>
		<c:if test="${userClickAdminManageDesignation == true }">
			<%@include file="manageDesignation.jsp"%>
		</c:if>
		<c:if test="${userClickAdminAutoCheckinSetting == true }">
			<%@include file="autoCheckinSetting.jsp"%>
		</c:if>
		<c:if test="${userClickAdminManageChecklist == true }">
			<%@include file="manageChecklist.jsp"%>
		</c:if>
		<c:if test="${userClickAdminManageContact == true }">
			<%@include file="manageContact.jsp"%>
		</c:if>
		<c:if test="${userClickAdminReport == true }">
			<%@include file="report.jsp"%>
		</c:if>
	</div>
	<%@include file="./shared/footer.jsp"%>

	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="${contextPath}/comDash/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
		}
	</script>
	<script src="${js}/excellentexport.js"></script>
	<script src="${js}/app.config.js"></script>
	<script src="${js}/bootstrap/bootstrap.min.js"></script>
	<script src="${js}/notification/SmartNotification.min.js"></script>
	<script src="${js}/plugin/jquery-validate/jquery.validate.min.js"></script>
	<script src="${js}/plugin/masked-input/jquery.maskedinput.min.js"></script>
	<script src="${js}/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
	<script src="${js}/app.min.js"></script>
	<script src="${js}/plugin/bootstrapvalidator/bootstrapValidator.min.js"></script>
	<script src="${js}/plugin/jquery-form/jquery-form.min.js"></script>

	<script src="${js}/myapp.js"></script>

</body>
</html>