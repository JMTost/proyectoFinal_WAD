<%-- 
    Document   : estudianteFormulario
    Created on : 2 ene 2022, 19:18:34
    Author     : JMTN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Estudiante</title>
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
            
            <div class="card">
                <div class="card-header">
                    <h1 class="text-center">Datos del estudiante</h1>
                </div>
                <div class="card-body">
                    <c:if test="${modificar==1}">
                        <form method="post" action="EstudianteServlet?accion=guardarEstudiante&modificar=1">
                            <fieldset>
                                <legend>Información del estudiante</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id del estudiante</label>
                                    <input type="number" name="txtIdEstudiante" id="txtIdEstudiante" placeholder="Valor del ID" value="<c:out value="${estudiante.entidad.idEstudiante}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" name="txtNombreEstudiante" id="txtNombreEstudiante" placeholder="Nombre del estudiante" value="<c:out value="${estudiante.entidad.nombre}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido paterno</label>
                                    <input type="text" name="txtApPatEstudiante" id="txtApPatEstudiante" placeholder="Apellido paterno del estudiante" value="<c:out value="${estudiante.entidad.apPatE}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido materno</label>
                                    <input type="text" name="txtApMatEstudiante" id="txtApMatEstudiante" placeholder="Apellido materno del estudiante" value="<c:out value="${estudiante.entidad.apMatE}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Teléfono</label>
                                    <input type="text" name="txtTelEstudiante" id="txtTelEstudiante" placeholder="Teléfono del estudiante" value="<c:out value="${estudiante.entidad.telefono}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo electrónico</label>
                                    <input type="text" name="txtCorreoEstudiante" id="txtCorreoEstudiante" placeholder="Correo del estudiante " value="<c:out value="${estudiante.entidad.correo}"/>" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña</label>
                                    <input type="text" name="txtPassEstudiante" id="txtPassEstudiante" placeholder="Contraseña del estudiante" value="<c:out value="${estudiante.entidad.passEstudiante}"/>" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Fecha de nacimiento</label>
                                    <input type="date" name="txtFechaEstudiante" id="txtFechaEstudiante" placeholder="Fecha de nacimiento dd/mm/yyyy" value="<c:out value="${estudiante.entidad.fechaNacimiento}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                
                                
                                <button type="submit" class="btn btn-outline-primary">Guardar cambios</button>
                            </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="EstudianteServlet?accion=guardarEstudiante&modificar=0">
                            <fieldset>
                                <legend>Información del estudiante</legend>
                                <<div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" name="txtNombreEstudiante" id="txtNombreEstudiante" placeholder="Nombre del estudiante"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido paterno</label>
                                    <input type="text" name="txtApPatEstudiante" id="txtApPatEstudiante" placeholder="Apellido paterno del estudiante"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido materno</label>
                                    <input type="text" name="txtApMatEstudiante" id="txtApMatEstudiante" placeholder="Apellido materno del estudiante"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Teléfono</label>
                                    <input type="text" name="txtTelEstudiante" id="txtTelEstudiante" placeholder="Teléfono del estudiante"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo electrónico</label>
                                    <input type="text" name="txtCorreoEstudiante" id="txtCorreoEstudiante" placeholder="Correo del estudiante "  class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña</label>
                                    <input type="text" name="txtPassEstudiante" id="txtPassEstudiante" placeholder="Contraseña del estudiante"  class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Fecha de nacimiento</label>
                                    <input type="date" name="txtFechaEstudiante" id="txtFechaEstudiante" placeholder="Fecha de nacimiento dd/mm/yyyy"  class="form-control" required="required" />
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar estudiante</button>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>
            
        </div>
    </body>
</html>
