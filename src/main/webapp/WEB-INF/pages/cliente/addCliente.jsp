<div id="agregarClienteModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?action=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="firstName">Nombre</label>
                        <input type="text" class="form-control" name="firstName" required="">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Apellidos</label>
                        <input type="text" class="form-control" name="lastName" required="">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required="">
                    </div>
                    <div class="form-group">
                        <label for="phone">Télefono</label>
                        <input type="text" class="form-control" name="phone" required="">
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>