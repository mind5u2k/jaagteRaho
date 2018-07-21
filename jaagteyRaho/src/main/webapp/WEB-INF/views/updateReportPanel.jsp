<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<input type="hidden" id="sent" value="${sent}">
<input type="hidden" id="received" value="${received}">
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
									href="${contextRoot}/admin/downloadReports?clientid=${clientid}&siteId=${siteId}&empId=${empId}&date=${date}"
									target="_blank"> <i class="fa fa-file-excel-o"></i>
									&nbsp;Download Excel
								</a>
							</div>
							<%-- <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 show-stats">
								<div
									style="margin: auto; text-align: center; font-size: 16px; padding: 12px 0px 14px 0px;">
									<span style="border-bottom: 1px solid #141313;">Chart
										Representation</span>
								</div>
								<div
									style="margin: auto; text-align: center; padding-bottom: 15px;">
									<canvas id="pieChart" height="50px"></canvas>
								</div>
							</div> --%>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
								style="border-right: 1px solid #ccc;">
								<table id="datatable_col_reorder11"
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
												<td>${cl.receivedStatus}</td>
												<td>${cl.receivedTimestamp}</td>
												<td>${cl.currentLocation}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<%-- <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 show-stats">
								<div
									style="margin: auto; text-align: center; font-size: 16px; padding: 12px 0px 14px 0px;">
									<span style="border-bottom: 1px solid #141313;">Chart
										Representation</span>
								</div>
								<div
									style="margin: auto; text-align: center; padding-bottom: 15px;">
									<canvas id="pieChart" height="250px"></canvas>
								</div>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</article>
</div>
<script>
	$(document)
			.ready(
					function() {
						pageSetUp();
						var responsiveHelper_dt_basic = undefined;
						var responsiveHelper_datatable_fixed_column = undefined;
						var responsiveHelper_datatable_col_reorder = undefined;
						var responsiveHelper_datatable_tabletools = undefined;

						$('#datatable_col_reorder11')
								.dataTable(
										{
											dom : 'Bfrtip',
											buttons : [ 'csv', 'excel', 'pdf' ],
											"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'C>r>"
													+ "t"
													+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
											"autoWidth" : true,
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
										return precentage + " %";
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
</script>