<%-- 
    Document   : listaCalPar
    Created on : 2 ene 2022, 19:20:22
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de calificaciones parciales</title>
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
                                <a class="nav-link active" aria-current="#" href="./../instructores/bienvenida.jsp">Home</a>
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
                    Lista de calificaciones parciales
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">
                        <a href="CalificacionesParcialesServlet?accion=nuevaCalP" class="btn btn-outline-primary">Crear nueva calificaci??n parcial</a>
                        <a href="CalificacionesParcialesServlet?accion=mostrarGraficaCalPar" class="btn btn-outline-primary">Mostrar grafica</a>
                        <a href="CalificacionesParcialesServlet?accion=mostrarReporteCalPar" class="btn btn-outline-primary">Mostrar reporte</a>
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
                                <th>ID</th>
                                <th>Descripci??n</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>
                                <th>Reporte</th>
                            </tr>
                            <c:forEach var="dto" items="${listaDeCalPar}">
                            <tbody>
                                <tr>
                                    <td><a href="CalificacionesParcialesServlet?accion=mostrarCalP&id=<c:out value="${dto.entidad.llave_califi}"/>" class="btn btn-outline-secondary"><c:out value="${dto.entidad.llave_califi}"/></a></td>
                                    <td><c:out value="${dto.entidad.desc}"/></td>
                                    <td><a href="CalificacionesParcialesServlet?accion=eliminarCalP&id=<c:out value="${dto.entidad.llave_califi}"/>" class="btn btn-outline-danger">Eliminar</a></td>        
                                    <td><a href="CalificacionesParcialesServlet?accion=actualizarCalP&id=<c:out value="${dto.entidad.llave_califi}"/>" class="btn btn-outline-default">Actualizar</a></td>
                                    <td><a href="CalificacionesParcialesServlet?accion=mostrarReporteCalPar&individual=1&id=<c:out value="${dto.entidad.llave_califi}"/>" class="btn btn-outline-info" target="_blank">Reporte</a></td>
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
