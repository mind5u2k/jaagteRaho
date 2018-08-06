<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">${title}</li>
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
		<div class="col-sm-12">
			<div class="row" style="padding: 0px;">
				<div class="col-sm-12">
					<form id="designationForm" class="smart-form" method="post">
						<fieldset style="padding-top: 0;">
							<div class="row">
								<section class="col col-2">
									<label class="label">Select Client </label> <label
										class="select"> <select id="clientId" name="cl"
										onchange="updateSite(this.value);">
											<option selected="selected" value="0">All Clients</option>
											<c:forEach items="${clients}" var="client">
												<option value="${client.id}">${client.clientName}</option>
											</c:forEach>
									</select> <i></i>
									</label>
								</section>
								<section class="col col-2" id="siteSection">
									<label class="label">Select Site </label> <label class="select">
										<select id="siteId" name="role"><option
												selected="selected" value="0">All Sites</option>
									</select> <i></i>
									</label>
								</section>
								<section class="col col-2" id="employeeSection">
									<label class="label">Select Employee </label> <label
										class="select"> <select id="userId" name="role"><option
												selected="selected" value="0">All Employees</option>
									</select> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Select Start Date</label> <label
										class="input"> <i class="icon-append fa fa-calendar"></i>
										<input id="startDate" value="${startDate}" name="startDate"
										data-dateformat="dd/mm/yy" placeholder="Select Start Date"
										type="text" class="datepicker">
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Select End Date</label> <label
										class="input"> <i class="icon-append fa fa-calendar"></i>
										<input id="endDate" value="${endDate}" name="endDate"
										data-dateformat="dd/mm/yy" placeholder="Select Start Date"
										type="text" class="datepicker">
									</label>
								</section>
								<section class="col col-2">
									<label class="label">&nbsp;</label> <label class="input">
										<input id="id" name="id" type="hidden" value="1"> <input
										type="button" value="Submit" class="btn btn-primary"
										onclick="updateReportPanel();"
										style="width: 93px; border-radius: 2px; border: 1px solid #ccc;">
									</label>
								</section>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-12" id="reportPanel">
			<input type="hidden" id="sent" value="${sent}"> <input
				type="hidden" id="received" value="${received}">
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
										<div class="col-md-9 show-stats">
											<div
												style="margin: auto; text-align: center; font-size: 16px; padding: 12px 0px 14px 0px;">
												<span style="border-bottom: 1px solid #141313;">Chart
													Representation</span>
											</div>
											<div
												style="margin: auto; text-align: center; padding-bottom: 15px;">
												<canvas id="pieChart" height="70px"></canvas>
											</div>
										</div>
										<div class="col-md-3 show-stats"
											style="text-align: right; padding: 0 5px 0 0px;">
											<a class="btn btn-default"
												href="${contextRoot}/admin/downloadReports?clientid=0&siteId=0&empId=0&date=${date}"
												target="_blank"> <i class="fa fa-file-excel-o"></i>
												&nbsp;Download Excel
											</a>
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
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
														<th>Image</th>
														<th>Name</th>
														<th>Sent Status</th>
														<th>Sent Time</th>
														<th>Via</th>
														<th>Received Status</th>
														<th>Received Time</th>
														<th>Address</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${pushNotificationsStatus}" var="cl">
														<c:set var="i" value="${i+1}" scope="page" />
														<tr role="row">
															<td class="sorting_1">${i}</td>
															<td>${cl.employee.empId}</td>
															<td style="padding: 2px !important; text-align: center;">
																<c:if test="${not empty cl.profile_pic}">
																	<img style="height: 64px; width: 56px;"
																		src='data:image/png;base64,${cl.profile_pic}'>
																</c:if>
															</td>
															<td>${cl.employee.firstName}<c:if
																	test="${not empty cl.employee.middleName}">&nbsp;${cl.employee.middleName}</c:if>
																${cl.employee.lastName}
															</td>
															<td>${cl.sentStatus}</td>
															<td>${cl.sentTimestamp}</td>
															<td>${cl.sentBy}</td>
															<td>${cl.receivedStatus}</td>
															<td>${cl.receivedTimestamp}</td>
															<td>${cl.currentLocation}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
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
<script src="${js}/Chart.min.js"></script>


