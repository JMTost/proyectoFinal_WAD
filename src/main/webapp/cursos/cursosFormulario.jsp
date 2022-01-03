<%-- 
    Document   : cursosFormulario
    Created on : 2 ene 2022, 19:19:15
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de creación de curso</title>
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
                        </ul>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">                        
                        <a class="btn btn-danger"  href="SesionesServlet?accion=cerrarSesion">Cerrar Sesión</a>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center">Curso</h1>
                </div>
                <div class="card-body">
                    <c:if test="${modificar==1}">
                        <form method="post" action="CursosServlet?accion=guardarCurso&modificar=1">
                            <fieldset>
                                <legend>Información del curso</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id del curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Valor del ID" value="<c:out value="${curso.entidad.idCurso}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre del curso</label>
                                    <input type="text" name="txtNombreCurso" id="txtNombreCurso" placeholder="Nombre del curso" value="<c:out value="${curso.entidad.nombreCurso}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del profesor</label>
                                    <input type="text" name="txtIdProfesor" id="txtIdProfesor" placeholder="Id del profesor" value="<c:out value="${curso.entidad.idProfesor}"/>" class="form-control" required="required" minlength="5" readonly/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Descripción</label>
                                    <input type="text" name="txtDescCurso" id="txtDescCurso" placeholder="Descripción del curso" value="<c:out value="${curso.entidad.descripcion}"/>" class="form-control" required="required" minlength="5" />
                                </div>

                                <button type="submit" class="btn btn-outline-primary">Guardar cambios</button>
                            </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="CursosServlet?accion=guardarCurso&modificar=0">
                            <fieldset>
                                <legend>Información del curso</legend>

                                <div class="mb-3">
                                    <label class="form-label">Nombre del curso</label>
                                    <input type="text" name="txtNombreCurso" id="txtNombreCurso" placeholder="Nombre del curso" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del profedor</label>
                                    <input type="text" name="txtIdProfesor" id="txtIdProfesor" placeholder="Id del profesor"  class="form-control" required="required" minlength="5" value="<c:out value="${IDProfe}"/>" readonly/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Descripción</label>
                                    <input type="text" name="txtDescCurso" id="txtDescCurso" placeholder="Descripción del curso" class="form-control" required="required" minlength="5" />
                                </div>

                                <button type="submit" class="btn btn-outline-primary">Guardar curso</button>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>

        </div>
    </body>
</html>
