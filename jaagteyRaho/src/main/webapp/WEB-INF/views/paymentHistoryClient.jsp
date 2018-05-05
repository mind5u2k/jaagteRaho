<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id="ribbon">
	<ol class="breadcrumb">
		<li>Home</li>
	</ol>
</div>
<div id="content">
	<div class="row">
		<article
			class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
			<div class="jarviswidget   jarviswidget-sortable" id="wid-id-1"
				data-widget-editbutton="false" role="widget">

				<header role="heading">
					<span class="widget-icon"> <i class="fa fa-table"></i>
					</span>
					<h2>Payment History</h2>
					<div class="widget-toolbar" role="menu">
						<div class="btn-group">
							<button class="btn dropdown-toggle btn-xs btn-success"
								data-toggle="dropdown" aria-expanded="true">
								Select Product <i class="fa fa-caret-down"></i>
							</button>
							<ul class="dropdown-menu pull-right js-status-update">
								<c:forEach items="${assignedProducts}" var="ap">
									<li><a
										href="${contextRoot}/cl/paymentHistory?assignedProductId=${ap.id}"><i
											class="fa fa-circle txt-color-green"></i>
											${ap.product.productName}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</header>
				<div role="content">
					<div class="widget-body no-padding">
						<c:if test="${not empty failure}">
							<div class="card card-login mx-auto mt-5">
								<div class="alert alert-danger" style="margin-bottom: 14px;">${failure}</div>
							</div>
						</c:if>
						<c:if test="${not empty success}">
							<div class="card card-login mx-auto mt-5">
								<div class="alert alert-success"
									style="position: fixed; top: 49px; z-index: 11111; width: 30%; left: 35%; text-align: center;">${success}</div>
							</div>
						</c:if>

						<h3 style="text-align: center; color: #00f; margin-bottom: 0;">
							<span style="font-size: 22px; color: #000;">Product</span> :
							${assignedProduct.product.productName}
						</h3>
						<div id="datatable_fixed_column_wrapper"
							class="dataTables_wrapper form-inline no-footer">
							<table id="datatable_fixed_column"
								class="table table-striped table-bordered dataTable no-footer"
								width="100%" role="grid"
								aria-describedby="datatable_fixed_column_info"
								style="width: 100%;">
								<thead>
									<tr role="row">
										<th class="hasinput" style="" rowspan="1" colspan="1"><input
											type="text" class="form-control" placeholder="Filter Name"></th>
										<th class="hasinput" style="" rowspan="1" colspan="1"><input
											class="form-control" placeholder="Filter Email ID"
											type="text"></th>
										<th class="hasinput" style="" rowspan="1" colspan="1"><input
											type="text" class="form-control"
											placeholder="Filter Contact No"></th>
										<th class="hasinput" rowspan="1" colspan="1"><input
											id="dateselect_filter" type="text" placeholder="Filter Role"
											class="form-control "></th>
										<th class="hasinput  " rowspan="1" colspan="1"><input
											id="dateselect_filter" type="text" placeholder="Filter Role"
											class="form-control "></th>
										<th class="hasinput" style="" rowspan="1" colspan="1"></th>
									</tr>
									<tr role="row">
										<th>Payment Date</th>
										<th>Amount</th>
										<th>Payment Method</th>
										<th>Transaction ID</th>
										<th>Payment Duration</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${billDetails}" var="bd">
										<c:set var="i" value="${i+1}" scope="page" />
										<tr role="row" class="odd">
											<td>${bd.paymentDateStringFormat}</td>
											<td>${bd.totalPrice}</td>
											<td>${bd.paymentMethod}</td>
											<td>${bd.billId}</td>
											<td>${bd.paymentDuration}</td>
											<td class="btn btn-default"
												style="text-align: center; width: 43px; font-size: 16px; padding: 6px 0 6px 0;"
												onclick="window.location.href='${contextRoot}/downloadBill'"><i
												class="fa fa-file-pdf-o"></i></td>
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

<div class="modal fade" id="newUserModel" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="newUserBody">
			<sf:form action="${contextRoot}/sr/saveAssignedProduct"
				modelAttribute="assignedProduct" id="checkout-form"
				cssClass="smart-form" method="post">
				<header
					style="background: #ccc; margin: 0; padding: 10px 16px 10px 16px;">
					Assign Product</header>
				<fieldset>
					<div class="row">
						<section class="col col-sm-12">
							<label class="label">Select Client</label> <label class="select">
								<sf:select path="client.id">
									<option value="0" disabled="disabled" selected="selected">
										Client</option>
									<sf:options items="${clients}" itemLabel="firstName"
										itemValue="id" />
								</sf:select> <i></i>
							</label>
							<%-- <label class="select"> <sf:select path="client.id">
									<option value="0" disabled="disabled" selected="selected">
										Client</option>
									<sf:options items="${clients}" itemLabel="firstName"
										itemValue="id" />
								</sf:select>
							</label> --%>
						</section>
					</div>
					<div class="row">
						<section class="col col-sm-12">
							<label class="label">Select Product</label> <label class="select">
								<i class="icon-append fa fa-user"></i> <sf:select
									path="product.id">
									<option value="0" disabled="disabled" selected="selected">Product</option>
									<sf:options items="${products}" itemLabel="productName"
										itemValue="id" />
								</sf:select>
							</label>
						</section>
					</div>

					<div class="row">
						<section class="col col-6">
							<label class="label">Status</label> <label class="input">
								<i class="icon-append fa fa-tag"></i> <sf:input type="text"
									path="status" placeholder="Status" disabled="true" />
							</label>
						</section>
						<section class="col col-6">
							<label class="label">Trial Period</label> <label class="input">
								<i class="icon-append fa fa-sliders"></i> <sf:input
									type="number" path="trialPeriod" placeholder="Trial Period" />
							</label>
						</section>
					</div>
				</fieldset>

				<footer>
					<sf:hidden path="id" />
					<button type="submit" class="btn btn-primary">Assign &
						Start trial</button>
				</footer>
			</sf:form>
		</div>
	</div>
</div>

<script src="${js}/plugin/datatables/jquery.dataTables.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.colVis.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.tableTools.min.js"></script>
<script src="${js}/plugin/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var responsiveHelper_dt_basic = undefined;
						var responsiveHelper_datatable_fixed_column = undefined;
						var responsiveHelper_datatable_col_reorder = undefined;
						var responsiveHelper_datatable_tabletools = undefined;

						var breakpointDefinition = {
							tablet : 1024,
							phone : 480
						};

						var otable = $('#datatable_fixed_column')
								.DataTable(
										{
											"sDom" : "<'dt-toolbar'<'col-xs-12 col-sm-6 hidden-xs'f><'col-sm-6 col-xs-12 hidden-xs'<'toolbar'>>r>"
													+ "t"
													+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
											"autoWidth" : true,
										});
						$("#datatable_fixed_column thead th input[type=text]")
								.on(
										'keyup change',
										function() {

											otable.column(
													$(this).parent().index()
															+ ':visible')
													.search(this.value).draw();

										});
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

	function addNewUserModel() {
		$('#newUserModel').modal({
			show : true
		});
	}
</script>