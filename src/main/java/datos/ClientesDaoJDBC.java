/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Clientes;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabricio
 */
public class ClientesDaoJDBC {

    private static final String SQL_SELECT = "SELECT id, firstName, lastName, email, phone, saldo "
            + " FROM clientes "
            + " WHERE 1 ";

    private static final String SQL_SELECT_BY_ID = SQL_SELECT + " AND id = ?";

    private static final String SQL_INSERT = "INSERT INTO `clientes`(`firstName`, `lastName`, `email`, `phone`, `saldo`) "
            + " VALUES (?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE `clientes` "
            + "SET `firstName`= ?,`lastName`= ?,`email`= ?,`phone`= ?,`saldo`= ? "
            + "WHERE id = ?";

    private static final String SQL_DELETE = "DELETE FROM `clientes` WHERE id = ?";

    public List<Clientes> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;
        List<Clientes> clientes = new ArrayList<>();
        try {

            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double saldo = rs.getDouble("saldo");
                cliente = new Clientes(id, firstName, lastName, email, phone, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Clientes retrieve(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getId());

            rs = stmt.executeQuery();

            rs.absolute(1);//Posicionamiento registro 1

            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double saldo = rs.getDouble("saldo");

            cliente.setEmail(email);
            cliente.setFirstName(firstName);
            cliente.setLastName(lastName);
            cliente.setPhone(phone);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertar(Clientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, cliente.getFirstName());
            stmt.setString(2, cliente.getLastName());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getPhone());
            stmt.setDouble(5, cliente.getSaldo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizar(Clientes cliente) {
        int rows = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getFirstName());
            stmt.setString(2, cliente.getLastName());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getPhone());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminar(Clientes cliente) {
        int rows = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

}
