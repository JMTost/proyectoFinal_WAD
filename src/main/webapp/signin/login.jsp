<%-- 
    Document   : login
    Created on : 2 ene. 2022, 16:10:10
    Author     : FACTORING
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" ></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" ></script>
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })
        </script>
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
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="#" href="index.jsp">Home</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="container">
            <div class="container py-5">
                <!-- For demo purpose -->
                <div class="row mb-4">
                    <div class="col-lg-8 mx-auto text-center">
                        <h1 class="center">Inicio Sesion</h1>
                    </div>

                </div>
                <!-- End -->
                <div class="row">
                    <div class="col-lg-7 mx-auto">
                        <div class="bg-white rounded-lg shadow-sm p-5">
                            <!-- Credit card form tabs -->
                            <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">
                                <li class="nav-item">
                                    <a data-toggle="pill" href="#nav-tab-alumno" class="nav-link active rounded-pill">
                                        <i class="fa fa-credit-card"></i>
                                        Alumno
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a data-toggle="pill" href="#nav-tab-profesor" class="nav-link rounded-pill">
                                        <i class="fa fa-paypal"></i>
                                        Profesor
                                    </a>
                                </li>
                            </ul>
                            <!-- End -->
                            <!-- Credit card form content -->
                            <div class="tab-content">
                                <!-- credit card info-->
                                <div id="nav-tab-alumno" class="tab-pane fade show active">
                                    <form role="form" method="post" action="SesionesServlet?accion=inicioSesionAlumno" >

                                        <div class="form-group">
                                            <label for="txtCorreoInstructor">Correo: </label>
                                            <input type="text" name="txtCorreoAlumno" id="txtCorreoInstructor" placeholder="example@domain.com" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtPassInstructor">Contraseña: </label>
                                            <input type="password" name="txtPassAlumno" id="txtPassInstructor" placeholder="Contraseña" required class="form-control" required>
                                        </div>                                        
                                        <br>                          
                                        <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm"> Iniciar Sesion  </button>
                                    </form>
                                </div>
                                <!-- End -->
                                <div id="nav-tab-profesor" class="tab-pane fade">

                                    <form role="form" method="post" action="SesionesServlet?accion=inicioSesionProfesor" >

                                        <div class="form-group">
                                            <label for="txtCorreoInstructor">Correo: </label>
                                            <input type="text" name="txtCorreoInstructor" id="txtCorreoInstructor" placeholder="example@domain.com" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtPassInstructor">Contraseña: </label>
                                            <input type="password" name="txtPassInstructor" id="txtPassInstructor" placeholder="Contraseña" required class="form-control" required>
                                        </div>                                        
                                        <br>                       

                                        <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm"> Iniciar Sesion  </button>
                                    </form>
                                </div>
                                <br>
                                <br>
                                <!-- End -->
                                <div class="alert alert-primary" role="alert">
                                    Unete con nosotros: <a href="SesionesServlet?accion=registro" class="alert-link">Registrate</a>.
                                </div>
                            </div>
                            <!-- End -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
