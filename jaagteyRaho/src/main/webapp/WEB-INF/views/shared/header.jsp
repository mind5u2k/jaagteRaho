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
<header id="header" style="background: #f2f2f2;">
	<div id="logo-group"
		style="height: 95px; text-align: center; background: #f2f2f2; border-right: 2px solid #ccc; border-bottom: 2px solid #ccc; padding: 8px;">
		<img src="${images}/logoeaglelatest.png" alt="SmartAdmin"
			style="width: 162px;">
	</div>
	<div class="hidden-xs" style="">
		<div style="height: 100%;">
			<span id="logo" style="font-size: 16px; width: auto;"> <i
				class="fa fa-lg fa-exchange"></i> &nbsp;ADMIN
			</span>
		</div>
	</div>
	<div class="pull-right">
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
<aside id="left-panel">
	<nav>
		<ul>
			<li id="home"><a href="${contextRoot}/home"><i
					class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Home
				</span></a></li>
			<li id=" "><a href="#"><i class="fa fa-lg fa-fw fa-user"></i>
					<span class="menu-item-parent">Manage Employees</span><b
					class="collapse-sign"><em class="fa fa-minus-square-o"></em></b></a>
				<ul id="employees" style="display: none;">
					<li id="addEmp"><a href="${contextRoot}/ad/addEmployees">Add
							Employees</a></li>
				</ul></li>
			<li id=""><a href="#"><i class="fa fa-lg fa-fw fa-tasks"></i>
					<span class="menu-item-parent">Client Management</span><b
					class="collapse-sign"><em class="fa fa-minus-square-o"></em></b></a>
				<ul id="clientManagement" style="display: none;">
					<li id="manageClient"><a href="${contextRoot}/ad/manageClient">Manage
							Client</a></li>
					<li id="manageSite"><a href="${contextRoot}/ad/manageSite">Manage
							Site</a></li>
					<li id="employeeSiteReport"><a
						href="${contextRoot}/ad/employeeSiteReport">Employee Site
							Report</a></li>
				</ul></li>
			<li id=""><a href="#"><i class="fa fa-lg fa-fw fa-laptop"></i>
					<span class="menu-item-parent">System Setup</span><b
					class="collapse-sign"><em class="fa fa-minus-square-o"></em></b></a>
				<ul id="systemSetup" style="display: none;">
					<li id="manageDesignation"><a
						href="${contextRoot}/ad/manageDesignation">Manage Designation</a></li>
					<%-- <li id="manageChecklist"><a
						href="${contextRoot}/ad/manageChecklist">Manage CheckList</a></li> --%>
					<li id="manageContact"><a
						href="${contextRoot}/ad/manageContact">Manage Contact</a></li>
					<li id="autoCheckinSetting"><a
						href="${contextRoot}/ad/autoCheckinSetting">Auto Checkin
							Setting</a></li>
					<li id="salesManager"><a href="#">Device Mapping</a></li>
				</ul></li>
			<li id="adminUsers"><a href="#"><i
					class="fa fa-lg fa-fw fa-retweet"></i> <span
					class="menu-item-parent">Movement Analysis</span><b
					class="collapse-sign"><em class="fa fa-minus-square-o"></em></b></a>
				<ul id="adminUserBlock" style="display: none;">
					<li id="salesManager"><a href="#">Site Audit Report</a></li>
					<li id="salesOrganization"><a href="#">Auto Checkin Report</a></li>
					<%-- <li id="salesManager"><a href="#">Selfie Checkin Report</a></li>
					<li id="salesOrganization"><a
						href="${contextRoot}/ad/salesOrganization">Geofancing Report</a></li> --%>
				</ul></li>
		</ul>
	</nav>
</aside>