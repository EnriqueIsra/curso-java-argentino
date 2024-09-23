<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>
<ul class="list-group">
    <li class="list-group-item active">Factura: ${factura.folioFactura}</li>
    <li class="list-group-item">Descripción: ${factura.descripcion}</li>
    <li class="list-group-item">Cliente: ${factura.cliente.nombre} ${factura.cliente.apellidos}</li>
    <li class="list-group-item">Email: ${factura.cliente.email}</li>
</ul>

<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${factura.detalleFactura}" var="linea" >
        <tr>
            <td>${linea.producto.nombre}</td>
            <td>${linea.producto.precio}</td>
            <td>${linea.cantidad}</td>
            <td>${linea.calcularImporte()}</td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="3" style="text-align: right">Total:</td>
            <td> ${factura.total} </td>
        </tr>
    </tbody>
</table>
<jsp:include page="layout/footer.jsp" />
