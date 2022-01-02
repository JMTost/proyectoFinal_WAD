<%-- 
    Document   : listaprofe
    Created on : 31 dic 2021, 17:12:29
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de instructores</title>
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
                        <img src="../Images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
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
                                <a class="nav-link" href="">Cerrar sesión</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="card border-primary">
                <div class="card-header text-center">
                    Lista de instructores
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">
                        <a href="InstructorServlet?accion=nuevoInstr" class="btn btn-outline-primary">Crear nuevo instructor</a>
                        <a href="InstructorServlet?accion=nuevoInstr" class="btn btn-outline-primary">Mostrar grafica</a>
                        <a href="InstructorServlet?accion=mostrarResporInstr" class="btn btn-outline-primary">Mostrar reporte</a>
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
                                <th>Nombre</th>
                                <th>Apellido paterno</th>
                                <th>Apeliido materno</th>
                                <th>Calle</th>
                                <th>Número exterior</th>
                                <th>Código postal</th>
                                <th>Delegación</th>
                                <th>Teléfono</th>
                                <th>Correo electrónico</th>
                                <th>Contraseña</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>
                                <th>Reporte</th>
                            </tr>
                            <c:forEach var="dto" items="${listaDeInstructores}">
                            <tbody>
                                <tr>
                                    <td><a href="InstructorServlet?accion=mostrarInstr&id=<c:out value="${dto.entidad.idProfesor}"/>" class="btn btn-outline-secondary"><c:out value="${dto.entidad.idProfesor}"/></a></td>
                                    <td><c:out value="${dto.entidad.nombre}"/></td>
                                    <td><c:out value="${dto.entidad.apPat}"/></td>
                                    <td><c:out value="${dto.entidad.apMat}"/></td>
                                    <td><c:out value="${dto.entidad.calle}"/></td>
                                    <td><c:out value="${dto.entidad.numExt}"/></td>
                                    <td><c:out value="${dto.entidad.codPost}"/></td>
                                    <td><c:out value="${dto.entidad.delegacion}"/></td>
                                    <td><c:out value="${dto.entidad.telefono}"/></td>
                                    <td><c:out value="${dto.entidad.correo}"/></td>
                                    <td><c:out value="${dto.entidad.pass}"/></td>
                                    <td><a href="InstructorServlet?accion=eliminarInstr&id=<c:out value="${dto.entidad.idProfesor}"/>" class="btn btn-outline-danger">Eliminar</a></td>        
                                    <td><a href="InstructorServlet?accion=actuallizarInstr&id=<c:out value="${dto.entidad.idProfesor}"/>" class="btn btn-outline-default">Actualizar</a></td>
                                    <td><a href="InstructorServlet?accion=mostrarReporteInstr&individual=1&id=<c:out value="${dto.entidad.idProfesor}"/>" class="btn btn-outline-info" target="_blank">Reporte</a></td>
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

