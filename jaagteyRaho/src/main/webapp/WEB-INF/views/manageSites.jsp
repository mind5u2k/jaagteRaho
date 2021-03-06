<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">MANAGE SITES</li>
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
			<div class="row" style="padding: 13px 0 17px 0px;">
				<div class="col-sm-6">
					<button class="btn btn-primary" id="dialog_link">Add Site</button>
				</div>
				<div class="col-sm-6" style="text-align: right;">
					<a class="btn btn-default"
						href="${contextRoot}/admin/downloadExcelSite" target="_blank">
						<i class="fa fa-file-excel-o"></i> &nbsp;Download Excel
					</a> <a class="btn btn-default"
						href="${contextRoot}/admin/downloadPdfSite" target="_blank"> <i
						class="fa fa-file-pdf-o"></i> &nbsp;Download Pdf
					</a> <a class="btn btn-default"
						href="${contextRoot}/admin/downloadCSVSite" target="_blank"> <i
						class="fa fa-file-pdf-o"></i> &nbsp;Download CSV
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
												<th style="width: 40px;">Sr.</th>
												<th>Site Code</th>
												<th>Site Name</th>
												<th>Client</th>
												<th>Contact Person</th>
												<th>Contact No</th>
												<th>Email</th>
												<th>Address</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${sites}" var="s">
												<c:set var="i" value="${i+1}" scope="page" />
												<tr role="row">
													<td class="sorting_1">${i}</td>
													<td>${s.siteCode}</td>
													<td>${s.siteName}</td>
													<td>${s.client.clientName}</td>
													<td>${s.contactPerson}</td>
													<td>${s.contactNo}</td>
													<td>${s.emailId}</td>
													<td>${s.address}</td>
													<td><a class="text-primary"
														onclick="assignEmployee('${s.id}');"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">ASSIGN</a>
														|| <a class="text-primary" onclick="editSite('${s.id}');"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">UPDATE</a>
														|| <a class="text-primary"
														onclick="assignContactPerson('${s.id}');"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">ASSIGN
															CONTACT</a> || <a class="text-primary"
														onclick="deleteSite('${s.id}');"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">DELETE</a></td>
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
	<div id="dialog_simple" title="Add New Site">
		<div>
			<sf:form action="${contextRoot}/ad/addNewSite" modelAttribute="site"
				id="site" cssClass="smart-form" method="post">
				<fieldset>
					<div class="row">
						<section class="col col-4">
							<label class="label">Site Code<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-user"></i> <sf:input
									type="text" path="siteCode" placeholder="" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Site Name<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-user"></i> <sf:input
									type="text" path="siteName" placeholder="" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Client<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="select"> <sf:select path="client.id"
									items="${clients}" itemLabel="clientName" itemValue="id" /> <i></i>
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-4">
							<label class="label">Contact Person<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-user"></i> <sf:input
									type="text" path="contactPerson" placeholder="" />
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
							<label class="label">Email<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-envelope-o"></i>
								<sf:input type="email" path="emailId" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">Address<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <sf:input type="text" path="address"
									placeholder="" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">Employee </label> <label class="select">
								<sf:select path="user.id">
									<sf:option value="0">Select Employee</sf:option>
									<sf:options items="${employees}" itemLabel="firstName"
										itemValue="id" />
								</sf:select> <i></i>
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
	<div id="editSiteDialog" title="Edit Site">
		<div id="siteDetails">
			<div style="text-align: center; padding-top: 95px;">
				<img src="${images}/qqq.png" style="height: 84px;"><br>
				Please wait ...
			</div>
		</div>
	</div>

	<div id="assignEmployeeDialog" title="Map Employee">
		<div id="assigEmployees">
			<div style="text-align: center; padding-top: 142px;">
				<img src="${images}/qqq.png" style="height: 84px;"><br>
				Please wait ...
			</div>
		</div>
	</div>

	<div id="assignContactDialog" title="Map Contact">
		<div id="assignContacts">
			<div style="text-align: center; padding-top: 142px;">
				<img src="${images}/qqq.png" style="height: 84px;"><br>
				Please wait ...
			</div>
		</div>
	</div>

	<div class="modal fade" id="deleteSiteModel" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="deleteSiteModelContent"
				style="text-align: center; font-size: 17px; padding: 40px;">
				Once you delete the Site ,Site will be deleted permanently.<br>Are
				you sure ?<br> <br> <input type="hidden"
					id="deletedSiteId" value="" />
				<button class="btn btn-default av" type="button"
					data-dismiss="modal" aria-label="Close">Close</button>
				<button class="btn btn-danger" onclick="deletePermanent();">Delete</button>
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
							height : 370,
							resizable : false,
							modal : true
						});
						$('#editSiteDialog').dialog({
							autoOpen : false,
							width : 850,
							height : 370,
							resizable : false,
							modal : true
						});
						$('#assignEmployeeDialog').dialog({
							autoOpen : false,
							width : 850,
							height : 450,
							resizable : false,
							modal : true
						});
						$('#assignContactDialog').dialog({
							autoOpen : false,
							width : 850,
							height : 450,
							resizable : false,
							modal : true
						});
					});

	function editSite(siteId) {
		$('#editSiteDialog').dialog('open');
		$.ajax({
			type : "GET",
			url : "editSite?siteId=" + siteId,
			success : function(response) {
				$('#siteDetails').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function assignEmployee(siteId) {
		$('#assignEmployeeDialog').dialog('open');
		$.ajax({
			type : "GET",
			url : "assignEmployees?siteId=" + siteId,
			success : function(response) {
				$('#assigEmployees').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function assignContactPerson(siteId) {
		$('#assignContactDialog').dialog('open');
		$.ajax({
			type : "GET",
			url : "assignContactperson?siteId=" + siteId,
			success : function(response) {
				$('#assignContacts').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function deleteSite(siteId) {
		$("#deletedSiteId").val(siteId);
		$('#deleteSiteModel').modal({
			show : true
		});
	}

	function deletePermanent() {
		var deletedSiteId = $("#deletedSiteId").val();
		window.location.href = "deleteSite/" + deletedSiteId;
	}

	$(function() {
		$("#dob").datepicker({
			minDate : 0
		});
	});
</script>