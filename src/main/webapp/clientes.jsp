<%--
    Document   : clientes
    Created on : 9 ago. 2020, 18:39:44
    Author     : fabricio
--%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/37686cd5ae.js" crossorigin="anonymous"></script>
        <title>Control Clientes</title>
    </head>
    <body>

        <!-- Cabecero --->
        <jsp:include page="/WEB-INF/pages/comunes/cabecero.jsp"/>
        <!-- /Cabecero --->

        <!-- Botones Navgeaciones --->
        <jsp:include page="/WEB-INF/pages/comunes/botonesNavegacion.jsp"/>
        <!-- /Botones Navgeaciones --->

        <!-- Listado Clientes --->
        <jsp:include page="/WEB-INF/pages/cliente/listadoClientes.jsp"/>
        <!-- /Listado Clientes --->

        <!-- Optional JavaScript -->



        <!-- Footer --->
        <jsp:include page="/WEB-INF/pages/comunes/footer.jsp"/>
        <!-- /Footer --->



    </body>
</html>
