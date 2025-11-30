<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle Canción</title>
</head>
<body>
    <h1>Detalle de la Canción</h1>

    <p><strong>ID:</strong> ${cancion.id}</p>
    <p><strong>Título:</strong> ${cancion.titulo}</p>
    <p><strong>Artista:</strong> ${cancion.artista}</p>
    <p><strong>Álbum:</strong> ${cancion.album}</p>
    <p><strong>Género:</strong> ${cancion.genero}</p>
    <p><strong>Idioma:</strong> ${cancion.idioma}</p>
    <p><strong>Fecha creación:</strong> ${cancion.fechaCreacion}</p>
    <p><strong>Fecha actualización:</strong> ${cancion.fechaActualizacion}</p>

    <p>
        <a href="${pageContext.request.contextPath}/canciones/formulario/editar/${cancion.id}">
            Actualizar canción
        </a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/canciones/eliminar/${cancion.id}"
            onclick="return confirm('¿Estás segura de que quieres eliminar esta canción?');">
            Eliminar canción
        </a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/canciones">Volver a lista de canciones</a>
    </p>
</body>
</html>
    