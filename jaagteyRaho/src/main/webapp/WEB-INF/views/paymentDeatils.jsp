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
						<strong>Payment Details</strong>
					</h2>
				</header>
				<div role="content">
					<div class="widget-body no-padding">
						<div class="row">
							<div class="col-lg-6">
								<h1 style="text-align: center;">Product Details</h1>
								<div class="padding-10">
									<table class="table table-hover"
										style="border: 1px solid #9a8e8e; box-shadow: 4px 4px 4px #464545;">
										<tbody>
											<tr>
												<td style="border: 0;"><strong>product</strong></td>
												<td style="border: 0;"><a href="javascript:void(0);">${assignedProduct.product.productName}</a></td>

											</tr>
											<tr>
												<td><strong>Description</strong></td>
												<td>${assignedProduct.product.description}</td>
											</tr>
											<tr>
												<td><strong>Patment Duration</strong></td>
												<td><sf:form modelAttribute="assignedProduct"
														cssClass="smart-form pull-left"
														action="${contextRoot}/cl/updateTrail" id="form-register">
														<label class="select" style="width: 113px;"> <sf:select
																path="paymentDuration" id="paymentDuration">
																<sf:options items="${durations}" />
															</sf:select> <i></i>
														</label>
													</sf:form>
													<button class="btn btn-default" style="margin-left: 10px;"
														onclick="updatePage('${assignedProduct.id}');">Update</button></td>
											</tr>
											<tr>
												<td><strong>Start Date</strong></td>
												<td>${assignedProduct.startdate}</td>
											</tr>
											<tr>
												<td><strong>End Date</strong></td>
												<td>${assignedProduct.endDate}</td>
											</tr>
											<tr>
												<td><strong>Price</strong></td>
												<td><strong>${assignedProduct.mainPrice} <i
														class="fa fa-inr"></i></strong></td>
											</tr>
											<tr>
												<td><strong>HST/GST</strong></td>
												<td><strong>${assignedProduct.tax}%</strong></td>
											</tr>
										</tbody>
									</table>


								</div>
							</div>
							<div class="col-lg-6">
								<h1 style="text-align: center;">Client Details</h1>
								<div class="padding-10">
									<table class="table table-hover"
										style="border: 1px solid #9a8e8e; box-shadow: 4px 4px 4px #464545;">
										<tbody>
											<tr>
												<td style="border: 0;"><strong>Company</strong></td>
												<td style="border: 0;"><a href="javascript:void(0);">${company.companyName}
														- (${company.companyUrl})</a></td>

											</tr>
											<tr>
												<td><strong>Person</strong></td>
												<td>${assignedProduct.client.firstName}
													${assignedProduct.client.lastName}</td>
											</tr>
											<tr>
												<td><strong>Contact</strong></td>
												<td>+91 ${assignedProduct.client.contactNumber}</td>
											</tr>
											<tr>
												<td><strong>Email</strong></td>
												<td>${assignedProduct.client.email}</td>
											</tr>
											<tr>
												<td><strong>Address</strong></td>
												<td>${address.addressLineOne}<br>${address.addressLineTwo}<br>${address.city}-${address.postalCode}<br>${address.state}-${address.country}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="invoice-footer">
							<div class="row">
								<div class="col-sm-12">
									<div class="invoice-sum-total" style="text-align: center;">
										<h3>
											<strong>Total Due: <span class="text-success">${assignedProduct.totalPrice}
													<i class="fa fa-inr"></i>
											</span></strong>
										</h3>
									</div>
								</div>
							</div>
						</div>
						<div class="text-center" style="padding: 32px;">
							<a
								href="${contextRoot}/cl/clientPaymentConfirmation/${assignedProduct.id}"
								class="btn btn-primary">Continue</a> <a
								href="${contextRoot}/cl/home" class="btn btn-danger">Cancel</a>
						</div>
					</div>

				</div>
			</div>
		</article>
	</div>
</div>
<script>
	function updatePage(assignProductId) {
		var paymentDuration = $("#paymentDuration").val();
		window.location.href = "${contextRoot}/cl/clientPaymentDeatils/"
				+ assignProductId + "/" + paymentDuration;
	}
</script>