<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li style="font-size: 16px;" class="text-primary">MANAGE
			CHECKLIST</li>
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
					<form id="checklist" action="${contextRoot}/ad/manageChecklist"
						class="smart-form" method="get">
						<fieldset style="padding-top: 0;">
							<div class="row">
								<section class="col col-4">
									<label class="label">Add Checklist<span
										style="color: #f00; padding-left: 4px;">*</span></label> <label
										class="input"> <input type="text" name="checklist"
										placeholder="" />
									</label>
								</section>
								<section class="col col-2">
									<label class="label">&nbsp;</label> <label class="input">
										<input type="submit" value="Submit"
										style="width: 93px; border-radius: 2px; border: 1px solid #073760;"
										class="btn btn-primary">
									</label>
								</section>
							</div>
						</fieldset>
					</form>
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
	
</script>