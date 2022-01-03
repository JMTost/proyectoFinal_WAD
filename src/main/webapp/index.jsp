<%-- 
    Document   : index
    Created on : 30 dic 2021, 19:57:21
    Author     : JMTN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGC WAD</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" ></script>
        <link href="./estilos/index.css"  rel="stylesheet" type="text/css"></link>

    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./Images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Cursos
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">                        
                        <ul class="navbar-nav">
                        </ul>
                        <ul class="nav justify-content-end">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="#" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"> | </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">  </a>
                            </li>
                            <li class="nav-item">
                                <div class="btn-group align-center" role="group" aria-label="Basic example">
                                    <a type="button" class="btn btn-primary" class="nav-link" href="SesionesServlet?accion=inicioSesion">Inicio de sesion</a>
                                    <a type="button" class="btn btn-primary" class="nav-link" href="SesionesServlet?accion=registro">Registrate</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <br>
            <br>
            <br>
            <center>
                <section id="slideshow">
                    <section id="content">
                        <center>
                            <h1 class="header">Bienvenido</h1>
                        </center>
                        <h3 class="subHeader">Sistema de gestión de cursos</h3>
                    </section>
                    <img id="img_index" class="img-fluid rounded mx-auto d-block" src="./Images/IMGprincipal_indexjpg.jpg" alt="IMG_curso"/>
                </section>
            </center>
            <br>
            <br>            
            <div class="container">
                <center>
                    <p>Sistema de Apoyo para la gestión de datos en las materias inscritas actualmente</p>                    
                </center>
            </div>


        </div>
    </body>
</html>
