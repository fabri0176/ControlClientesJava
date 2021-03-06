package web;

import datos.ClientesDaoJDBC;
import dominio.Clientes;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author fabricio
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            //Carga vista
            this.actionDefault(req, resp);
            return;
        }

        switch (action) {
            case "editar": {
                this.editarCliente(req, resp);
                break;
            }
            default: {
                this.actionDefault(req, resp);
            }
        }

        this.actionDefault(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            //Carga vista
            this.actionDefault(req, resp);
            return;
        }

        switch (action) {
            case "insertar": {
                this.insertarCliente(req, resp);
                break;
            }
            case "modificar": {
                this.modificarCliente(req, resp);
                break;
            }
            default: {
                this.actionDefault(req, resp);
            }
        }

        this.actionDefault(req, resp);
    }

    private double calcularSaldoTotal(List<Clientes> clientes) {
        double saldoTotal = 0;

        for (Clientes cliente : clientes) {

            saldoTotal += cliente.getSaldo();
        }

        return saldoTotal;
    }

    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Captura de datos
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //Saldo
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Crear cliente
        Clientes cliente = new Clientes(firstName, lastName, email, phone, saldo);

        //Guardar
        int registrosAlmacenados = new ClientesDaoJDBC().insertar(cliente);
        System.out.println("registrosAlmacenados = " + registrosAlmacenados);

    }

    private void actionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Clientes> clientes = new ClientesDaoJDBC().listar();

        //Carga vista
        //req.setAttribute("clientes", clientes);
        //req.setAttribute("totalClientes", clientes.size());
        //req.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //req.getRequestDispatcher("clientes.jsp").forward(req, resp);
        //Alcance mayor
        HttpSession sesion = req.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));

        resp.sendRedirect("clientes.jsp");
    }

    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));;

        //Buscar cliente
        Clientes cliente = new ClientesDaoJDBC().retrieve(new Clientes(id));
        if (cliente == null) {
            return;
        }

        req.setAttribute("cliente", cliente);
        String jspEdit = "WEB-INF/pages/cliente/editarCliente.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, resp);

    }

    public void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Captura de datos
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //Saldo
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Crear cliente
        Clientes cliente = new Clientes(id, firstName, lastName, email, phone, saldo);

        //Guardar
        int registrosActualizados = new ClientesDaoJDBC().actualizar(cliente);
        System.out.println("registrosActualizados = " + registrosActualizados);

    }
}
