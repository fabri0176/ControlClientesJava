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
        <title>Editar Cliente</title>
    </head>
    <body>

        <!-- Cabecero --->
        <jsp:include page="/WEB-INF/pages/comunes/cabecero.jsp"/>
        <!-- /Cabecero --->

        <form action="${pageContext.request.contextPath}/ServletControlador?action=modificar&id=${cliente.id}" method="POST">


            <!-- Botones de Navegación --->
            <jsp:include page="/WEB-INF/pages/comunes/botonesNavegacionEdicion.jsp"/>
            <!-- /Botones de Navegación --->
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="firstName">Nombre</label>
                                        <input type="text" class="form-control" name="firstName" required="" value="${cliente.firstName}">
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Apellidos</label>
                                        <input type="text" class="form-control" name="lastName" required="" value="${cliente.lastName}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" name="email" required="" value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">Télefono</label>
                                        <input type="text" class="form-control" name="phone" required="" value="${cliente.phone}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>
                                        <input type="number" class="form-control" name="saldo" required="" value="${cliente.saldo}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <!-- Footer --->
        <jsp:include page="/WEB-INF/pages/comunes/footer.jsp"/>
        <!-- /Footer --->
    </body>
</html>
