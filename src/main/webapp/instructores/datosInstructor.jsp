<%-- 
    Document   : datosInstructor
    Created on : 1 ene 2022, 18:58:32
    Author     : JMTN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos del instructor</title>
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
                            <li class="nav-item">
                                <a class="nav-link" href="CursosServlet?accion=listaDeCursos">Lista de cursos</a>
                            </li>   
                        </ul>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">                        
                        <a class="btn btn-danger"  href="SesionesServlet?accion=cerrarSesion">Cerrar Sesión</a>
                    </div>
                </div>
            </nav>
            <center>
                <div class="card bg-light">
                    <div class="card-header text-center">
                        Información del instructor
                    </div>
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <strong>Id profesor: </strong>
                            <c:out value="${instructor.entidad.idProfesor}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Nombre: </strong>
                            <c:out value="${instructor.entidad.nombre}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Apellido Paterno:</strong>
                            <c:out value="${instructor.entidad.apPat}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Apellido Materno:</strong>
                            <c:out value="${instructor.entidad.apMat}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Calle:</strong>
                            <c:out value="${instructor.entidad.calle}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Número exterior:</strong>
                            <c:out value="${instructor.entidad.numExt}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Código postal:</strong>
                            <c:out value="${instructor.entidad.codPost}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Delegación: </strong>
                            <c:out value="${instructor.entidad.delegacion}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Teléfono:</strong>
                            <c:out value="${instructor.entidad.telefono}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Correo:</strong>
                            <c:out value="${instructor.entidad.correo}"/>
                        </li>
                        <li class="list-group-item">
                            <strong>Constraseña:</strong>
                            <c:out value="${instructor.entidad.pass}"/>
                        </li>
                    </ul>
                </div>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-center">                        
                        <a class="btn btn-warning"  href="#">Actualizar</a>
                    </div>
            </center>




        </div>
    </body>
</html>

