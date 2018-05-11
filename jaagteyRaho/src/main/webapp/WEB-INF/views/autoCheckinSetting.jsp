<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">AUTO CHECKIN
			SETTING</li>
	</ol>
</div>
<c:if test="${not empty msg}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-success"
			style="margin-bottom: 14px; position: fixed; z-index: 11; width: 31%; top: 10%; left: 42%; text-align: center;">${msg}</div>
	</div>
</c:if>
<c:if test="${not empty errorMsg}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-danger"
			style="margin-bottom: 14px; position: fixed; z-index: 11; width: 31%; top: 10%; left: 42%; text-align: center;">${errorMsg}</div>
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
			<div class="row" style="padding: 13px 0 17px 0px;">
				<div class="col-sm-12">
					<sf:form action="${contextRoot}/ad/updateAutoCheckin"
						modelAttribute="autoCheckinSetting" id="autoCheckinSettingForm"
						cssClass="smart-form" method="post">
						<fieldset>
							<div class="row">
								<section class="col col-2">
									<label class="label">Geo Radius<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="input"> <sf:input type="text" path="geoRadius"
											placeholder="" />
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Reminder Int. Time<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="reminderIntTime"
											items="${intervalTimes}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">AutoCheckins Int. Time<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="autoCheckinIntTime"
											items="${intervalTimes}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Start Time<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="startTime"
											items="${times}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">End Time<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="endTime"
											items="${times}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">&nbsp;</label> <label class="input">
										<sf:hidden path="id" /> <input type="submit" value="Submit"
										class="btn btn-primary"
										style="width: 93px; border-radius: 2px; border: 1px solid #073760;" />
									</label>
								</section>
							</div>
						</fieldset>
					</sf:form>
				</div>
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

	function createDesignation() {

	}
</script>