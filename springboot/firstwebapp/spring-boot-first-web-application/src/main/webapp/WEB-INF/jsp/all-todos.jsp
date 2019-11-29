<%@include file="common/header.jsp" %>
<%@include file="common/navigation.jsp" %>
<div class="container">
Welcome ${username } !!
	<table class="table table-striped">
      <th>User</th>
      <th>Description</th>
      <th>Target Date</th>
      <th>Completed ?</th>
      <th></th>
      <c:forEach items="${alltodos}" var="todo">
        <tr>
          <td>${todo.user}</td>
          <td>${todo.description}</td>
          <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy" /></td>
          <td>${todo.done}</td>
          <td>
          <a type="button" class="btn btn-success" 
          	href="/edit-todo.htm?id=${todo.id}">Edit</a>
          <a type="button" class="btn btn-warning" 
          	href="/delete-todo.htm?id=${todo.id}">Delete</a></td>
        </tr>
      </c:forEach>
    </table>
    <a class="btn btn-primary" href="add-todo.htm">Add Todo</a>
</div>
<%@include file="common/footer.jsp" %>