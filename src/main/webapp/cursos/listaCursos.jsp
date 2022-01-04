<%-- 
    Document   : listaCursos
    Created on : 2 ene 2022, 19:19:40
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de cursos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" ></script>
    </head>
    <body>
        <div class="container">            
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <img src="Images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                    Cursos

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" href="InstructorServlet?accion=mostrarBienvenida">Home</a>
                            </li>                            
                        </ul>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">                        
                        <a class="btn btn-danger"  href="SesionesServlet?accion=cerrarSesion">Cerrar Sesión</a>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card border-primary">
                <div class="card-header text-center">
                    Lista de cursos   
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">

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
                                <th>Codigo del curso</th>
                                <th>Nombre del curso</th>
                                <th>ID del profesor</th>
                                <th>Descripción</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>                            
                                <th>Lista de Alumnos</th>
                            </tr>
                            <c:forEach var="dto" items="${listaDeCursos}">
                            <tbody>                                                      
                                <tr>      

                                    <td><a href="CursosServlet?accion=mostrarCalP&id=<c:out value="${dto.entidad.idCurso}"/>" class="btn btn-outline-secondary"><c:out value="${dto.entidad.idCurso}"/></a></td>
                                    <td><c:out value="${dto.entidad.nombreCurso}"/></td>
                                    <td><c:out value="${dto.entidad.idProfesor}"/></td>
                                    <td><c:out value="${dto.entidad.descripcion}"/></td>
                                    <td><a href="CursosServlet?accion=eliminarCurso&id=<c:out value="${dto.entidad.idCurso}"/>" class="btn btn-outline-danger">Eliminar</a></td>        
                                    <td><a href="CursosServlet?accion=actualizarCurso&id=<c:out value="${dto.entidad.idCurso}"/>" class="btn btn-outline-warning">Actualizar</a></td>                                                                        

                                    <td>
                                        <form action="CursosServlet?accion=mostrarListaCurso&id=<c:out value="${dto.entidad.idCurso}"/>&profe=<c:out value="${dto.entidad.idProfesor}"/>" method="post" >
                                            <button type="submit" class="btn btn-outline-success">Ver Lista</a>  
                                        </form>     
                                    </td> 
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
