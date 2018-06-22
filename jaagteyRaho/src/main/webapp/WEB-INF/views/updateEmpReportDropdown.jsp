<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label class="label">Select Employee </label>
<label class="select"> <select id="userId" name="role"><option
			selected="selected" value="0">All Employees</option>
		<c:forEach items="${assignedEmployees}" var="user">
			<option value="${user.id}">${user.firstName}<c:if
					test="${not empty user.middleName}">&nbsp;${user.middleName}</c:if>
				${user.lastName}
			</option>
		</c:forEach>
</select> <i></i>
</label>