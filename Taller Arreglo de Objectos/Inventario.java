public class Inventario {

    private Producto[] productos;
    private int capacidad;
    private int contador; // controla posiciones ocupadas

    // Constructor
    public Inventario(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new Producto[capacidad];
        this.contador = 0;
    }

    // Metodo de agregar producto
    public void agregarProducto(Producto p) {
        if (contador < capacidad) {
            productos[contador] = p;
            contador++;
        } else {
            System.out.println("Inventario lleno. No se puede agregar más productos.");
        }
    }

    // Buscar por ID
    public Producto buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getId() == id) {
                return productos[i];
            }
        }
        return null;
    }

    // Actualizar stock
    public void actualizarStock(int id, int nuevaCantidad) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setCantidadStock(nuevaCantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Generar informe valor total
    public double generarInformeValorTotal() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio() * productos[i].getCantidadStock();
        }
        return total;
    }

    //  Obtener productos agotados (stock < 5)
    public Producto[] obtenerProductosAgotados() {

        int cantidad = 0;

        // Primero contamos cuántos cumplen condición
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCantidadStock() < 5) {
                cantidad++;
            }
        }

        Producto[] agotados = new Producto[cantidad];
        int j = 0;

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCantidadStock() < 5) {
                agotados[j] = productos[i];
                j++;
            }
        }

        return agotados;
    }

    // Ordenar por precio descendente 
    public void ordenarPorPrecioDescendente() {

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {

                if (productos[j].getPrecio() < productos[j + 1].getPrecio()) {

                    // Intercambio
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
    }


 // Ordenar por precio ascendente 
    public void ordenarPorPrecioeasendente() {

        for (int i = 0; i <contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {

                if (productos[j].getPrecio() < productos[j + 1].getPrecio()) {

                    // Intercambio
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
    }



    // Método para mostrar inventario
    public void mostrarInventario() {
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i]);
        }
    }
}