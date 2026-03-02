

public class  TallerInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(5);

        inventario.agregarProducto(new Producto(1, "Laptop", 2500, 3));
        inventario.agregarProducto(new Producto(2, "Mouse", 50, 20));
        inventario.agregarProducto(new Producto(3, "Teclado", 1, 2));
        inventario.agregarProducto(new Producto(4, "Monitor", 300, 5));

        System.out.println("=== Inventario ===");
        inventario.mostrarInventario();

        System.out.println("\nValor total: " + inventario.generarInformeValorTotal());

        System.out.println("\nOrdenado por precio (descendente):");
        inventario.ordenarPorPrecioDescendente();
        inventario.mostrarInventario(); // ahora sí verás la lista ordenada
    }
}
