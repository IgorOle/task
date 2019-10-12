<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div class="container">
    <form method="POST" action="login" class="form-signin col-6">
        <h2 class="form-heading">Welcome</h2>
        <h7>Login user1, user2 ... user6, password 1, id 1 ... 6</h7>
        <div class="form-group">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span class="alert-danger">${error}</span>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>
    </form>
</div>
</body>
</html>