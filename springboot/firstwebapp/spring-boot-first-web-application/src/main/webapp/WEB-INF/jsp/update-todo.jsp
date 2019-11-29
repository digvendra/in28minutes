<%@include file="common/header.jsp" %>
<%@include file="common/navigation.jsp" %>
<div class="container">
Welcome ${username } !!
	<form:form action="update-todo.htm" class="form" id="todoform" method="post" 
		modelAttribute="todo">
		<form:hidden path="id"/>
		<fieldset class="form-group">
			<form:label path="description">Description : </form:label>
			<form:input path="description" id="targetDate" type="text" name="description" 
				class="form-control" required="required"/>
			<form:errors path="description" cssClass="text-warning"></form:errors>
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="targetDate">Target Date : </form:label>
			<div class="input-group date" data-provide="datepicker">
				<form:input path="targetDate" id="targetDate" type="text" name="targetDate" 
					class="form-control datepicker" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			    <div class="input-group-addon">
			        <span class="glyphicon glyphicon-th"></span>
			    </div>
			</div>
		</fieldset>
		<button class="btn btn-success" id="savetodo" type="submit">Save</button>
	</form:form>
</div>
<%@include file="common/footer.jsp" %>