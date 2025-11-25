<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>Enter To Do details</h1>
            <form:form method="post" modelAttribute="toDo">
                <fieldset class="mb-3">
                    <form:label path="description">Description:</form:label>
                    <form:input type="text" path="description" />
                    <form:errors path="description" cssClass="text-danger" />
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date:</form:label>
                    <!--form:input type="date" path="targetDate" /-->
                    <form:input type="text" path="targetDate" />
                    <form:errors path="targetDate" cssClass="text-danger" />
                </fieldset>
                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <input type="submit" value="Save" class="btn btn-success">
                <a href="/todos/" class="btn btn-secondary">Back</a>
            </form:form>

            <%@ include file="common/footer.jspf" %>

                <script>
                    $("#targetDate").datepicker({
                        format: "yyyy-mm-dd"
                    });
                </script>