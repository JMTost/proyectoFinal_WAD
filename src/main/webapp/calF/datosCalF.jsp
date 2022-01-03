<%-- 
    Document   : datosCalF
    Created on : 2 ene 2022, 19:14:41
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de calificación final</title>
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
                                <a class="nav-link" href="">Cerrar sesión</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <center>
                <div class="card bg-light">
                    <div class="card-header text-center">
                        Información de la calificación final
                    </div>
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            Id calificación:  
                            <c:out value="${calF.entidad.idCalFinal}"/>
                        </li>
                        <li class="list-group-item">
                            Id del curso:  
                            <c:out value="${calF.entidad.idCurso}"/>
                        </li>
                        <li class="list-group-item">
                            Nombre del curso:  
                            <c:out value="${curso.entidad.nombreCurso}"/>
                        </li>
                        <li class="list-group-item">
                            ID del estudiante:  
                            <c:out value="${est.entidad.idEstudiante}"/>
                        </li>
                        <li class="list-group-item">
                            Nombre del estudiante:  
                            <c:out value="${est.entidad.nombre}"/> <c:out value="${est.entidad.apPatE}"/> <c:out value="${est.entidad.apMatE}"/>
                        </li>
                        <li class="list-group-item">
                            Calificación final:
                            <c:out value="${calF.entidad.calF}"/> 
                        </li>
                    </ul>
                </div>
            </center>
        </div>
    </body>
</html>
