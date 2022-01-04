<%-- 
    Document   : calificarAlumno
    Created on : 3 ene. 2022, 19:04:41
    Author     : FACTORING
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alumnos</title>
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
                            <li class="nav-item">
                                <a class="nav-link" href="CursosServlet?accion=listaDeCursos">Lista de cursos</a>
                            </li>                           
                            <li class="nav-item"><a class="nav-link" href="CursosServlet?accion=nuevoCurso">Crear curso</a></li>                            
                        </ul>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">                        
                        <a class="btn btn-danger"  href="SesionesServlet?accion=cerrarSesion">Cerrar Sesión</a>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card border-primary">
                <div class="card-header text-center">
                    Lista de Alumnos Curso ID(<c:out value="${IDCurso}"/>)
                </div>
                <div class="card-body container-fluid">
                    <h4 class="card-title">
                        
                    </h4>
                    
                    <form method="post" action="CursosServlet?accion=guardarcalificarEstudiante">
                            <fieldset>
                                <legend>Información de la calificación final</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id calificación final</label>
                                    <input type="number" name="txtIdCalFinal" id="txtIdCalFinal" placeholder="Valor del ID" value="<c:out value="${idCalF}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del curso</label>
                                    <input type="text" name="txtIdCurso" id="txtIdCurso" placeholder="Id del curso" value="<c:out value="${IdCurso}"/>" class="form-control" required="required"  readonly/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Id del estudiante</label>
                                    <input type="text" name="txtIdEstudiante" id="txtIdEstudiante"  value="<c:out value="${IdEstudiante}"/>" class="form-control" required="required"  readonly/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Calificación final</label>
                                    <input type="text" name="txtCalF" id="txtCalF"  value="<c:out value="${CaliF}"/>" class="form-control" required="required"  />
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar calificación final</button>
                            </fieldset>
                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
