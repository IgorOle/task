<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/common.js" defer></script>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="logout">
        </form>
        <h2 class="form-heading">${pageContext.request.userPrincipal.name}
            <a class="btn btn-primary btn-lg" href="#" role="button" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>


        <div class="card border-dark">
            <div class="card-body pb-0">
                <form id="formID" name="formID">
                    <div class="row">
                        <div class="offset-1 col-5">
                            <label for="userID">UserID </label>
                            <input class="form-control positiveNumber" name="userID" id="userID">
                        </div>
                        <button class="btn btn-primary" onclick="searchUserById(); return false;">
                            <span class="fa fa-filter"></span>
                            Search
                        </button>
                    </div>
                </form>
            </div>
            <div class="" id="results"></div>
        </div>

    </c:if>
</div>
</body>
</html>
