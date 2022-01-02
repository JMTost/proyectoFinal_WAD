<%-- 
    Document   : bienvenida
    Created on : 1 ene 2022, 16:30:14
    Author     : JMTN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDEX Proyecto WAD</title>
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
            <div class="mb-5"></div>
            <div class="card text-dark bg-light mb-3" style="max-width: 100%;">
                <div class="card-header" style="text-align: center;"><h1>¡Bienvenido!</h1></div>
                <div class="card-body">
                    <h4>En este apartado podrá realizar las modificaciones, creaciones y cursos, los cuales usted impartirá</h4>
                    <p class="card-text">Aquí se mostrarán los enlaces a los partados donde usted podrá realizar sus operaciones: </p>
                    <ul class="list-group list-group-horizontal" >
                        <li><a class="list-group-item" href="#">Crear nuevo curso</a></li>
                        <li><a class="list-group-item" href="#">Lista de mis cursos</a></li>
                        <li><a class="list-group-item" href="#">Actualizar mis datos</a></li>
                    </ul>
                </div>
            </div>
            
            <a href="./../InstructorServlet?accion=listaDeInstructores" class="btn btn-outline-secondary">Prueba</a>


        </div>
    </body>
</html>

