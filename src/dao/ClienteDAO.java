package dao;
import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private String url = "jdbc:sqlite:entregable.sqlite3";

    public void insertarCliente(Cliente c) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO clientes (name, email, telefono, edad, dineroGastado, productosComprados) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setInt(4, c.getEdad());
            pstmt.setDouble(5, c.getDineroGastado());
            pstmt.setInt(6, c.getProductosComprados());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCliente(Cliente c, int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "UPDATE clientes SET name = ?, email = ?, telefono = ?, edad = ?, dineroGastado = ?, productosComprados = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getTelefono());
            pstmt.setInt(4, c.getEdad());
            pstmt.setDouble(5, c.getDineroGastado());
            pstmt.setInt(6, c.getProductosComprados());
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void borrarCliente(int id) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Cliente obtenerCliente(int id) {
        Cliente cliente = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cliente;
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesMayores30() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes where edad > 30";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesGastoMayor500() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dineroGastado > 500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesOrdenadosPorGasto() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes ORDER BY dineroGastado DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> obtenerTop3ClientesPorProductos() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes ORDER BY productosComprados DESC LIMIT 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente cliente = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public double obtenerSumaTotalGastado() {
        double total = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT SUM(dineroGastado) FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return total;
    }

    public double obtenerMediaProductosComprados() {
        double media = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(productosComprados) FROM clientes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                media = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return media;
    }

    public double obtenerMediaGastadoMayores25MasDe3Productos() {
        double media = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT AVG(dineroGastado) FROM clientes WHERE edad > 25 AND productosComprados > 3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                media = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return media;
    }

    public int obtenerNumeroClientesGastoMayor100() {
        int total = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(*) FROM clientes WHERE dineroGastado > 100";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return total;
    }

    public int obtenerNumeroClientesEdadEntre30Y50() {
        int total = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT COUNT(*) FROM clientes WHERE edad BETWEEN 30 AND 50";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return total;
    }

    public List<Cliente> obtenerClientesGastoMayor200OrdenadosPorProductos() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dineroGastado > 200 ORDER BY productosComprados ASC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                Cliente c = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return clientes;
    }

    public Cliente obtenerClienteMasJovenGastoMayor400() {
        Cliente c = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM clientes WHERE dineroGastado > 400 ORDER BY edad ASC LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                int edad = rs.getInt("edad");
                double dineroGastado = rs.getDouble("dineroGastado");
                int productosComprados = rs.getInt("productosComprados");

                c = new Cliente(id, name, email, telefono, edad, dineroGastado, productosComprados);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return c;
    }
}