<%-- 
    Document   : registro
    Created on : 1 ene. 2022, 23:01:02
    Author     : FACTORING
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuarios</title>
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
                        <h1 class="center">Registro de Usuario</h1>
                    </div>
                    <c:if test="${ ifExiste}">
                        <div class="mb-3 text-center">
                            <div class="alert alert-danger" role="alert">
                                <h6 class="center">El Usuario registrado ya existe, intente con otro correo electronico</h6>
                            </div>
                        </div>
                    </c:if>
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
                                    <form  method="post" action="SesionesServlet?accion=registroAlumno">

                                        <div class="form-group">
                                            <label for="txtnombreE">Nombre : </label>
                                            <input type="text" name="txtnombreE" placeholder="Jason" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtapPatE">Apellido Paterno: </label>
                                            <input type="text" name="txtapPatE" placeholder="Doe" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtapMatE">Apellido Materno: </label>
                                            <input type="text" name="txtapMatE" placeholder="Doe" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtcorreo">Correo: </label>
                                            <input type="text" name="txtcorreo" placeholder="example@domain.com" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtpassEstudiante">Contraseña: </label>
                                            <input type="password" name="txtpassEstudiante" placeholder="Contraseña" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txttelefono">Telefono: </label>
                                            <input type="text" name="txttelefono" placeholder="12345678" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtfechaNacimiento">Fecha Nacimiento: : </label>
                                            <input type="date" name="txtfechaNacimiento" placeholder="Jason Doe" required class="form-control" required>
                                        </div>
                                        <br>

                                        <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm"> Registrarse  </button>
                                    </form>
                                </div>
                                <!-- End -->
                                <div id="nav-tab-profesor" class="tab-pane fade">

                                    <form role="form" method="post" action="SesionesServlet?accion=registroProfesor" >

                                        <div class="form-group">
                                            <label for="txtNombreInstructor">Nombre : </label>
                                            <input type="text" name="txtNombreInstructor" id="txtNombreInstructor" placeholder="Jason" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtApPatInstructor">Apellido Paterno: </label>
                                            <input type="text" name="txtApPatInstructor" id="txtApPatInstructor" placeholder="Doe" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtApMatInstructor">Apellido Materno: </label>
                                            <input type="text" name="txtApMatInstructor" id="txtApMatInstructor" placeholder="Doe" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtCorreoInstructor">Correo: </label>
                                            <input type="text" name="txtCorreoInstructor" id="txtCorreoInstructor" placeholder="example@domain.com" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtPassInstructor">Contraseña: </label>
                                            <input type="password" name="txtPassInstructor" id="txtPassInstructor" placeholder="Contraseña" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtTelefonoInstructor">Telefono: </label>
                                            <input type="number" name="txtTelefonoInstructor" id="txtTelefonoInstructor" placeholder="12345678" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtCalleInstructor">Calle: </label>
                                            <input type="text" name="txtCalleInstructor" id="txtCalleInstructor" placeholder="Madera" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtNumExtInstructor">Num. Exterior: </label>
                                            <input type="number" name="txtNumExtInstructor" id="txtNumExtInstructor" placeholder="456" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtCodPostInstructor">C.P: </label>
                                            <input type="number" name="txtCodPostInstructor" id="txtCodPostInstructor" placeholder="08400" required class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="txtDelegacionInstructor">Delegación: </label>
                                            <input type="text" name="txtDelegacionInstructor" id="txtDelegacionInstructor" placeholder="Benito Juarez" required class="form-control" required>
                                        </div>
                                        <br>                          
                                        <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm"> Registrarse  </button>
                                    </form>
                                </div>
                                <!-- End -->
                            </div>
                            <!-- End -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
