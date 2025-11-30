<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Canciones</title>
</head>
<body>
    <h1>Listado de Canciones</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${canciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/canciones/detalle/${cancion.id}">
                            Detalle
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
    <a href="${pageContext.request.contextPath}/canciones/formulario/agregar">
        Agregar nueva canción
    </a>
</p>
</body>
</html>
