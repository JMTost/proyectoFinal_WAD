<%-- 
    Document   : dashboardEstudainte
    Created on : 2 ene. 2022, 18:09:32
    Author     : FACTORING
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard Estudiante</title>
    </head>
    <body>
        <h1>Hola Estudiante</h1><c:out value="${Nombre}"/> <c:out value="${Paterno}"/>
    </body>
</html>
