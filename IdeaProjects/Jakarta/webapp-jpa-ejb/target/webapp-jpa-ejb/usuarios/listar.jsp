<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>

<h3>${title}</h3>
<c:if test="${username.present}">
    <div class="alert alert-info" >Hola ${username.get()}, Bienvenido.</div>
    <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/usuarios/form">crear [+]</a>
</c:if>
<table class="table table-striped table-hover">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>email</th>

        <c:if test="${username.present}">
            <th>editar</th>
            <th>eliminar</th>
        </c:if>
        <c:forEach items="${usuarios}" var="u">
            <tr>
                <td> ${u.id}</td>
                <td> ${u.username}</td>
                <td> ${u.email}</td>
                <c:if test="${username.present}">

                    <td><a class="btn btn-sm btn-success"
                           href="${pageContext.request.contextPath}/usuarios/form?id=${u.id}">editar</a></td>
                    <td><a class="btn btn-sm btn-danger" onClick="return confirm('¿está seguro que desea eliminar?');"
                           href="${pageContext.request.contextPath}/usuarios/eliminar?id=${u.id}">eliminar</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </tr>
</table>

<jsp:include page="/layout/footer.jsp"/>
