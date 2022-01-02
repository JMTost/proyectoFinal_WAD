<%-- 
    Document   : profesoresFormulario
    Created on : 1 ene 2022, 18:57:54
    Author     : JMTN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de creación de instructor</title>
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
                        <img src="../Images/bootstrap-logo.svg" alt="logo" width="30" height="24" class="d-inline-block align-text-top">
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
            
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center">Datos de instructor</h1>
                </div>
                <div class="card-body">
                    <c:if test="${modificar==1}">
                        <form method="post" action="HorariosServlet?accion=almacenarHorarios&modificar=1&idCurso=<c:out value="${idCurso}"/>&idProfesor=<c:out value="${idProfesor}"/>&idHorario=<c:out value="${idHorario}"/>">
                            <fieldset>
                                <legend>Detalles del Curso</legend>
                                <div class="mb-3">
                                    <label class="form-label">Actualiza tu horario</label>
                                    <input type="text" name="txtHora" id="txtNombreInstructor" placeholder="Nombre del instructor" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Actualiza la plataforma de tus clases</label>
                                    <input type="text" name="txtNombrePlataforma" id="txtNombrePlataforma" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">¿El curso sigue disponible? (true, false)</label>
                                    <input type="text" name="txtDisponible" id="txtDesponible" class="form-control" required="required" />
                                </div>
                                </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="HorariosServlet?accion=almacenarHorarios&modificar=0&idCurso=<c:out value="${idCurso}"/>&idProfesor=<c:out value="${idProfesor}"/>">
                            <fieldset>
                                <legend>Descripción del curso</legend>
                                <div class="mb-3">
                                    <label class="form-label">Horas disponible</label>
                                    <input type="text" name="txtHora" id="txtNombreInstructor" placeholder="Nombre del instructor" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Plataforma para las clases</label>
                                    <input type="text" name="txtNombrePlataforma" id="txtNombrePlataforma" class="form-control" required="required" />
                                </div>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>

        </div>
    </body>
</html>


