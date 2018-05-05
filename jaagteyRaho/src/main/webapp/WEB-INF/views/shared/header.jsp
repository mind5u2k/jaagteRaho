<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.login-info {
	display: block;
	font-size: 12px;
	height: 125px;
	color: #fff;
	border: solid transparent;
	border-width: 1px 0;
	box-shadow: inset 1px 1px 0 rgba(0, 0, 0, .1), inset 0 -1px 0
		rgba(0, 0, 0, .07);
	width: 100%;
	margin: 0 !important;
	border-bottom: 1px solid #525151;
}

.minified .login-info {
	height: 38px;
	border-bottom: 1px solid #181818;
	visibility: hidden;
}

.minified .login-info>div {
	display: none;
}

.login-info a span {
	text-transform: capitalize;
	font-size: 14px;
	display: inline-block;
	text-decoration: none;
	max-width: 132px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	vertical-align: middle;
}
</style>
<header id="header" style="background: #313131 !important;">
	<div id="logo-group">
		<!-- PLACE YOUR LOGO HERE -->
		<span style="color: #fff; font-size: 24px; padding: 10px 0px 0px 9px;"><span
			style="cursor: pointer;"
			onclick="window.location.href='${contextRoot}/home'"
			class="glyphicon glyphicon-book"></span> </span>
	</div>
	<div class="hidden-xs" style="border-left: 1px solid #000;">
		<div style="border-left: 2px solid #4e4d4d; height: 100%;">
			<span id="logo" style="color: #fff; font-size: 16px; width: auto;">
				SLATE</span>
		</div>
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
<aside id="left-panel" style="background: #464545 !important;">
	<div class="login-info row"
		style="background: linear-gradient(to bottom, #2d2c2c, #797878);">
		<%-- 	<div class="col-sm-12"
			style="padding: 5px 0 5px 0px; text-align: center;">
			<span> <a href="javascript:void(0);"> <span>${userModel.fullName}<br>${userModel.role}
				</span>
			</a></span>
		</div> --%>
		<div class="col-sm-12"
			style="padding: 5px 0 5px 0px; text-align: center;">
			<div class="col-sm-4"
				style="padding: 5px 0 5px 0px; text-align: center;">
				<img src="${images}/male.png" alt="me" class=""
					style="width: 45px; border: 0;">
			</div>
			<div class="col-sm-8"
				style="padding: 5px 0 5px 0px; text-align: center;">
				<span> <a style="margin: 0;"> <span>${userModel.fullName}<br>${userModel.role}
					</span>
				</a></span>
			</div>
		</div>
		<div class="col-sm-12"
			style="padding: 5px 0 5px 0px; text-align: center;">
			<div class="col-sm-12"
				style="padding: 5px 0 5px 0px; text-align: center;">
				<a class="btn btn-danger" style="margin: 0; color: #fff;"
					href="${contextRoot}/editProfile">Profile</a> <a
					class="btn btn-success" href="#" style="margin: 0; color: #fff;">Update
					Password</a>
			</div>
		</div>
	</div>
	<nav>
		<ul>
			<li id="home"><a href="${contextRoot}/home"><i
					class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Home
						Page</span></a></li>
			<security:authorize access="hasAuthority('SUPER ADMIN')">
				<li id="users"><a href="${contextRoot}/su/user"><i
						class="fa fa-lg fa-fw fa-user"></i> <span class="menu-item-parent">User</span></a></li>
			</security:authorize>


			<security:authorize access="hasAuthority('ADMIN')">
				<li id="adminUsers"><a href="#"><i
						class="fa fa-lg fa-fw fa-bank"></i> <span class="menu-item-parent">Users</span><b
						class="collapse-sign"><em class="fa fa-minus-square-o"></em></b></a>
					<ul id="adminUserBlock" style="display: none;">
						<li id="salesManager"><a
							href="${contextRoot}/ad/salesManager">Sales Manager</a></li>
						<li id="salesOrganization"><a
							href="${contextRoot}/ad/salesOrganization">Sales Organization</a></li>
					</ul></li>
				<li id="products"><a href="${contextRoot}/products"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Products</span></a></li>
			</security:authorize>

			<security:authorize access="hasAuthority('SALES MANAGER')">
				<li id="salesRepresentatives"><a
					href="${contextRoot}/sm/salesRepresentatives"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Sales
							Representatives</span></a></li>
			</security:authorize>

			<security:authorize access="hasAuthority('SALES REPRESENTATIVE')">
				<li id="clients"><a href="${contextRoot}/sr/clients"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Clients</span></a></li>
				<li id="assignProducts"><a
					href="${contextRoot}/sr/assignProducts"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Assign
							Products</span></a></li>
			</security:authorize>
			<security:authorize access="hasAuthority('CLIENT')">
				<li id="paymentHistoryClient"><a
					href="${contextRoot}/cl/paymentHistory"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Payment
							History</span></a></li>
			</security:authorize>

			<li><div class="minifyme"
					style="background: rgb(123, 120, 120); position: unset; text-align: center; font-size: 24px; padding: 6px 1px 31px; margin-top: 17px; cursor: pointer; width: 100%;"
					data-action="minifyMenu">
					<i class="fa fa-arrow-circle-left hit"></i>
				</div></li>

		</ul>
	</nav>
</aside>