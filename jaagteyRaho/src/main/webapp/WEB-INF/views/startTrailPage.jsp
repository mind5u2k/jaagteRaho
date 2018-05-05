<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<sf:form modelAttribute="assignedProduct" cssClass="smart-form"
	action="${contextRoot}/cl/updateTrail" id="form-register">
	<header>
		<strong>Trail</strong>
	</header>
	<fieldset>
		<div class="row">
			<section class="col col-6">
				<label class="label">Number of days</label> <label class="input">
					<i class="icon-append fa fa-calendar"></i> <sf:input type="number"
						path="trialPeriod" placeholder="No Of Days" disabled="true" />
				</label>
			</section>
		</div>

		<div class="row">
			<section class="col col-6">
				<label class="label">Start Date</label> <label class="input">
					<i class="icon-append fa fa-calendar"></i> <sf:input type="text"
						path="startdate" placeholder="Start Date" disabled="true" />
				</label>
			</section>
			<section class="col col-6">
				<label class="label">End Date</label> <label class="input">
					<i class="icon-append fa fa-calendar"></i> <sf:input type="text"
						path="endDate" disabled="true" />
				</label>
			</section>
		</div>
	</fieldset>
	<footer>
		<button class="btn btn-primary" type="submit">Start Trail</button>
	</footer>
	<sf:hidden path="id" />
</sf:form>
