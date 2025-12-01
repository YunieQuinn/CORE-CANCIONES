<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle Artista</title>
</head>
<body>
    <h1>Detalle del Artista</h1>

    <p><strong>ID:</strong> ${artista.id}</p>
    <p><strong>Nombre:</strong> ${artista.nombre}</p>
    <p><strong>Apellido:</strong> ${artista.apellido}</p>
    <p><strong>Biografía:</strong> ${artista.biografia}</p>
    <p><strong>Fecha creación:</strong> ${artista.fechaCreacion}</p>
    <p><strong>Fecha actualización:</strong> ${artista.fechaActualizacion}</p>

    <h2>Canciones del artista</h2>
    <c:if test="${empty artista.canciones}">
        <p>Este artista todavía no tiene canciones registradas.</p>
    </c:if>
    <c:if test="${not empty artista.canciones}">
        <ul>
            <c:forEach var="cancion" items="${artista.canciones}">
                <li>
                    <a href="${pageContext.request.contextPath}/canciones/detalle/${cancion.id}">
                        ${cancion.titulo}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <p>
        <a href="${pageContext.request.contextPath}/artistas">
            Volver a lista de artistas
        </a>
    </p>
</body>
</html>
