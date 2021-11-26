public class Producto {

    private int cantidadProducto;
    private int tipoProducto;
    private int precioProducto;

    public Producto(int tipo, int cantidad,int precio){
        tipoProducto = tipo;
        cantidadProducto = cantidad;
        precioProducto = precio;

    }

    public int getTipoProducto() { return tipoProducto; }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidadProducto(){ return cantidadProducto;}

    public void setCantidadProducto(int cantidadProducto) { this.cantidadProducto = cantidadProducto;}

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }
}
