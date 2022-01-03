<%-- 
    Document   : bienvenida
    Created on : 1 ene 2022, 16:30:14
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DashBoard Profesor</title>
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
                                <a class="nav-link active" href="./bienvenida.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">Lista de cursos</a>
                            </li>                           
                            <li class="nav-item"><a class="nav-link" href="./../CursosServlet?accion=nuevoCurso">Crear curso</a></li>
                            <li class="nav-item"><a class="nav-link" href="./../CalificacionesParcialesServlet?accion=nuevaCalP">Subir calificación p</a></li>
                            <li class="nav-item"><a class="nav-link" href="./../CalificacionesFinalServlet?accion=nuevaCalificacionF">Subir calificación f</a></li>
                            <li class="nav-item"><a class="nav-link" href="./../DireccionCursoServlet?accion=nuevaDireccionC">Crear un nuevo enlace</a></li>
                        </ul>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">                        
                        <button class="btn btn-danger" type="btn " href="SesionesServlet?accion=cerrarSesion">Cerrar Sesión</button>
                    </div>
                </div>
            </nav>
            <div class="mb-5"></div>
            <c:if test="${mensaje != null}">
                <div class="alert alert-dark alert-dismissible fade show" role="alert">
                    <strong>${mensaje}</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" arial-label="Close"></button>
                </div>
                <div class="mb-3"></div>
            </c:if>
            <div class="card text-dark bg-light mb-3" style="max-width: 100%;">
                <div class="card-header" style="text-align: center;"><h1>¡Bienvenido!</h1></div>
                <div class="card-body">
                    <h4>En este apartado podrá realizar las modificaciones, creaciones y cursos, los cuales usted impartirá</h4>
                    <p class="card-text">Aquí se mostrarán los enlaces a los partados donde usted podrá realizar sus operaciones: </p>
                    <br>
                    <ul class="list-group list-group-horizontal" >
                        <li style="list-style-type: none;"><a class="list-group-item" href="./../CursosServlet?accion=nuevoCurso">Crear nuevo curso</a></li>
                        <li style="list-style-type: none;"><a class="list-group-item" href="./../InstructorServlet?accion=nuevaCalP">Subir calificación parcial</a></li>
                        <li style="list-style-type: none;"><a class="list-group-item" href="./../InstructorServlet?accion=nuevaCalificacionF">Subir calificación final</a></li>
                        <li style="list-style-type: none;"><a class="list-group-item" href="./../DireccionCursoServlet?accion=nuevaDireccionC">Crear un nuevo enlace para la videollamada</a></li>
                    </ul>      
                    <ul class="list-group list-group-horizontal">
                        <li style="list-style-type: none;"><a class="list-group-item" href="./../InstructorServlet?accion=mostrarInstr&id=1">Mostar mis datos</a></li>
                        
                    </ul>      
                    <div class="mb-3"></div>
                    <p>Si desea realizar una modificación de sus datos, favor de realizar un correo a <a class="link-dark" href="mailto:max.55@live.com.mx">max.55@live.com.mx</a>, el cual es el administrador del sistema, en el asunto deberá colocar <span class="" style="text-decoration: underline;">"modificación de datos - Instructor"</span> listando que datos desea modificar y sobre todo mandando su correo en el cual ingresa al sistema.</p>
                    <p>Gracias por su comprensión</p>
                    <p>
                        <c:out value="${Nombre}"/>
                        <c:out value="${Paterno}"/>
                        
                        <c:out value="${ID}"/>
                    </p>
                </div>
            </div>
            <!--
            <a href="./../InstructorServlet?accion=listaDeInstructores" class="btn btn-outline-secondary">Prueba</a>
            -->

        </div>
    </body>
</html>

