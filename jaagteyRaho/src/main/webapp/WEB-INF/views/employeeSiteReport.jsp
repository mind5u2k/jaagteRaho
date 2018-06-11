<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">EMPLOYEE-SITE
			REPORT</li>
	</ol>
</div>
<div id="before"
	style="width: 100%; height: 600px; text-align: center; vertical-align: middle; font-size: 17px; padding-top: 194px;">
	<img src="${images}/qqq.png" style="height: 84px;"><br>
	Please wait ...
</div>
<div id="content" style="display: none;">
	<div class="row">
		<div class="col-sm-12">
			<div class="row" style="padding: 13px 0 17px 0px;">
				<div class="col-sm-12" style="text-align: right;">
					<a class="btn btn-default"
						href="${contextRoot}/admin/downloadExcelEmployeeSite"
						target="_blank"> <i class="fa fa-file-excel-o"></i>
						&nbsp;Download Excel
					</a> <a class="btn btn-default"
						href="${contextRoot}/admin/downloadPdfEmployeeSite"
						target="_blank"> <i class="fa fa-file-pdf-o"></i>
						&nbsp;Download Pdf
					</a> <a class="btn btn-default"
						href="${contextRoot}/admin/downloadCSVEmployeeSite"
						target="_blank"> <i class="fa fa-file-pdf-o"></i>
						&nbsp;Download CSV
					</a>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="row">
				<article
					class="col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
					<div class="jarviswidget   jarviswidget-sortable" id="wid-id-1"
						data-widget-editbutton="false"
						data-widget-fullscreenbutton="false" role="widget">
						<div role="content" style="border-top: 1px solid #ccc;">
							<div class="widget-body no-padding">
								<div id="datatable_col_reorder_wrapper"
									class="dataTables_wrapper form-inline no-footer">
									<table id="datatable_col_reorder"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										width="100%" role="grid"
										aria-describedby="datatable_col_reorder_info"
										style="width: 100%;">
										<thead>
											<tr role="row">
												<th>Sr.</th>
												<th>Site Code</th>
												<th>Site Name</th>
												<th>Site Address</th>
												<th>Assigned Employee</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${reports}" var="rp">
												<c:set var="i" value="${i+1}" scope="page" />
												<tr role="row">
													<td class="sorting_1">${i}</td>
													<td>${rp.site.siteCode}</td>
													<td>${rp.site.siteName}</td>
													<td>${rp.site.address}</td>
													<td><c:forEach items="${rp.mappings}" var="rm">${rm.employee.firstName}<c:if
																test="${not empty rm.employee.middleName}">&nbsp;${rm.employee.middleName}</c:if>
														${rm.employee.lastName} ,</c:forEach></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
.btn-primary {
	color: #fff !important;
	background-color: #3276b1 !important;
	border-color: #2c699d !important;
}

.btn-primary.active, .btn-primary.focus, .btn-primary:active,
	.btn-primary:focus, .btn-primary:hover, .open>.dropdown-toggle.btn-primary
	{
	color: #fff !important;
	background-color: #275b89 !important;
	border-color: #1f496d !important;
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

					});
</script>