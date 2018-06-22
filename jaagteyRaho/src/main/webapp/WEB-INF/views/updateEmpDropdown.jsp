<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label class="label">Employee<span
	style="color: #f00; padding-left: 4px;">*</span></label>
<label class="select"><select id="employee.id"
	name="employee.id">
		<option value="0" disabled="disabled" selected="selected">Select
			Employee</option>
		<c:forEach items="${assignedEmployees}" var="user">
			<option value="${user.id}">${user.firstName}<c:if
					test="${not empty user.middleName}">&nbsp;${user.middleName}</c:if>
				${user.lastName}
			</option>
		</c:forEach>
</select><i></i> </label>