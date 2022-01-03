<%-- 
    Document   : calificacionesForm
    Created on : 2 ene 2022, 19:14:22
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fomulario de inserción de calificación final</title>
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
                                <a class="nav-link active" aria-current="#" href="./../instructores/bienvenida.jsp">Home</a>
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
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center">Datos de la calificación final</h1>
                </div>
                <div class="card-body">
                    <c:if test="${modificar==1}">
                        <form method="post" action="CalificacionesFinalServlet?accion=guardarCalificacionF&modificar=1">
                            <fieldset>
                                <legend>Información de la calificación final</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id calificación final</label>
                                    <input type="number" name="txtIdCalFinal" id="txtIdCalFinal" placeholder="Valor del ID" value="<c:out value="${calF.entidad.idProfesor}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Id del curso" value="<c:out value="${calF.entidad.nombre}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del estudiante</label>
                                    <input type="text" name="txtIdEstudiante" id="txtIdEstudiante" placeholder="Apellido paterno del instructor" value="<c:out value="${calF.entidad.apPat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Calificación final</label>
                                    <input type="text" name="txtCalF" id="txtCalF" placeholder="Apellido materno del instructor" value="<c:out value="${calF.entidad.apMat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                
                                
                                <button type="submit" class="btn btn-outline-primary">Guardar cambios</button>
                            </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="CalificacionesFinalServlet?accion=guardarCalificacionF&modificar=0">
                            <fieldset>
                                <legend>Información de la calificación final</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id del curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Id del curso" value="<c:out value="${calF.entidad.nombre}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del estudiante</label>
                                    <input type="text" name="txtIdEstudiante" id="txtIdEstudiante" placeholder="Apellido paterno del instructor" value="<c:out value="${calF.entidad.apPat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Calificación final</label>
                                    <input type="text" name="txtCalF" id="txtCalF" placeholder="Apellido materno del instructor" value="<c:out value="${calF.entidad.apMat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar calificación final</button>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>
            
        </div>
    </body>
</html>
