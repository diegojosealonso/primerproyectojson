import dao.ClienteDAO;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        Cliente terry = new Cliente(0, "Terry", "terry@email.com", "123456789", 20, 300.0, 5);
        dao.insertarCliente(terry);
        System.out.println("Cliente insertado: " + terry.getName());

        List<Cliente> todosClientes = dao.obtenerClientes();
        int idNuevo = todosClientes.getLast().getId();

        terry.setName("Brandon");
        terry.setDineroGastado(999.0);
        dao.actualizarCliente(terry, idNuevo);
        System.out.println("Cliente: " + terry.getName() + " actualizado");

        dao.borrarCliente(idNuevo);
        System.out.println("Cliente con id: " + idNuevo + " borrado");


        Cliente clientePorId = dao.obtenerCliente(1);
        System.out.println("Cliente con id 1: " + clientePorId.getName());

        List<Cliente> clientes = dao.obtenerClientes();
        System.out.println("Todos los clientes:");
        for (Cliente cl : clientes) {
            System.out.println(cl.getName());
        }

        List<Cliente> mayores30 = dao.obtenerClientesMayores30();
        System.out.println("Clientes mayores de 30:");
        for (Cliente cl : mayores30) {
            System.out.println(cl.getName() + ", edad: " + cl.getEdad());
        }

        List<Cliente> gastoMayor500 = dao.obtenerClientesGastoMayor500();
        System.out.println("Clientes que han gastado más de 500€:");
        for (Cliente cl : gastoMayor500) {
            System.out.println(cl.getName() + ", gastado: " + cl.getDineroGastado());
        }

        List<Cliente> ordenadosPorGasto = dao.obtenerClientesOrdenadosPorGasto();
        System.out.println("Clientes ordenados por gasto (mayor a menor):");
        for (Cliente cl : ordenadosPorGasto) {
            System.out.println(cl.getName() + ", gastado: " + cl.getDineroGastado());
        }

        List<Cliente> top3 = dao.obtenerTop3ClientesPorProductos();
        System.out.println("Top 3 clientes por productos comprados:");
        for (Cliente cl : top3) {
            System.out.println(cl.getName() + ", productos: " + cl.getProductosComprados());
        }

        double sumaTotal = dao.obtenerSumaTotalGastado();
        System.out.println("Suma total gastada: " + sumaTotal + "€");

        double mediaProductos = dao.obtenerMediaProductosComprados();
        System.out.println("Media de productos comprados: " + mediaProductos);

        double mediaGastado = dao.obtenerMediaGastadoMayores25MasDe3Productos();
        System.out.println("Media gastada (por clientes mayores de 25 que han comprado más de 3 productos): " + mediaGastado + "€");

        int numGastoMayor100 = dao.obtenerNumeroClientesGastoMayor100();
        System.out.println("Clientes que han gastado más de 100€: " + numGastoMayor100);

        int numEdadEntre30Y50 = dao.obtenerNumeroClientesEdadEntre30Y50();
        System.out.println("Clientes con edad entre 30 y 50: " + numEdadEntre30Y50);

        List<Cliente> gastoMayor200 = dao.obtenerClientesGastoMayor200OrdenadosPorProductos();
        System.out.println("Clientes con gasto > 200€ ordenados por productos (menor a mayor):");
        for (Cliente cl : gastoMayor200) {
            System.out.println(cl.getName() + ", productos: " + cl.getProductosComprados());
        }

        Cliente masJoven = dao.obtenerClienteMasJovenGastoMayor400();
        System.out.println("Cliente más joven con gasto > 400€: " + masJoven.getName() + ", edad: " + masJoven.getEdad());
    }
}