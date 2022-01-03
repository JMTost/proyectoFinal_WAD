<%-- 
    Document   : direccionesCursosFormulario
    Created on : 2 ene 2022, 19:21:52
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario para direcciones de cursos</title>
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
            
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center">Datos de la dirección de cursos</h1>
                </div>
                <div class="card-body">
                    <c:if test="${modificar==1}">
                        <form method="post" action="DireccionCursoServlet?accion=guardarDireccionC&modificar=1">
                            <fieldset>
                                <legend>Información de la dirección de cursos</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id de la dirección</label>
                                    <input type="number" name="txtIdDirCursos" id="txtIdDirCursos" placeholder="Valor del ID de la direccion" value="<c:out value="${direccion.entidad.idDir}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del Curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Valor del ID del curso" value="<c:out value="${direccion.entidad.idCurso}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del profesor</label>
                                    <input type="number" name="txtIdProfesor" id="txtIdProfesor" placeholder="Valor del ID del profesor" value="<c:out value="${direccion.entidad.idProfesor}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre de la plataforma</label>
                                    <input type="text" name="txtNombrePlat" id="txtNombrePlat" placeholder="Nombre de la plataforma" value="<c:out value="${direccion.entidad.nombrePlat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Enlace de la llamada</label>
                                    <input type="text" name="txtEnlaceLlamada" id="txtEnlaceLlamada" placeholder="Enlace de la llamada" value="<c:out value="${direccion.entidad.linkLlamada}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña de la llamada</label>
                                    <input type="number" name="txtPassLlamada" id="txtPassLlamada" placeholder="Contraseña de la llamada" value="<c:out value="${direccion.entidad.passLlamada}"/>" class="form-control" required="required" />
                                </div>
                                
                                <button type="submit" class="btn btn-outline-primary">Guardar cambios</button>
                            </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="DireccionCursoServlet?accion=guardarDireccionC&modificar=0">
                            <fieldset>
                                <legend>Información de la dirección del curso</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id del Curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Valor del ID del curso"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del profesor</label>
                                    <input type="number" name="txtIdProfesor" id="txtIdProfesor" placeholder="Valor del ID del profesor"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre de la plataforma</label>
                                    <input type="text" name="txtNombrePlat" id="txtNombrePlat" placeholder="Nombre de la plataforma"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Enlace de la llamada</label>
                                    <input type="text" name="txtEnlaceLlamada" id="txtEnlaceLlamada" placeholder="Enlace de la llamada"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña de la llamada</label>
                                    <input type="number" name="txtPassLlamada" id="txtPassLlamada" placeholder="Contraseña de la llamada"  class="form-control" required="required" />
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar dirección del curso</button>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>
            
        </div>
    </body>
</html>
