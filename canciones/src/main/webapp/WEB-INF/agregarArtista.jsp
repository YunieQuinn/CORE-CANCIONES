<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>
    <h1>Agregar Artista</h1>

    <form:form method="post"
               modelAttribute="artista"
               action="${pageContext.request.contextPath}/artistas/procesa/agregar">

        <label for="nombre">Nombre:</label>
        <form:input path="nombre" id="nombre"/>
        <form:errors path="nombre" cssClass="error"/>

        <label for="apellido">Apellido:</label>
        <form:input path="apellido" id="apellido"/>
        <form:errors path="apellido" cssClass="error"/>

        <label for="biografia">Biografía:</label>
        <form:textarea path="biografia" id="biografia" rows="4" cols="40"/>
        <form:errors path="biografia" cssClass="error"/>

        <br/><br/>
        <input type="submit" value="Guardar artista"/>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/artistas">
            Volver a lista de artistas
        </a>
    </p>
</body>
</html>
