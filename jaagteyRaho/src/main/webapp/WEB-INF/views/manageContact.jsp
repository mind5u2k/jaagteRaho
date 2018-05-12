<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">MANAGE CONTACT</li>
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
				<div class="col-sm-6">
					<button class="btn btn-primary" id="dialog_link">Add
						Contact</button>
				</div>
				<div class="col-sm-6" style="text-align: right;">
					<button class="btn btn-default">
						<i class="fa fa-file-excel-o"></i> &nbsp;Download Excel
					</button>
					<button class="btn btn-default">
						<i class="fa fa-file-pdf-o"></i> &nbsp;Download Pdf
					</button>
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
												<th data-hide="phone" class="sorting_asc" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1" aria-sort="ascending"
													aria-label="ID: activate to sort column ascending"
													style="width: 40px;">Sr.</th>
												<th data-class="expand" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Name: activate to sort column ascending"
													style="width: 96px;">Contact Person</th>
												<th class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Phone: activate to sort column ascending"
													style="width: 152px;">Contact No</th>

												<th data-hide="phone,tablet" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Zip: activate to sort column ascending"
													style="width: 104px;">Alternate Contact No</th>
												<th data-hide="phone,tablet" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="City: activate to sort column ascending"
													style="width: 213px;">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${contactPersons}" var="cp">
												<c:set var="i" value="${i+1}" scope="page" />
												<tr role="row">
													<td class="sorting_1">${i}</td>
													<td><span class="responsiveExpander"></span>${cp.name}</td>
													<td><span class="responsiveExpander"></span>${cp.contactNo}</td>
													<td><span class="responsiveExpander"></span>${cp.alternateNo}</td>
													<td><a class="text-primary"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;"
														onclick="editContactPerson('${cp.id}');">Edit</a> | <a
														class="text-primary"
														href="${contextRoot}/ad/deleteContactPerson?contactPersonId=${cp.id}"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">Delete</a></td>
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
<div id="dialog_simple" title="Add New Contact">
	<div>
		<sf:form action="${contextRoot}/ad/addNewContact"
			modelAttribute="contactPerson" id="contactPersonForm"
			cssClass="smart-form" method="post">
			<fieldset>
				<div class="row">
					<section class="col col-4">
						<label class="label">Contact Person Name<span
							style="color: #f00; padding-left: 4px;">*</span></label> <label
							class="input"> <i class="icon-append fa fa-user"></i> <sf:input
								type="text" path="name" placeholder="" />
						</label>
					</section>
					<section class="col col-4">
						<label class="label">Contact No.<span
							style="color: #f00; padding-left: 4px;">*</span></label> <label
							class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
								type="text" path="contactNo" placeholder=""
								data-mask="9999999999" />
						</label>
					</section>
					<section class="col col-4">
						<label class="label">Alternate Contact No.</label> <label
							class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
								type="text" path="alternateNo" placeholder=""
								data-mask="9999999999" />
						</label>
					</section>
				</div>
				<div class="row">
					<section class="col col-12" style="float: right;">
						<label class="input"> <sf:hidden path="id" />
							<button type="submit" name="submit" class="btn btn-primary"
								style="padding: 7px 10px 7px 10px; margin-top: 18px;">
								Submit</button>
						</label>
					</section>
				</div>
			</fieldset>
		</sf:form>
	</div>
</div>
<div id="editContactPerson" title="Edit Contact Person">
	<div id="editPersonDiv">
		<div style="text-align: center; padding-top: 41px;">
			<img src="${images}/qqq.png" style="height: 84px;"><br>
			Please wait ...
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

						$('#dialog_link').click(function() {
							$('#dialog_simple').dialog('open');
							return false;

						});

						$('#dialog_simple').dialog({
							autoOpen : false,
							width : 850,
							height : 250,
							resizable : false,
							modal : true
						});
						$('#editContactPerson').dialog({
							autoOpen : false,
							width : 850,
							height : 250,
							resizable : false,
							modal : true
						});

					});

	function editContactPerson(contactPersonId) {
		$('#editContactPerson').dialog('open');
		$.ajax({
			type : "GET",
			url : "editContactPerson?contactPersonId=" + contactPersonId,
			success : function(response) {
				$('#editPersonDiv').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	$(function() {
		$("#dob").datepicker({
			minDate : 0
		});
	});
</script>