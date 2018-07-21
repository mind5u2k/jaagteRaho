<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label class="label">Select Site </label>
<label class="select"> <select id="siteId" name="role"
	onchange="updateEmployee(this.value);"><option
			selected="selected" value="0">All Sites</option>
		<c:forEach items="${assignedSites}" var="site">
			<option value="${site.id}">${site.siteName}</option>
		</c:forEach>
</select> <i></i>
</label>
