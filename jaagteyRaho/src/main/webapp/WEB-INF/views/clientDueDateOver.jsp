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
								Status - <span class="text-danger"><i
									class="fa fa-times-circle"></i> Deactivate </span>
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
								!! Your Product is in <span class="text-danger"><i
									class="fa fa-times-circle"></i> Deactivate </span> State !!<br>
							</div>
							<div class="col-lg-6" style="padding: 6px; font-size: 16px;">
								Purchased Date : <span class="text-primary"
									style="font-size: 14px;">${assignedProduct.startdate}</span><br>End
								Date : <span class="text-primary" style="font-size: 14px;">${assignedProduct.endDate}</span>
							</div>
							<div class="col-lg-12" style="padding: 6px;">
								<%-- <button class="btn btn-default"
									onclick="window.location.href='clientPaymentDeatils/${assignedProduct.id}'">Pay
									Now</button> --%>
							</div>
						</div>
						<div class="row" style="text-align: center;">
							<!-- <div class="col-lg-3"
								style="font-size: 81px; padding: 0 0 0 0; text-align: center; border-right: 1px solid #ccc; color: #6a6464; margin-top: 19px;">
								<i class="fa fa-cubes"></i>
							</div> -->
							<div class="col-lg-12" style="padding: 10px;">
								<span style="font-size: 18px; text-decoration: underline;">Latest
									statement generated on 21 Apr 2018</span>
							</div>
							<div class="col-lg-12" style="padding: 6px; font-size: 16px;">
								Payment Due Date : <span class="text-primary"
									style="font-size: 14px;">${assignedProduct.endDate}</span><br>Total
								Ammount Due : <span class="text-primary"
									style="font-size: 14px;">${assignedProduct.totalPrice}</span>
							</div>
							<div class="col-lg-12" style="padding: 6px;">
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
								Status - <span class="text-danger"><i
									class="fa fa-times-circle"></i> Deactivate </span>
							</div>
						</div>
						<div class="row" style="padding: 0px; text-align: center;">
							<div class="col-lg-12" style="padding: 15px;">
								<table style="margin: auto; width: 100%;">
									<tr>
										<td
											style="text-align: center; font-size: 17px; border-right: 1px solid #ccc; padding: 0px 18px 0px 17px; width: 50%;">Total
											Amount</td>
										<td
											style="text-align: center; font-size: 17px; border-left: 1px solid #ccc; padding: 0px 18px 0px 17px; width: 50%;">Due
											Date</td>
									</tr>
									<tr>
										<td
											style="text-align: center; font-size: 14px; border-right: 1px solid #ccc; padding: 0px 18px 0px 17px; color: #4448b2;">${assignedProduct.totalPrice}</td>
										<td
											style="text-align: center; font-size: 14px; border-left: 1px solid #ccc; padding: 0px 18px 0px 17px; color: #4448b2;">${assignedProduct.endDate}</td>
									</tr>
								</table>
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
								Status - <span class="text-danger"><i
									class="fa fa-times-circle"></i> Deactivate </span>
							</div>
						</div>
						<div class="row" style="padding: 0px; text-align: center;">
							<div class="col-lg-12" style="padding: 15px;">
								<table style="margin: auto; width: 100%;">
									<tr>
										<td
											style="text-align: center; font-size: 17px; border-right: 1px solid #ccc; padding: 0px 18px 0px 17px; width: 50%;">Amount</td>
										<td
											style="text-align: center; font-size: 17px; border-left: 1px solid #ccc; padding: 0px 18px 0px 17px; width: 50%;">Date</td>
									</tr>
									<tr>
										<td
											style="text-align: center; font-size: 14px; border-right: 1px solid #ccc; padding: 0px 18px 0px 17px; color: #4448b2;">${assignedProduct.totalPrice}</td>
										<td
											style="text-align: center; font-size: 14px; border-left: 1px solid #ccc; padding: 0px 18px 0px 17px; color: #4448b2;">${assignedProduct.lastPaymentDate}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div>
</div>
