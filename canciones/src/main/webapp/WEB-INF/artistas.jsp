<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Artistas</title>
</head>
<body>
    <h1>Listado de Artistas</h1>

    <ul>
        <c:forEach var="artista" items="${artistas}">
            <li>
                <a href="${pageContext.request.contextPath}/artistas/detalle/${artista.id}">
                    ${artista.nombre} ${artista.apellido}
                </a>
            </li>
        </c:forEach>
    </ul>

    <p>
        <a href="${pageContext.request.contextPath}/artistas/formulario/agregar">
            Agregar artista
        </a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/canciones">
            Ir a canciones
        </a>
    </p>
</body>
</html>
