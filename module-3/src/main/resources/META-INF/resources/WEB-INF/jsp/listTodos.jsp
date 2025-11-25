<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>

        <div class="container">
            <h1>Welcome to the todos page, ${name}!</h1>

            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <a href="/todos/${todo.id}/update/">
                            <tr>
                                <td>${todo.description}</td>
                                <td>${todo.targetDate}</td>
                                <td>${todo.done}</td>
                                <td>
                                    <a href="/todos/${todo.id}/update/" class="btn btn-primary">Edit</a>
                                    <a href="/todos/${todo.id}/delete/" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </a>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/todos/new/add/" class="btn btn-success">Add Todo</a>
        </div>
        <%@ include file="common/footer.jspf" %>