<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">ADD / EDIT
			EMPLOYEES</li>
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
						Employee</button>
				</div>
				<div class="col-sm-6" style="text-align: right;">
					<a class="btn btn-default" download="data_123.xls" href="#"
						id="anchorNewApi-xls" onclick="return newApi('xls');"> <i
						class="fa fa-file-excel-o"></i> &nbsp;Download Excel
					</a>
					<button class="btn btn-default" id="cmd">
						<i class="fa fa-file-pdf-o"></i> &nbsp;Download Pdf
					</button>
					<!-- <a download="data_123.xls" href="#" id="anchorNewApi-xls"
						onclick="return newApi('xls');">Export to Excel: XLS format</a> -->
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
													style="width: 96px;">Emp ID</th>
												<th class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Phone: activate to sort column ascending"
													style="width: 152px;">Name</th>

												<th data-hide="phone,tablet" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Zip: activate to sort column ascending"
													style="width: 104px;">Action</th>
												<th data-hide="phone,tablet" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="City: activate to sort column ascending"
													style="width: 213px;">Login Access</th>
												<th data-hide="phone,tablet" class="sorting" tabindex="0"
													aria-controls="datatable_col_reorder" rowspan="1"
													colspan="1"
													aria-label="Date: activate to sort column ascending"
													style="width: 90px;">Password Reset</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${users}" var="user">
												<c:set var="i" value="${i+1}" scope="page" />
												<tr role="row">
													<td class="sorting_1">${i}</td>
													<td><span class="responsiveExpander"></span>${user.empId}</td>
													<td>${user.firstName}<c:if
															test="${not empty user.middleName}">&nbsp;${user.middleName}</c:if>
														${user.lastName}
													</td>
													<td><a class="text-primary"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;"
														onclick="editUserDialog('${user.id}');">DETAILS</a></td>
													<td><a class="text-success"
														style="cursor: pointer; border-bottom: 1px solid #468847;">ACTIVE</a></td>
													<td><a class="text-primary"
														style="cursor: pointer; border-bottom: 1px solid #3276b1;">SEND
															LINK</a></td>
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
	<div id="dialog_simple" title="Add New Employee">
		<div>
			<sf:form action="${contextRoot}/ad/addNewEmployee"
				modelAttribute="user" id="checkout-form1" cssClass="smart-form"
				method="post">
				<fieldset>
					<div class="row">
						<section class="col col-4">
							<label class="label">Employee Code<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <sf:input type="text" path="empId"
									placeholder="" />
							</label>
						</section>
						<section class="col col-8">
							<label class="label">E-mail Address<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-envelope-o"></i>
								<sf:input type="email" path="email" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-4">
							<label class="label">First Name<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-user"></i> <sf:input
									type="text" path="firstName" placeholder="" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Middle Name</label> <label class="input">
								<i class="icon-append fa fa-user"></i> <sf:input type="text"
									path="middleName" placeholder="" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Last Name<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-user"></i> <sf:input
									type="text" path="lastName" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-4">
							<label class="label">DOB</label> <label class="input"> <i
								class="icon-append fa fa-calendar"></i> <sf:input type="text"
									path="dob" placeholder="Date of Birth" class="datepicker"
									data-dateformat="dd/mm/yy" id="dob" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Contact No<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <i class="icon-append fa fa-phone"></i> <sf:input
									type="text" path="contactNumber" placeholder=""
									data-mask="9999999999" />
							</label>
						</section>
						<section class="col col-4">
							<label class="label">Alternate No</label> <label class="input">
								<i class="icon-append fa fa-phone"></i> <sf:input type="text"
									path="alternateNumber" placeholder="" data-mask="9999999999" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">Gender</label>
							<div class="inline-group">
								<label class="radio"> <sf:radiobutton path="gender"
										value="Male" /> <i></i>Male
								</label> <label class="radio"> <sf:radiobutton path="gender"
										value="Female" /><i></i>Female
								</label>
							</div>
						</section>
						<section class="col col-6">
							<label class="label">Designation<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="select"> <sf:select path="designation.id"
									items="${designations}" itemLabel="designationName"
									itemValue="id" /> <i></i>
							</label>
						</section>
					</div>
				</fieldset>
				<fieldset>
					<div class="row">
						<section class="col col-6">
							<label class="label"
								style="border-bottom: 1px solid #ccc; padding-bottom: 7px;">Correspondence
								Address</label>
						</section>
						<section class="col col-6">
							<label class="label"
								style="border-bottom: 1px solid #ccc; padding-bottom: 7px;">Permanent
								Address</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">Address<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="textarea"> <sf:textarea
									path="corredpondenceAddress" rows="3" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">Address</label> <label class="textarea">
								<sf:textarea path="permanentAddress" rows="3" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">Pin Code<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <sf:input type="text"
									path="corredpondencePostalCode" placeholder="" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">Pin Code</label> <label class="input">
								<sf:input type="text" path="permanentPostalCode" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">State<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <sf:input type="text"
									path="corredpondenceState" placeholder="" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">State</label> <label class="input">
								<sf:input type="text" path="permanentState" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="label">City<span
								style="color: #f00; padding-left: 4px;">*</span></label> <label
								class="input"> <sf:input type="text"
									path="corredpondenceCity" placeholder="" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">City</label> <label class="input"> <sf:input
									type="text" path="permanentCity" placeholder="" />
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-12" style="float: right;">
							<label class="input">
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
	<div id="editUserDialog" title="Edit Employee">
		<div id="userDetails">
			<div style="text-align: center; padding-top: 95px;">
				<img src="${images}/qqq.png" style="height: 84px;"><br>
				Please wait ...
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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.debug.js"></script>
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
							height : 400,
							resizable : false,
							modal : true
						});
						$('#editUserDialog').dialog({
							autoOpen : false,
							width : 850,
							height : 400,
							resizable : false,
							modal : true
						});

						var doc = new jsPDF();
						var specialElementHandlers = {
							'#editor' : function(element, renderer) {
								return true;
							}
						};

						$('#cmd')
								.click(
										function() {
											doc
													.fromHTML(
															$(
																	'#datatable_col_reorder')
																	.html(),
															15,
															15,
															{
																'width' : 170,
																'elementHandlers' : specialElementHandlers
															});
											doc.save('sample-file.pdf');
										});
						var doc = new jsPDF();
						var specialElementHandlers = {
							'#editor' : function(element, renderer) {
								return true;
							}
						};
					});

	function editUserDialog(userId) {
		$('#editUserDialog').dialog('open');
		$.ajax({
			type : "GET",
			url : "editUser?userId=" + userId,
			success : function(response) {
				$('#editUserDialog').html(response);
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
<script>
	function newApi(format) {
		return ExcellentExport.convert({
			anchor : 'anchorNewApi-' + format,
			filename : 'data_123.' + format,
			format : format
		}, [ {
			name : 'Sheet Name Here 1',
			from : {
				table : 'datatable_col_reorder'
			}
		} ]);
	}

	function newApiArray(format) {
		return ExcellentExport.convert({
			anchor : 'anchorNewApi-' + format + '-array',
			filename : 'data_123.array',
			format : format
		}, [ {
			name : 'Sheet Name Here 1',
			from : {
				array : [ [ 'line 1', 1234, 'asadasd' ],
						[ 'line 2', 1234.56, 'asd' ] ]
			}
		} ]);
	}
</script>