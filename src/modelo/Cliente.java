package modelo;

public class Cliente {
    private int id;
    private String name;
    private String email;
    private String telefono;
    private int edad;
    private double dineroGastado;
    private int productosComprados;

    public Cliente() {
    }

    public Cliente(int id, String name, String email, String telefono, int edad, double dineroGastado, int productosComprados) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.dineroGastado = dineroGastado;
        this.productosComprados = productosComprados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDineroGastado() {
        return dineroGastado;
    }

    public void setDineroGastado(double dineroGastado) {
        this.dineroGastado = dineroGastado;
    }

    public int getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(int productosComprados) {
        this.productosComprados = productosComprados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                ", dineroGastado=" + dineroGastado +
                ", productosComprados=" + productosComprados +
                '}';
    }
}
