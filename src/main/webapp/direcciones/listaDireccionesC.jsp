<%-- 
    Document   : listaDireccionesC
    Created on : 2 ene 2022, 19:21:41
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de direcciones</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="Images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Cursos
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="#" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">Lista de cursos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">Cerrar sesi??n</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card border-primary">
                <div class="card-header text-center">
                    Lista de direcciones de cursos
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">
                        <a href="DireccionCursoServlet?accion=nuevaDireccionC" class="btn btn-outline-primary">Crear nueva direcci??n de curso</a>
                        <a href="DireccionCursoServlet?accion=mostrarGraficaDireccionC" class="btn btn-outline-primary">Mostrar grafica</a>
                        <a href="DireccionCursoServlet?accion=mostrarReporteDireccionC" class="btn btn-outline-primary">Mostrar reporte</a>
                    </h4>
                    <c:if test="${mensaje != null}">
                        <div class="alert alert-dark alert-dismissible fade show" role="alert">
                            <strong>${mensaje}</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" arial-label="Close"></button>
                        </div>
                    </c:if>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID de la direcci??n</th>
                                <th>ID Curso</th>
                                <th>ID Profesor</th>
                                <th>Nombre plataforma</th>
                                <th>Enlace llamada</th>
                                <th>Contrase??a llamada</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>
                                <th>Reporte</th>
                            </tr>
                            <c:forEach var="dto" items="${listaDeDireccionesC}">
                            <tbody>
                                <tr>
                                    <td><a href="DireccionCursoServlet?accion=mostrarDireccionC&id=<c:out value="${dto.entidad.idDir}"/>" class="btn btn-outline-secondary"><c:out value="${dto.entidad.idDir}"/></a></td>
                                    <td><c:out value="${dto.entidad.idCurso}"/></td>
                                    <td><c:out value="${dto.entidad.idProfesor}"/></td>
                                    <td><c:out value="${dto.entidad.nombrePlat}"/></td>
                                    <td><c:out value="${dto.entidad.linkLlamada}"/></td>
                                    <td><c:out value="${dto.entidad.passLlamada}"/></td>
                                    <td><a href="DireccionCursoServlet?accion=eliminarDireccionC&id=<c:out value="${dto.entidad.idDir}"/>" class="btn btn-outline-danger">Eliminar</a></td>        
                                    <td><a href="DireccionCursoServlet?accion=actualizarDireccionC&id=<c:out value="${dto.entidad.idDir}"/>" class="btn btn-outline-default">Actualizar</a></td>
                                    <td><a href="DireccionCursoServlet?accion=mostrarReporteDireccionC&individual=1&id=<c:out value="${dto.entidad.idDir}"/>" class="btn btn-outline-info" target="_blank">Reporte</a></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                        </thead>
                    </table>
                </div>
            </div>
            
        </div>
    </body>
</html>