<script>
	$(document)
			.ready(
					function() {
						pageSetUp();
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

						var pieOptions = {
							//Boolean - Whether we should show a stroke on each segment
							segmentShowStroke : true,
							//String - The colour of each segment stroke
							segmentStrokeColor : "#fff",
							//Number - The width of each segment stroke
							segmentStrokeWidth : 2,
							//Number - Amount of animation steps
							animationSteps : 100,
							//String - types of animation
							animationEasing : "easeOutBounce",
							//Boolean - Whether we animate the rotation of the Doughnut
							animateRotate : true,
							//Boolean - Whether we animate scaling the Doughnut from the centre
							animateScale : false,
							legend : {
								display : true,
								position : 'top',
								labels : {
									fontColor : "#000080",
								}
							},

							tooltips : {
								callbacks : {
									label : function(tooltipItem, data) {
										var dataset = data.datasets[tooltipItem.datasetIndex];
										var total = dataset.data
												.reduce(function(previousValue,
														currentValue,
														currentIndex, array) {
													return previousValue
															+ currentValue;
												});
										var currentValue = dataset.data[tooltipItem.index];
										var precentage = Math
												.floor(((currentValue / total) * 100) + 0.5);
										return precentage + "%";
									}
								}
							}

						};

						var sent = $("#sent").val();
						var received = $("#received").val();

						var data = {
							labels : [ "Sent Notifications (" + sent + ")",
									"Received Notifications (" + received + ")" ],
							datasets : [ {
								fill : true,
								backgroundColor : [ 'rgba(95,174,89,0.7)',
										'rgba(169, 3, 41, 0.7)' ],
								data : [ sent, received ],
								borderColor : [ 'rgba(95,174,89,1)',
										'rgba(169, 3, 41, 1)' ],
								borderWidth : [ 1, 1 ]
							} ]
						};
						var ctx = document.getElementById("pieChart")
								.getContext("2d");
						var myNewChart = new Chart(ctx, {
							type : 'pie',
							data : data,
							options : pieOptions
						});
					});

	function updateReportPanel() {
		var selectedClient = $("#clientId").val();
		var selectedSite = $("#siteId").val();
		var selectedEmp = $("#userId").val();
		var selectedStartDate = $("#startDate").val();
		var selectedEndDate = $("#endDate").val();
		if (selectedStartDate == "" || selectedEndDate == "") {
			alert("!! Please Select Date !!");
		} else {

			$('#reportPanel')
					.html(
							'<div style="width: 100%;height: 285px;text-align: center;vertical-align: middle;font-size: 17px;padding-top: 76px;"><img src="${images}/qqq.png" style="height: 84px;"><br>Please wait ...</div>');

			$.ajax({
				type : "GET",
				url : "updateReportPanel?clientid=" + selectedClient
						+ "&siteId=" + selectedSite + "&empId=" + selectedEmp
						+ "&startDate=" + selectedStartDate + "&endDate="
						+ selectedEndDate,
				success : function(response) {
					$('#reportPanel').html(response);
				},
				error : function(e) {
					console.log('Error: ' + e);
				}
			});
		}
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
		$("#date").datepicker({
			defaultDate : new Date()
		});
	});

	function updateDetails() {
		var userId = $("#userId").val();
		window.location.href = "report?userId=" + userId;
	}

	function updateSite(clientId) {
		$.ajax({
			type : "GET",
			url : "updateSiteReportDropdown?clientId=" + clientId,
			success : function(response) {
				$('#siteSection').html(response);
				updateEmployee(0);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function updateEmployee(siteId) {
		$.ajax({
			type : "GET",
			url : "updateEmpReportDropdown?siteId=" + siteId,
			success : function(response) {
				$('#employeeSection').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}
</script>