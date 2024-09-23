<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tarea 4</title>
</head>
<body>
<h2 style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Cambio de colores con estilos css y uso de cookies</h2>
<p style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Utiliza la lista desplegable para cambiar el color de este texto</p>
<form action="/webapp-cookie-tarea4/cambiar-color" method="get">
    <div>
        <select name="color" id="color">
            <option value="blue">Azul</option>
            <option value="red">Rojo</option>
            <option value="green">Verde</option>
            <option value="aqua">Aqua</option>
            <option value="BlueViolet">Violeta</option>
            <option value="Gray">Gris</option>
            <option value="Pink">Rosa</option>
        </select>
    </div>
    <div>
        <input type="submit" value="cambiar color">
    </div>
</form>

</body>
</html>