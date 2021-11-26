import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hilo implements Runnable    {

    ArrayList<Producto> listaProductos;


    public Hilo(ArrayList<Producto> listaProductos){

        this.listaProductos = listaProductos;

    }

    public int importeTotalVendido(int tipoProducto){

        int resultado = 0;

        for(int i = 0; i < listaProductos.size(); i++){

            Producto oProducto = listaProductos.get(i);
            if (oProducto.getTipoProducto() == tipoProducto) {
                resultado += listaProductos.get(i).getPrecioProducto();
            }
        }

        return resultado;
    }

    public int cantidadProductosVendidos(int tipoProducto){

        int resultado = 0;

        for(int i = 0; i < listaProductos.size(); i++){
            Producto oProducto = listaProductos.get(i);
            if (oProducto.getTipoProducto() == tipoProducto) {
                resultado += listaProductos.get(i).getCantidadProducto();
            }
        }

        return resultado;
    }


    @Override
    public void run() {
        int cantidadProductosTipo1;
        int importeTotalTipo1;
        int cantidadProductosTipo2;
        int importeTotalTipo2;
        int cantidadProductosTipo3;
        int importeTotalTipo3;

        cantidadProductosTipo1 = cantidadProductosVendidos(1);
        importeTotalTipo1 = importeTotalVendido(1);
        cantidadProductosTipo2 = cantidadProductosVendidos(2);
        importeTotalTipo2 = importeTotalVendido(2);
        cantidadProductosTipo3 = cantidadProductosVendidos(3);
        importeTotalTipo3 = importeTotalVendido(3);


        System.out.println("Para el tipo de producto 1: Cantidad de productos vendidos: " + cantidadProductosTipo1 + " Importe total: " + importeTotalTipo1 + " || Para el tipo de producto 2: Cantidad de productos vendidos: " + cantidadProductosTipo2 + " Importe total: " + importeTotalTipo2 + " || Para el tipo de producto 3: Cantidad de productos vendidos: " + cantidadProductosTipo3 + " Importe total: " +importeTotalTipo3);

    }
}
