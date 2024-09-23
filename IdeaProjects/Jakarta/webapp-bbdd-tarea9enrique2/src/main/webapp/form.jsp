<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp" />

<h3>${titulo}</h3>
<p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/cursos" >volver</a></p>
<form action="${pageContext.request.contextPath}/cursos/form" method="post">
  <div class="row mb-2">
    <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
    <div>
      <input type="text" name="nombre" id="nombre" value= "${curso.nombre}" class="form-control">
    </div>
    <c:if test="${errores != null && not empty errores.nombre}">
      <div style="color:red;" >${errores.nombre}</div>
    </c:if>
  </div>

  <div class="row mb-2">
    <label for="instructor" class="col-form-label col-sm-2">Instructor</label>
    <div>
      <input type="text" name="instructor" id="instructor" value="${curso.instructor}" class="form-control">
    </div>
        <c:if test="${errores != null && not empty errores.instructor}">
          <div style="color:red;" >${errores.instructor}</div>
        </c:if>
  </div>

  <div class="row mb-2">
    <label for="duracion" class="col-form-label col-sm-2">Duración</label>
    <div>
      <input type="text" name="duracion" id="duracion" value="${curso.duracion != null && curso.duracion > 0 ? curso.duracion : ""}" class="form-control">
    </div>
        <c:if test="${errores != null && not empty errores.duracion}">
          <div style="color:red;" >${errores.duracion}</div>
        </c:if>
  </div>

  <div class="row mb-2">
    <label for="descripcion" class="col-form-label col-sm-2">Descripción</label>
    <div>
      <textarea type="text" name="descripcion" id="descripcion" class="form-control">${curso.descripcion}</textarea>
    </div>
    <c:if test="${errores != null && not empty errores.descripcion}">
      <div style="color:red;" >${errores.descripcion}</div>
    </c:if>
  </div>

  <div class="row mb-2">
    <div>
      <input type="submit" value="${curso.id != null && curso.id > 0 ? "editar" : "crear"}" class="btn btn-primary">
    </div>
  </div>
  <input type="hidden" name="id" value="${curso.id}">
</form>
<jsp:include page="layout/footer.jsp" />
