<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">REPORT</li>
	</ol>
</div>
<c:if test="${not empty msg}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-success"
			style="margin-bottom: 14px; position: fixed; z-index: 11; width: 31%; top: 54px; left: 42%; text-align: center;">${msg}</div>
	</div>
</c:if>
<c:if test="${not empty errorMsg}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-danger"
			style="margin-bottom: 14px; position: fixed; z-index: 11; width: 31%; top: 54px; left: 42%; text-align: center;">${errorMsg}</div>
	</div>
</c:if>
<div id="before"
	style="width: 100%; height: 600px; text-align: center; vertical-align: middle; font-size: 17px; padding-top: 194px;">
	<img src="${images}/qqq.png" style="height: 84px;"><br>
	Please wait ...
</div>
<div id="content" style="display: none;">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="row" style="padding: 0px;">
				<div class="col-sm-12">
					<form id="designationForm" class="smart-form" method="post">
						<fieldset style="padding-top: 0;">
							<div class="row">
								<section class="col-12">
									<label class="label">Select Employee </label> <label
										class="select state-success"> <select id="userId"
										onchange="updateDetails();" name="role" class="valid">
											<c:forEach items="${users}" var="user">
												<c:if test="${user.id == emp.id}">
													<option selected="selected" value="${user.id}">${user.empId}-
														${user.firstName}
														<c:if test="${not empty user.middleName}">&nbsp;${user.middleName}</c:if>
														${user.lastName}
													</option>

												</c:if>
												<c:if test="${user.id != emp.id}">
													<option value="${user.id}">${user.empId}-
														${user.firstName}
														<c:if test="${not empty user.middleName}">&nbsp;${user.middleName}</c:if>
														${user.lastName}
													</option>

												</c:if>
											</c:forEach>
									</select> <i></i>
									</label>
								</section>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-12">
			<div class="row">
				<div class="col-sm-12"></div>
				<article class="col-sm-12 sortable-grid ui-sortable">
					<!-- new widget -->
					<div class="jarviswidget jarviswidget-sortable" id="wid-id-0">
						<header role="heading">
							<span class="widget-icon"> <i
								class="glyphicon glyphicon-stats txt-color-darken"></i>
							</span>
							<h2>Report</h2>
						</header>
						<div class="no-padding" role="content">
							<div class="widget-body" style="padding-bottom: 0;">
								<div id="myTabContent" class="tab-content">
									<div class="row no-space">
										<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8"
											style="border-right: 1px solid #ccc;">
											<table id="datatable_col_reorder"
												class="table table-striped table-bordered table-hover dataTable no-footer"
												width="100%" role="grid"
												aria-describedby="datatable_col_reorder_info"
												style="width: 100%;">
												<thead>
													<tr role="row">
														<th style="width: 40px;">Sr.</th>
														<th>Employee ID</th>
														<th>Name</th>
														<th>Sent Status</th>
														<th>Sent Time</th>
														<th>Received Status</th>
														<th>Received Time</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${pushNotificationsStatus}" var="cl">
														<c:set var="i" value="${i+1}" scope="page" />
														<tr role="row">
															<td class="sorting_1">${i}</td>
															<td>${cl.employee.empId}</td>
															<td>${cl.employee.firstName}<c:if
																	test="${not empty cl.employee.middleName}">&nbsp;${cl.employee.middleName}</c:if>
																${cl.employee.lastName}
															</td>
															<td>${cl.sentStatus}</td>
															<td>${cl.sentTimestamp}</td>
															<td>${cl.receivedStatus}</td>
															<td>${cl.receivedTimestamp}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 show-stats">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</article>
			</div>
		</div>
	</div>
</div>

<style>
.ui-dialog-titlebar {
	padding: 3px 12px 3px 12px !important;
	background: #ccc !important;
}

.ui-dialog .ui-dialog-title {
	margin: 0 !important;
	font-weight: 400 !important;
}

.ui-dialog .ui-dialog-titlebar-close {
	margin-top: -11px !important;
	margin-right: 4px !important;
}
</style>
<script src="${js}/plugin/datatables/jquery.dataTables.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.colVis.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.tableTools.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.bootstrap.min.js"></script>
<script
	src="${js}/plugin/datatable-responsive/datatables.responsive.min.js"></script>

<script>
	$(document)
			.ready(
					function() {
						pageSetUp();
						$.extend($.fn.dataTable.defaults, {
							buttons : [ 'csv', 'excel', 'pdf' ]
						});
						var responsiveHelper_dt_basic = undefined;
						var responsiveHelper_datatable_fixed_column = undefined;
						var responsiveHelper_datatable_col_reorder = undefined;
						var responsiveHelper_datatable_tabletools = undefined;

						var breakpointDefinition = {
							tablet : 1024,
							phone : 480
						};

						$("div.toolbar")
								.html(
										'<div class="text-right"><img src="img/logo.png" alt="SmartAdmin" style="width: 111px; margin-top: 3px; margin-right: 10px;"></div>');
						$('#datatable_col_reorder')
								.dataTable(
										{
											dom : 'Bfrtip',
											buttons : [ 'csv', 'excel', 'pdf' ],
											"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'C>r>"
													+ "t"
													+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
											"autoWidth" : true,
											"preDrawCallback" : function() {
												// Initialize the responsive datatables helper once.
												if (!responsiveHelper_datatable_col_reorder) {
													responsiveHelper_datatable_col_reorder = new ResponsiveDatatablesHelper(
															$('#datatable_col_reorder'),
															breakpointDefinition);
												}
											},
											"rowCallback" : function(nRow) {
												responsiveHelper_datatable_col_reorder
														.createExpandIcon(nRow);
											},
											"drawCallback" : function(oSettings) {
												responsiveHelper_datatable_col_reorder
														.respond();
											}
										});

						$('#dialog_link').click(function() {
							$('#dialog_simple').dialog('open');
							return false;

						});

						$('#dialog_simple').dialog({
							autoOpen : false,
							width : 850,
							height : 300,
							resizable : false,
							modal : true
						});
						$('#editClientDialog').dialog({
							autoOpen : false,
							width : 850,
							height : 300,
							resizable : false,
							modal : true
						});

					});

	function editClient(clientId) {
		$('#editClientDialog').dialog('open');
		$.ajax({
			type : "GET",
			url : "editClient?clientId=" + clientId,
			success : function(response) {
				$('#clientDetails').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function deleteClient(clientId) {
		$("#deletedClientId").val(clientId);
		$('#deleteClientModel').modal({
			show : true
		});
	}

	function deletePermanent() {
		var deletedClientId = $("#deletedClientId").val();
		window.location.href = "deleteClient/" + deletedClientId;
	}

	$(function() {
		$("#dob").datepicker({
			minDate : 0
		});
	});

	function updateDetails() {
		var userId = $("#userId").val();
		window.location.href = "report?userId=" + userId;
	}
</script>