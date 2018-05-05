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
						<div class="padding-10">
							<div class="pull-right">
								<h1 class="font-400">invoice</h1>
							</div>
							<div class="clearfix"></div>
							<br> <br>
							<div class="row">
								<div class="col-sm-9">
									<h4 class="semi-bold">${company.companyName}</h4>
									<address>
										<strong>${assignedProduct.client.firstName}
											${assignedProduct.client.lastName}</strong> <br>
										${address.addressLineOne}<br>${address.addressLineTwo}, <br>
										${address.city}-${address.postalCode}<br>${address.state}-${address.country}
										<br> P : ${assignedProduct.client.contactNumber}
									</address>
								</div>
								<div class="col-sm-3">
									<div>
										<div>
											<strong>PAYMENT NO :</strong> <span class="pull-right">
												#AA-454-4113-00 </span>
										</div>

									</div>
									<div>
										<div class="font-md">
											<strong>PAYMENT DATE :</strong> <span class="pull-right">
												<i class="fa fa-calendar"></i> ${todaysDate}
											</span>
										</div>

									</div>
									<div>
										<div>
											<strong>PAYMENT DURATION :</strong> <span class="pull-right">
												${assignedProduct.paymentDuration} </span>
										</div>

									</div>
									<br>
									<div
										class="well well-sm  bg-color-darken txt-color-white no-border">
										<div class="fa-lg">
											Total Due : <span class="pull-right">
												${assignedProduct.totalPrice} <i class="fa fa-inr"></i> **
											</span>
										</div>

									</div>
									<br> <br>
								</div>
							</div>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>ITEM</th>
										<th>DESCRIPTION</th>
										<th>PRICE</th>
										<th style="text-align: right;">SUBTOTAL</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><a href="javascript:void(0);">${assignedProduct.product.productName}</a></td>
										<td>${assignedProduct.product.description}</td>
										<td>${assignedProduct.mainPrice}&nbsp;<i
											class="fa fa-inr"></i></td>
										<td style="text-align: right;">${assignedProduct.mainPrice}
											<i class="fa fa-inr"></i>
										</td>
									</tr>
									<tr>
										<td colspan="3">Total</td>
										<td style="text-align: right;"><strong>${assignedProduct.mainPrice}
												<i class="fa fa-inr"></i>
										</strong></td>
									</tr>
									<tr>
										<td colspan="3">Service Tax</td>
										<td style="text-align: right;"><strong>${assignedProduct.tax}%</strong></td>
									</tr>
								</tbody>
							</table>

							<div class="invoice-footer">
								<div class="row">
									<div class="col-sm-7">
										<div class="payment-methods">
											<h5>Payment Methods</h5>
											<img src="${images}/invoice/paypal.png" width="64"
												height="64" alt="paypal"> <img
												src="${images}/invoice/americanexpress.png" width="64"
												height="64" alt="american express"> <img
												src="${images}/invoice/mastercard.png" width="64"
												height="64" alt="mastercard"> <img
												src="${images}/invoice/visa.png" width="64" height="64"
												alt="visa">
										</div>
									</div>
									<div class="col-sm-5">
										<div class="invoice-sum-total pull-right">
											<h3>
												<strong>Total: <span class="text-success">${assignedProduct.totalPrice}
														<i class="fa fa-inr"></i>
												</span></strong>
											</h3>
										</div>
									</div>

								</div>

								<div class="row">
									<div class="col-sm-12">
										<p class="note">**To avoid any excess penalty charges,
											please make payments within 30 days of the due date. There
											will be a 2% interest charge per month on all late invoices.</p>
									</div>
								</div>

							</div>
						</div>
						<div class="text-center" style="padding: 32px;">
							<a href="#" onclick="disclaimer();" class="btn btn-primary">Pay
								Now</a> <a href="${contextRoot}/cl/home" class="btn btn-danger">Cancel</a>
						</div>
					</div>

				</div>
			</div>
		</article>
	</div>
</div>
<div class="modal fade" id="disclaimerModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="newUserBody">
			<sf:form action="${contextRoot}/ad/addProduct" id="checkout-form"
				cssClass="smart-form" method="post">
				<header
					style="background: #ccc; margin: 0; padding: 10px 16px 10px 16px; text-align: center;">Disclaimer</header>
				<div style="padding: 36px;">
					<p>You are being re-directed to a third party site. Please
						acknowledge the disclaimer before proceeding further.</p>
					<br>
					<p>You are about to access a site, the accuracy or completeness
						of the materials or the reliability of any advice, opinion,
						statement or other information displayed or distributed through
						it, is not warranted by SBICPSL and shall be solely be construed
						to be set forth by the third party.</p>
					<br>
					<p>You will access this site solely for the payment of your
						bills and you acknowledge that any reliance on any opinion,
						advice, statement, memorandum, or information available on the
						site shall be at your sole risk and consequences.</p>
					<br>
					<p>SBICPSL and its affiliates, subsidiaries, employees,
						officers, directors and agents, expressly disclaim any liability
						for any deficiency in the services of the service provider whose
						site you are about to access. Neither SBICPSL nor any of its
						affiliates nor their directors, officers and employees will be
						liable to or have any responsibility of any kind for any loss that
						you incur in the event of any deficiency in the services of the
						service provider, failure or disruption of the site of the service
						provider, or resulting from the act or omission of any other party
						involved in making this site or the data contained therein
						available to you, or from any other cause relating to your access
						to, inability to access, or use of the site or these materials in
						accordance thereto SBICSPL and all its related parties described
						hereinabove stand indemnified from all proceedings or matters
						arising thereto.</p>
				</div>

				<footer style="text-align: center;">
					<button type="button" data-dismiss="modal" class="btn btn-primary"
						style="float: none;">Cancel</button>
					<button type="button" class="btn btn-primary" style="float: none;"
						onclick="window.location.href='${contextRoot}/cl/checkout/${assignedProduct.id}'">Proceed</button>
				</footer>
			</sf:form>
		</div>
	</div>
</div>
<script>
	function disclaimer() {
		$('#disclaimerModal').modal({
			show : true
		});
	}
</script>
