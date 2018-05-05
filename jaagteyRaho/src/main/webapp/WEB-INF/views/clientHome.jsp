<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div id="ribbon">
	<ol class="breadcrumb">
		<li>Client Home</li>
	</ol>
</div>
<div id="content">
	<div class="row">
		<article class="col-lg-12 sortable-grid ui-sortable">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget jarviswidget-sortable" id="wid-id-0"
				role="widget">
				<header role="heading">
					<h2>
						<strong>Summary</strong>
					</h2>
				</header>
				<div role="content">
					<div class="jarviswidget-editbox"></div>
					<div class="widget-body">
						<div class="row">
							<div class="col-lg-8" style="padding: 15px; font-size: 21px;">
								<span class="page-title txt-color-blueDark"> My Products
								</span> <a href="#" class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="true"
									style="font-size: 16px; padding: 10px 9px 9px 9px; border: 1px solid #7ba0c9; margin-left: 17px; box-shadow: 3px 3px 3px #679edc;">${assignedProduct.product.productName}
									<b class="caret"></b>
								</a>

								<ul class="dropdown-menu dropdown-menu-large row"
									style="margin: 0px 0px 0 185px;">
									<li class="col-sm-12">
										<ul>
											<li class="dropdown-header">Select Product</li>
											<c:forEach items="${assignedProducts}" var="asp">
												<li><a
													href="${contextRoot}/cl/home?assignedProductId=${asp.id}">${asp.product.productName}</a></li>
											</c:forEach>

										</ul>
									</li>
								</ul>
							</div>
							<div class="col-lg-4"
								style="padding: 15px; font-size: 18px; text-align: right;">
								Status - <span class="text-warning"><i
									class="fa fa-exclamation-triangle"></i> Trial</span>
							</div>
						</div>
						<div class="row" style="text-align: center;">
							<!-- <div class="col-lg-3"
								style="font-size: 81px; padding: 0 0 0 0; text-align: center; border-right: 1px solid #ccc; color: #6a6464; margin-top: 19px;">
								<i class="fa fa-cubes"></i>
							</div> -->
							<div class="col-lg-12" style="padding: 15px;">
								<span style="font-size: 18px; text-decoration: underline;">Statement
									Overview</span>
							</div>
							<div class="col-lg-6" style="padding: 6px; font-size: 16px;">
								!! You are in <span class="text-warning"><i
									class="fa fa-exclamation-triangle"></i> Trail</span> Period !!<br>Please
								purchase the product
							</div>
							<div class="col-lg-6" style="padding: 6px; font-size: 16px;">
								Start Date : <span class="text-primary" style="font-size: 14px;">${assignedProduct.startdate}</span><br>End
								Date : <span class="text-primary" style="font-size: 14px;">${assignedProduct.endDate}</span>
							</div>
							<div class="col-lg-12" style="padding: 6px;">
								<button class="btn btn-default"<%-- onclick="SubcribeProduct('${assignedProduct.id}');" --%>>Approval
									Extension</button>
								<button class="btn btn-default"
									onclick="window.location.href='clientPaymentDeatils/${assignedProduct.id}'">Pay
									Now</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
		<div class="col-lg-12"
			style="text-align: center; padding: 0 0 19px 0px; font-size: 20px;">Your
			account summary as on ${todaysDate}</div>
		<article class="col-lg-6 sortable-grid ui-sortable">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget jarviswidget-sortable" id="wid-id-0"
				role="widget" style="border-top: 1px solid #ccc;">
				<div role="content">
					<div class="jarviswidget-editbox"></div>
					<div class="widget-body">
						<div class="row">
							<div class="col-lg-8" style="padding: 15px; font-size: 21px;">
								<span class="page-title txt-color-blueDark"> Current
									Outstanding </span>
							</div>
							<div class="col-lg-4"
								style="padding: 15px; font-size: 18px; text-align: right;">
								Status - <span class="text-warning"><i
									class="fa fa-exclamation-triangle"></i> Trail</span>
							</div>
						</div>
						<div class="row" style="padding: 0px; text-align: center;">
							<div class="col-lg-12" style="padding: 6px;">
								<div class="text-center error-box">
									<h1 class="error-text tada animated"
										style="font-size: 32px; letter-spacing: 0px; font-weight: 100 !important;">
										<i class="fa fa-times-circle text-danger error-icon-shadow"></i>
										!! Product not purchased yet !!
									</h1>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
		<article class="col-lg-6 sortable-grid ui-sortable">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget jarviswidget-sortable" id="wid-id-0"
				role="widget" style="border-top: 1px solid #ccc;">
				<div role="content">
					<div class="jarviswidget-editbox"></div>
					<div class="widget-body">
						<div class="row">
							<div class="col-lg-8" style="padding: 15px; font-size: 21px;">
								<span class="page-title txt-color-blueDark"> Last Payment
									Made </span>
							</div>
							<div class="col-lg-4"
								style="padding: 15px; font-size: 18px; text-align: right;">
								Status - <span class="text-warning"><i
									class="fa fa-exclamation-triangle"></i> Trail</span>
							</div>
						</div>
						<div class="row" style="padding: 0px; text-align: center;">
							<div class="col-lg-12" style="padding: 6px;">
								<div class="text-center error-box">
									<h1 class="error-text tada animated"
										style="font-size: 32px; letter-spacing: 0px; font-weight: 100 !important;">
										<i class="fa fa-times-circle text-danger error-icon-shadow"></i>
										!! Product not purchased yet !!
									</h1>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div>
</div>
<div class="modal fade" id="trailPeriodModel" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="trailPeriodBody"></div>
	</div>
</div>

<script>
	function SubcribeProduct(assignedProductId) {
		$('#trailPeriodModel').modal({
			show : true
		});

		$.ajax({
			type : "GET",
			url : "startTrail?assignedProductId=" + assignedProductId,
			success : function(response) {
				$("#trailPeriodBody").html(response);
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});
	}
</script>