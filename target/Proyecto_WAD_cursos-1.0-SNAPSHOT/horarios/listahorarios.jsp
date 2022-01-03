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
        <title>Lista de Horarios</title>
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
                    Lista de horarios del curso <c:out value=${dao.entidad.idCurso}/>
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">
                        <a href="HorariosServlet?accion=nuevoHora" class="btn btn-outline-primary">Agregar nuevo horario de clases</a>
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
                                <th>IDHorario</th>
                                <th>IDProfesor</th>
                                <th>IDCurso</th>
                                <th>Horario</th>
                                <th>Disponible</th>
                                <th>Nombre de Plataforma de clases</th>
                            </tr>
                            <c:forEach var="dto" items="${listaDeHorarios}">
                            <tbody>
                                <tr>
                                    <td><a href="HorariosServlet?accion=mostrarHora&id=<c:out value="${dto.entidad.idHora}"/>" class="btn btn-outline-secondary"><c:out value="${dto.entidad.idHorario}"/></a></td>
                                    <td><c:out value="${dto.entidad.IdProfesor}"/></td>
                                    <td><c:out value="${dto.entidad.IdCurso}"/></td>
                                    <td><c:out value="${dto.entidad.Horario}"/></td>
                                    <td><c:out value="${dto.entidad.Disponible}"/></td>
                                    <td><c:out value="${dto.entidad.NombrePlataforma}"/></td>
                                    <td><a href="HorariosServlet?accion=eliminarHpra&id=<c:out value="${dto.entidad.idHorario}"/>" class="btn btn-outline-danger">Eliminar</a></td>        
                                    <td><a href="HorariosServlet?accion=actuallizarHora&id=<c:out value="${dto.entidad.idHorario}"/>" class="btn btn-outline-default">Actualizar</a></td>
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

