<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.onoffswitch {
	position: relative;
	width: 75px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	margin-top: 3px;
	margin-bottom: 3px;
	margin-left: 5px;
	display: inline-block;
	vertical-align: middle;
}

.onoffswitch-switch {
	width: 19px;
	height: 19px;
	margin: -2px;
	background: #fff;
	border: 1px solid #9a9a9a;
	border-radius: 50px;
	position: absolute;
	top: 0;
	bottom: 0;
	right: 61px;
	-webkit-box-sizing: content-box;
	-moz-box-sizing: content-box;
	box-sizing: content-box;
	background-color: #f4f4f4;
	background-image: -moz-linear-gradient(top, #fff, #eee);
	background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#fff),
		to(#eee));
	background-image: -webkit-linear-gradient(top, #fff, #eee);
	background-image: -o-linear-gradient(top, #fff, #eee);
	background-image: linear-gradient(to bottom, #fff, #eee);
	background-repeat: repeat-x;
	-webkit-box-shadow: 1px 1px 4px 0 rgba(0, 0, 0, .3);
	box-shadow: 1px 1px 4px 0 rgba(0, 0, 0, .3);
}
</style>
<div id="ribbon">
	<ol class="breadcrumb">
		<li>Products</li>
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
					<h2>All Products</h2>
					<security:authorize access="hasAuthority('ADMIN')">
						<button class="btn btn-primary" style="float: right;"
							onclick="addNewUserModel();">Add Product</button>
					</security:authorize>

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
						<div id="datatable_fixed_column_wrapper"
							class="dataTables_wrapper form-inline no-footer">
							<table id="datatable_fixed_column"
								class="table table-striped table-bordered dataTable no-footer"
								width="100%" role="grid"
								aria-describedby="datatable_fixed_column_info"
								style="width: 100%;">
								<thead>
									<tr role="row">
										<th data-class="expand" class="sorting_asc" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1" aria-sort="ascending"
											aria-label="Name: activate to sort column ascending" style="">ID</th>
										<th data-class="expand" class="sorting_asc" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1" aria-sort="ascending"
											aria-label="Name: activate to sort column ascending" style="">Product
											Name</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="">Description</th>
										<th data-hide="phone" class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="">Price(Monthly)</th>
										<th data-hide="phone" class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="">Price(Quarterly)</th>
										<th data-hide="phone" class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="">Price(Half Yearly)</th>
										<th data-hide="phone" class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="">Price(Yearly)</th>
										<th data-hide="phone" class="sorting" tabindex="0"
											aria-controls="datatable_fixed_column" rowspan="1"
											colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="cursor: pointer; text-align: center; vertical-align: middle;">View</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${products}" var="pr">
										<c:set var="i" value="${i+1}" scope="page" />
										<tr role="row" class="odd">
											<td>${i}</td>
											<td class="sorting_1">${pr.productName}</td>
											<td>${pr.description}</td>
											<td><i class="icon-append fa fa-inr"></i>
												${pr.monthlyPrice}</td>
											<td><i class="icon-append fa fa-inr"></i>
												${pr.quarterlyPrice}</td>
											<td><i class="icon-append fa fa-inr"></i>
												${pr.halfYearlyPrice}</td>
											<td><i class="icon-append fa fa-inr"></i>
												${pr.annualPrice}</td>
											<td
												style="cursor: pointer; text-align: center; vertical-align: middle;"><i
												class="icon-append fa fa-eye"></i></td>
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
<security:authorize access="hasAuthority('ADMIN')">
	<div class="modal fade" id="newUserModel" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="newUserBody">
				<sf:form action="${contextRoot}/ad/addProduct"
					modelAttribute="product" id="checkout-form" cssClass="smart-form"
					method="post">
					<header
						style="background: #ccc; margin: 0; padding: 10px 16px 10px 16px;">
						Add New Product</header>
					<fieldset>
						<div class="row">
							<section class="col col-sm-12">
								<label class="label">Product Name</label> <label class="input">
									<i class="icon-append fa fa-user"></i> <sf:input type="text"
										path="productName" placeholder="Product Name" />
								</label>
							</section>

						</div>

						<div class="row">
							<section class="col col-sm-12">
								<label class="label">Description</label> <label class="textarea">
									<i class="icon-append fa fa-comment"></i> <sf:textarea
										path="description" placeholder="Description" rows="4" />
								</label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label">Price (Monthly)</label> <label
									class="input"> <i class="icon-append fa fa-inr"></i> <sf:input
										type="number" path="monthlyPrice" placeholder="Product Name" />
								</label>
							</section>
							<section class="col col-6">
								<label class="label">Price (Quarterly)</label> <label
									class="input"> <i class="icon-append fa fa-inr"></i> <sf:input
										type="number" path="quarterlyPrice" placeholder="Product Name" />
								</label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label">Price (Half Yearly)</label> <label
									class="input"> <i class="icon-append fa fa-inr"></i> <sf:input
										type="number" path="halfYearlyPrice"
										placeholder="Product Name" />
								</label>
							</section>
							<section class="col col-6">
								<label class="label">Price (Annually)</label> <label
									class="input"> <i class="icon-append fa fa-inr"></i> <sf:input
										type="number" path="annualPrice" placeholder="Product Name" />
								</label>
							</section>
						</div>
					</fieldset>

					<footer>
						<button type="submit" class="btn btn-primary">Submit</button>
					</footer>
				</sf:form>
			</div>
		</div>
	</div>
</security:authorize>


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