<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div id="ribbon">
	<ol class="breadcrumb">
		<li>Checkout</li>
	</ol>
</div>
<div id="content">
	<div class="row">
		<article class="col-lg-3 sortable-grid ui-sortable"></article>
		<article class="col-lg-6 sortable-grid ui-sortable">
			<div class="jarviswidget jarviswidget-sortable" id="wid-id-1"
				data-widget-editbutton="false" data-widget-custombutton="false"
				role="widget">
				<header role="heading">
					<h2>Checkout</h2>
					<span class="jarviswidget-loader"><i
						class="fa fa-refresh fa-spin"></i></span>
				</header>
				<div role="content">
					<div class="jarviswidget-editbox"></div>
					<div class="widget-body no-padding">
						<form id="checkout-formss" class="smart-form" method="post"
							novalidate="novalidate"
							action="${contextRoot}/cl/paymentActivity">
							<input type="hidden" id="assignedProductId"
								name="assignedProductId" value="${assignedProduct.id}" />
							<header> Total Ammount to be Paid </header>
							<div class="row" style="padding: 16px 42px 14px 42px;">
								<div class="col-xs-12" style="border-bottom: 0px solid #ccc;">
									<div>
										<span
											style="font-size: 16px; padding: 0 0 0 0; margin: 0 0px 0 0px;">${assignedProduct.product.productName}</span>
										<br>Buying Price - ${assignedProduct.mainPrice}/-<br>Tax
										- ${assignedProduct.tax} %
									</div>
									<div
										style="background: #ccc; padding: 5px 5px 7px 8px; margin: 5px -9px 0px -9px;">
										<span>Grand Total</span> <span style="float: right;">${assignedProduct.totalPrice}/-</span>
									</div>
								</div>
							</div>

							<header> Payment Option </header>
							<fieldset>
								<section>
									<div class="inline-group">
										<label class="radio"> <input type="radio"
											name="radio-inline" checked=""> <i></i>Debit Card
										</label> <label class="radio"> <input type="radio"
											name="radio-inline"> <i></i>Credit Card
										</label> <label class="radio"> <input type="radio"
											name="radio-inline"> <i></i>Internet Banking
										</label>
									</div>
								</section>
								<section>
									<div class="inline-group">
										<label class="radio"> <input type="radio"
											name="radio-inline" checked=""> <i></i>Visa
										</label> <label class="radio"> <input type="radio"
											name="radio-inline"> <i></i>MasterCard
										</label> <label class="radio"> <input type="radio"
											name="radio-inline"> <i></i>American Express
										</label>
									</div>
								</section>

								<section>
									<label class="input"> <input type="text" name="name"
										placeholder="Name on card">
									</label>
								</section>

								<div class="row">
									<section class="col col-10">
										<label class="input"> <input type="text" name="card"
											placeholder="Card number" data-mask="9999-9999-9999-9999">
										</label>
									</section>
									<section class="col col-2">
										<label class="input"> <input type="text" name="cvv"
											placeholder="CVV2" data-mask="999">
										</label>
									</section>
								</div>

								<div class="row">
									<label class="label col col-4">Expiration date</label>
									<section class="col col-5">
										<label class="select"> <select name="month">
												<option value="0" selected="" disabled="">Month</option>
												<option value="1">January</option>
												<option value="1">February</option>
												<option value="3">March</option>
												<option value="4">April</option>
												<option value="5">May</option>
												<option value="6">June</option>
												<option value="7">July</option>
												<option value="8">August</option>
												<option value="9">September</option>
												<option value="10">October</option>
												<option value="11">November</option>
												<option value="12">December</option>
										</select> <i></i>
										</label>
									</section>
									<section class="col col-3">
										<label class="input"> <input type="text" name="year"
											placeholder="Year" data-mask="2099">
										</label>
									</section>
								</div>
							</fieldset>

							<footer>
								<button type="button"
									onclick="window.location.href='${contextRoot}/cl/paymentActivity/${assignedProduct.id}'"
									class="btn btn-primary">Pay</button>
							</footer>
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</div>