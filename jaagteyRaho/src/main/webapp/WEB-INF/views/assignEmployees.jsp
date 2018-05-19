<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="images" value="/resources/shopping/img" />
<div style="text-align: center; font-size: 19px; padding: 2px 0 9px 0;">
	Site - <span style="color: #389c0d;">${selectedSite.siteName}</span><input
		type="hidden" id="selectedSiteId" value="${selectedSite.id}" />
</div>
<c:if test="${not empty msg1}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-success"
			style="z-index: 11; width: 86%; text-align: center; margin: auto; margin-bottom: 12px;">${msg1}</div>
	</div>
</c:if>
<c:if test="${not empty errorMsg1}">
	<div class="card card-login mx-auto mt-5">
		<div class="alert alert-danger"
			style="z-index: 11; width: 86%; text-align: center; margin: auto; margin-bottom: 12px;">${errorMsg1}</div>
	</div>
</c:if>
<div class="row">
	<article
		class="col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
		<div
			class="jarviswidget jarviswidget-color-blueDark jarviswidget-sortable"
			id="wid-id-1" data-widget-editbutton="false"
			data-widget-fullscreenbutton="false" role="widget">
			<header role="heading">
				<h2>Employee Assign</h2>
			</header>
			<div role="content" style="border-top: 1px solid #ccc;">
				<div class="widget-body no-padding">
					<div id="dt_basic_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<table id="dt_basic"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							width="100%" role="grid" aria-describedby="dt_basic_info"
							style="width: 100%;">
							<thead>
								<tr role="row">
									<th>Sr</th>
									<th>Emp Code</th>
									<th>Name</th>
									<th>Contact No</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employees}" var="emp">
									<c:set var="i" value="${i+1}" scope="page" />
									<tr role="row">
										<td class="sorting_1">${i}</td>
										<td>${emp.empId}</td>
										<td>${emp.firstName}<c:if
												test="${not empty emp.middleName}">&nbsp;${emp.middleName}</c:if>
											${emp.lastName}
										</td>
										<td>${emp.contactNumber}</td>
										<td>${emp.email}</td>
										<td><a class="text-primary"
											onclick="assignEmployee('${emp.id}');"
											style="cursor: pointer; border-bottom: 1px solid #3276b1;">ASSIGN</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div
			class="jarviswidget jarviswidget-color-blueDark jarviswidget-sortable"
			id="wid-id-1" data-widget-editbutton="false"
			data-widget-fullscreenbutton="false" role="widget">
			<header role="heading">
				<h2>Employee Assigned</h2>
			</header>
			<div role="content" style="border-top: 1px solid #ccc;">
				<div class="widget-body no-padding">
					<div id="dt_basic_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<table id="dt_basic1"
							class="table table-striped table-bordered table-hover dataTable no-footer"
							width="100%" role="grid" aria-describedby="dt_basic_info"
							style="width: 100%;">
							<thead>
								<tr role="row">
									<th>Sr</th>
									<th>Emp Code</th>
									<th>Name</th>
									<th>Contact No</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employeeMappings}" var="em">
									<c:set var="i" value="${i+1}" scope="page" />
									<tr role="row">
										<td class="sorting_1">${i}</td>
										<td>${em.employee.empId}</td>
										<td>${em.employee.firstName}<c:if
												test="${not empty em.employee.middleName}">&nbsp;${em.employee.middleName}</c:if>
											${em.employee.lastName}
										</td>
										<td>${em.employee.contactNumber}</td>
										<td>${em.employee.email}</td>
										<td><a class="text-primary"
											onclick="revokeEmployee('${em.id}');"
											style="cursor: pointer; border-bottom: 1px solid #3276b1;">REVOKE</a></td>
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
<script>
	$(document).ready(function() {
		pageSetUp();
		$alert = $('.alert');
		if ($alert.length) {
			setTimeout(function() {
				$alert.fadeOut('slow');
			}, 3000);
		}
		$('#dt_basic').dataTable({
			"autoWidth" : true,
			"pageLength" : 5
		});
		$('#dt_basic1').dataTable({
			"autoWidth" : true,
			"pageLength" : 5
		});
	});

	function assignEmployee(empId) {
		var selectedSiteId = $("#selectedSiteId").val();
		$('#assigEmployees')
				.html(
						'<div style="text-align: center; padding-top: 142px;"><img src="${images}/qqq.png" style="height: 84px;"><br>Please wait ...</div>');
		$.ajax({
			type : "GET",
			url : "assignEmp?selectedSiteId=" + selectedSiteId + "&empId="
					+ empId,
			success : function(response) {
				$('#assigEmployees').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}

	function revokeEmployee(siteMappingId) {
		var selectedSiteId = $("#selectedSiteId").val();
		$('#assigEmployees')
				.html(
						'<div style="text-align: center; padding-top: 142px;"><img src="${images}/qqq.png" style="height: 84px;"><br>Please wait ...</div>');
		$.ajax({
			type : "GET",
			url : "revokeEmp?siteMappingId=" + siteMappingId,
			success : function(response) {
				$('#assigEmployees').html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}
</script>