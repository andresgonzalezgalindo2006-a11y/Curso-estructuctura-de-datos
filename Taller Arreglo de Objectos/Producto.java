

public class Producto {
int Id;
String nombre;
double precio;
int cantidadStock;

//metodo constructor, metodos getters/setters y el metodo toString
public Producto(int id, String nombre, double precio, int cantidadStock) {
    Id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.cantidadStock = cantidadStock;
}

public void setId(int id) {
    Id = id;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setPrecio(double precio) {
    this.precio = precio;
}

public void setCantidadStock(int cantidadStock) {
    this.cantidadStock = cantidadStock;
}

public int getId() {
    return Id;
}

public String getNombre() {
    return nombre;
}

public double getPrecio() {
    return precio;
}

public int getCantidadStock() {
    return cantidadStock;
}

@Override
public String toString() {
    return "Producto [Id=" + Id + ", nombre=" + nombre + ", precio=" + precio + ", cantidadStock=" + cantidadStock
            + "]";
}





    
}
