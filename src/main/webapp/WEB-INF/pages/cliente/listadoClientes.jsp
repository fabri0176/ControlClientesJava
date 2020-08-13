<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_CO"/>
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Email</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Saldo</th>
                            <th></th>
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
                                <td><fmt:formatNumber value="${cliente.saldo}" type="currency" /></td>
                                <td><a href="${pageContext.request.contextPath}/ServletControlador?action=editar&id=${cliente.id}"
                                       class="btn btn-secondary"><i class="fas fa-angle-double-right"></i> Editar</a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- Totales --->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency" />
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
            <!-- Totales --->
        </div>
    </div>
</section>

<!-- Modal agregar cliente --->
<jsp:include page="/WEB-INF/pages/cliente/addCliente.jsp"/>
<!-- /Modal agregar cliente --->
