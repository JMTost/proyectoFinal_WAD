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
                        <img src="Images/bootstrap-logo.svg" alt="logo" width="30" height="24" class="d-inline-block align-text-top">
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
                        <form method="post" action="AdminServlet?accion=almacenarInstructor&modificar=1">
                            <fieldset>
                                <legend>Información del instructor</legend>
                                <div class="mb-3">
                                    <label class="form-label">Id profesor</label>
                                    <input type="number" name="txtIdProfesor" id="txtIdProfesor" placeholder="Valor del ID" value="<c:out value="${instructor.entidad.idProfesor}"/>" class="form-control" readonly="readonly"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" name="txtNombreInstructor" id="txtNombreInstructor" placeholder="Nombre del instructor" value="<c:out value="${instructor.entidad.nombre}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido paterno</label>
                                    <input type="text" name="txtApPatInstructor" id="txtApPatInstructor" placeholder="Apellido paterno del instructor" value="<c:out value="${instructor.entidad.apPat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido materno</label>
                                    <input type="text" name="txtApMatInstructor" id="txtApMatInstructor" placeholder="Apellido materno del instructor" value="<c:out value="${instructor.entidad.apMat}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Calle</label>
                                    <input type="text" name="txtCalleInstructor" id="txtCalleInstructor" placeholder="Calle de tu domicilio" value="<c:out value="${instructor.entidad.calle}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Número exterior</label>
                                    <input type="number" name="txtNumExtInstructor" id="txtNumExtInstructor" placeholder="Número exterior de tu domicilio" value="<c:out value="${instructor.entidad.numExt}"/>" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Código postal</label>
                                    <input type="number" name="txtCodPostInstructor" id="txtCodPostInstructor" placeholder="Número exterior de tu domicilio" value="<c:out value="${instructor.entidad.codPost}"/>" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Delegación</label>
                                    <input type="text" name="txtDelegacionInstructor" id="txtDelegacionInstructor" placeholder="Delegación de tu domicilio" value="<c:out value="${instructor.entidad.delegacion}"/>" class="form-control" required="required" minlength="5" />
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">Teléfono</label>
                                    <input type="text" name="txtTelefonoInstructor" id="txtTelefonoInstructor" placeholder="Número de contacto" value="<c:out value="${instructor.entidad.telefono}"/>" class="form-control" required="required" minlength="9" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo electrónico</label>
                                    <input type="email" name="txtCorreoInstructor" id="txtCorreoInstructor" placeholder="Correo del instructor" value="<c:out value="${instructor.entidad.correo}"/>" class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña</label>
                                    <input type="text" name="txtPassInstructor" id="txtPassInstructor" placeholder="Contraseña" value="<c:out value="${instructor.entidad.pass}"/>" class="form-control" required="required" maxlength="16" minlength="5"/>
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar cambios</button>
                            </fieldset>
                        </form>
                    </c:if>
                    <c:if test="${modificar == 0}">
                        <form method="post" action="AdminServlet?accion=almacenarInstructor&modificar=0">
                            <fieldset>
                                <legend>Información del instructor</legend>
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" name="txtNombreInstructor" id="txtNombreInstructor" placeholder="Nombre del instructor" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido paterno</label>
                                    <input type="text" name="txtApPatInstructor" id="txtApPatInstructor" placeholder="Apellido paterno del instructor" class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido materno</label>
                                    <input type="text" name="txtApMatInstructor" id="txtApMatInstructor" placeholder="Apellido materno del instructor"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Calle</label>
                                    <input type="text" name="txtCalleInstructor" id="txtCalleInstructor" placeholder="Calle de tu domicilio"  class="form-control" required="required" minlength="5" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Número exterior</label>
                                    <input type="number" name="txtNumExtInstructor" id="txtNumExtInstructor" placeholder="Número exterior de tu domicilio"  class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Código postal</label>
                                    <input type="number" name="txtCodPostInstructor" id="txtCodPostInstructor" placeholder="Número exterior de tu domicilio"  class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Delegación</label>
                                    <input type="text" name="txtDelegacionInstructor" id="txtDelegacionInstructor" placeholder="Delegación de tu domicilio"  class="form-control" required="required" minlength="5" />
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">Teléfono</label>
                                    <input type="text" name="txtTelefonoInstructor" id="txtTelefonoInstructor" placeholder="Número de contacto"  class="form-control" required="required" minlength="9" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Correo electrónico</label>
                                    <input type="email" name="txtCorreoInstructor" id="txtCorreoInstructor" placeholder="Correo del instructor" v class="form-control" required="required" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Contraseña</label>
                                    <input type="text" name="txtPassInstructor" id="txtPassInstructor" placeholder="Contraseña" class="form-control" required="required" maxlength="16" minlength="5"/>
                                </div>
                                <button type="submit" class="btn btn-outline-primary">Guardar Instructor</button>
                            </fieldset>
                        </form>
                    </c:if>
                </div>
            </div>

        </div>
    </body>
</html>


