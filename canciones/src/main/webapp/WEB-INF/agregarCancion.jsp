<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Canción</title>
    <style>
        .error {
            color: red;
            font-size: 0.9em;
        }
        label {
            display: block;
            margin-top: 8px;
        }
        input {
            width: 250px;
        }
    </style>
</head>
<body>
    <h1>Agregar Canción</h1>

    <form:form method="post"
               modelAttribute="cancion"
               action="${pageContext.request.contextPath}/canciones/procesa/agregar">

        <label for="titulo">Título:</label>
        <form:input path="titulo" id="titulo"/>
        <form:errors path="titulo" cssClass="error"/>

        <label for="artista">Artista:</label>
        <select id="artistaId" name="artistaId">
            <option value="">-- Selecciona un artista --</option>
            <c:forEach var="artista" items="${artistas}">
                <option value="${artista.id}">
                    ${artista.nombre} ${artista.apellido}
                </option>
            </c:forEach>
        </select>

        <label for="album">Álbum:</label>
        <form:input path="album" id="album"/>
        <form:errors path="album" cssClass="error"/>

        <label for="genero">Género:</label>
        <form:input path="genero" id="genero"/>
        <form:errors path="genero" cssClass="error"/>

        <label for="idioma">Idioma:</label>
        <form:input path="idioma" id="idioma"/>
        <form:errors path="idioma" cssClass="error"/>

        <br/><br/>
        <input type="submit" value="Guardar canción"/>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/canciones">
            Volver a lista de canciones
        </a>
    </p>
</body>
</html>
