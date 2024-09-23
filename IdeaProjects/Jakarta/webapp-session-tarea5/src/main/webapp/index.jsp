<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tarea 5: manejo de sesiones</title>
</head>
<body>
<h1>Tarea 5: manejo de sesiones</h1>
<p>Hola <%=session.getAttribute("nombre") != null ? session.getAttribute("nombre") : "anónimo"%>, bienvenido a la tarea5.</p>
<form action="/webapp-session-tarea5/guardar-session" method="post">
    <div>
            <label>Ingresa un nombre de usuario para la sesión</label>
        <div>
            <input type="text" name="nombre">
        </div>
    </div>
    <div>
        <input type="submit" value="aceptar">
    </div>

</form>

</body>
</html>