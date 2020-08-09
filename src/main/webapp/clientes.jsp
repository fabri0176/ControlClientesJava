<%--
    Document   : clientes
    Created on : 9 ago. 2020, 18:39:44
    Author     : fabricio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Clientes</title>
    </head>
    <body>
        <h1>Control de Clientes</h1>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.firstName}</td>
                        <td>${cliente.lastName}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.phone}</td>
                        <td>${cliente.saldo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
