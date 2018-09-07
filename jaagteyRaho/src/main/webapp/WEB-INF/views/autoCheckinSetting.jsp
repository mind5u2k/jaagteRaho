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
<div id="content" style="display: none; padding-top: 0;">
	<div class="row">
		<div class="col-sm-12">
			<div class="row" style="padding: 0 0 17px 0px;">
				<div class="col-sm-12">
					<sf:form action="${contextRoot}/ad/addAutoCheckin"
						modelAttribute="autoCheckinSetting" id="autoCheckinSettingForm"
						cssClass="smart-form" method="post">
						<fieldset>
							<div class="row">
								<section class="col col-3">
									<label class="label">Client<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="client.id"
											onchange="updateEmployee(this.value);">
											<sf:option value="0" disabled="true">Select Client</sf:option>
											<sf:options itemValue="id" items="${allClients}"
												itemLabel="clientName" />
										</sf:select> <i></i>
									</label>
								</section>
								<section class="col col-3" id="employeeSection">
									<label class="label">Employee<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="employee.id">
											<sf:option value="0" disabled="true">Select Employee</sf:option>
										</sf:select> <i></i>
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
									<label class="label">Notification Priority<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="pushNotification"
											onchange="updateNotification();" id="pushNotification"
											items="${priorities}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Message Priority<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="msg" id="msg"
											onchange="updateMsg();" items="${priorities}" /> <i></i>
									</label>
								</section>
								<section class="col col-2">
									<label class="label">Call Priority<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="select"> <sf:select path="calls" id="calls"
											onchange="updateCall();" items="${priorities}" /> <i></i>
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
												<th data-hide="phone" style="width: 40px;">Sr.</th>
												<th>Employee</th>
												<th>AutoCheckins Int. Time</th>
												<th>Start Time</th>
												<th>End Time</th>
												<th>Noti Priority</th>
												<th>Msg Priority</th>
												<th>Call Priority</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${autoCheckinSettings}" var="a">
												<c:set var="i" value="${i+1}" scope="page" />
												<tr role="row">
													<td class="sorting_1">${i}</td>
													<td>${a.employee.firstName}<c:if
															test="${not empty a.employee.middleName}">&nbsp;${a.employee.middleName}</c:if>
														${a.employee.lastName}
													</td>
													<td>${a.autoCheckinIntTime}</td>
													<td>${a.startTime}</td>
													<td>${a.endTime}</td>
													<td>${a.pushNotification}</td>
													<td>${a.msg}</td>
													<td>${a.calls}</td>
													<td><a class="text-primary"
														onclick="deleteAutoCheckinSetting('${a.id}');"
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
	<div class="modal fade" id="deleteAutoCheckinModel" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="deleteSiteModelContent"
				style="text-align: center; font-size: 17px; padding: 40px;">
				Once you delete the AutoCheckins Int. Time ?<br>Are you sure ?<br>
				<br> <input type="hidden" id="deleteAutoCheckinId" value="" />
				<button class="btn btn-default av" type="button"
					data-dismiss="modal" aria-label="Close">Close</button>
				<button class="btn btn-danger" onclick="deletePermanent();">Delete</button>
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

	function updateEmployee(clientId) {
		$.ajax({
			type : "GET",
			url : "updateEmpDropdown?clientId=" + clientId,
			success : function(response) {
				$('#employeeSection').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function deleteAutoCheckinSetting(autoCheckinId) {
		$("#deleteAutoCheckinId").val(autoCheckinId);
		$('#deleteAutoCheckinModel').modal({
			show : true
		});
	}

	function deletePermanent() {
		var deleteAutoCheckinId = $("#deleteAutoCheckinId").val();
		window.location.href = "deleteAutoCheckinId/" + deleteAutoCheckinId;
	}

	function updateNotification() {
		var calls = $("#calls").val();
		var msg = $("#msg").val();
		var pushNotification = $("#pushNotification").val();
		if (pushNotification == 1) {
			if (msg == 1) {
				if (calls == 2) {
					$("#msg").val(3);
				} else if (calls == 3) {
					$("#msg").val(2);
				}
			} else if (calls == 1) {
				if (msg == 2) {
					$("#calls").val(3);
				} else if (msg == 3) {
					$("#calls").val(2);
				}
			}
		} else if (pushNotification == 2) {
			if (msg == 2) {
				if (calls == 1) {
					$("#msg").val(3);
				} else if (calls == 3) {
					$("#msg").val(1);
				}
			} else if (calls == 2) {
				if (msg == 1) {
					$("#calls").val(3);
				} else if (msg == 3) {
					$("#calls").val(1);
				}
			}
		} else if (pushNotification == 3) {
			if (msg == 3) {
				if (calls == 1) {
					$("#msg").val(2);
				} else if (calls == 2) {
					$("#msg").val(1);
				}
			} else if (calls == 3) {
				if (msg == 1) {
					$("#calls").val(2);
				} else if (msg == 2) {
					$("#calls").val(1);
				}
			}
		}
	}

	function updateMsg() {
		var calls = $("#calls").val();
		var msg = $("#msg").val();
		var pushNotification = $("#pushNotification").val();
		if (msg == 1) {
			if (pushNotification == 1) {
				if (calls == 2) {
					$("#pushNotification").val(3);
				} else if (calls == 3) {
					$("#pushNotification").val(2);
				}
			} else if (calls == 1) {
				if (pushNotification == 2) {
					$("#calls").val(3);
				} else if (pushNotification == 3) {
					$("#calls").val(2);
				}
			}
		} else if (msg == 2) {
			if (pushNotification == 2) {
				if (calls == 1) {
					$("#pushNotification").val(3);
				} else if (calls == 3) {
					$("#pushNotification").val(1);
				}
			} else if (calls == 2) {
				if (pushNotification == 1) {
					$("#calls").val(3);
				} else if (pushNotification == 3) {
					$("#calls").val(1);
				}
			}
		} else if (msg == 3) {
			if (pushNotification == 3) {
				if (calls == 1) {
					$("#pushNotification").val(2);
				} else if (calls == 2) {
					$("#pushNotification").val(1);
				}
			} else if (calls == 3) {
				if (pushNotification == 1) {
					$("#calls").val(2);
				} else if (pushNotification == 2) {
					$("#calls").val(1);
				}
			}
		}
	}

	function updateCall() {
		var calls = $("#calls").val();
		var pushNotification = $("#pushNotification").val();
		var msg = $("#msg").val();

		if (calls == 1) {
			if (pushNotification == 1) {
				if (msg == 2) {
					$("#pushNotification").val(3);
				} else if (msg == 3) {
					$("#pushNotification").val(2);
				}
			} else if (msg == 1) {
				if (pushNotification == 2) {
					$("#msg").val(3);
				} else if (pushNotification == 3) {
					$("#msg").val(2);
				}
			}
		} else if (calls == 2) {
			if (pushNotification == 2) {
				if (msg == 1) {
					$("#pushNotification").val(3);
				} else if (msg == 3) {
					$("#pushNotification").val(1);
				}
			} else if (msg == 2) {
				if (pushNotification == 1) {
					$("#msg").val(3);
				} else if (pushNotification == 3) {
					$("#msg").val(1);
				}
			}
		} else if (calls == 3) {
			if (pushNotification == 3) {
				if (msg == 1) {
					$("#pushNotification").val(2);
				} else if (msg == 2) {
					$("#pushNotification").val(1);
				}
			} else if (msg == 3) {
				if (pushNotification == 1) {
					$("#msg").val(2);
				} else if (pushNotification == 2) {
					$("#msg").val(1);
				}
			}
		}
	}
</script>