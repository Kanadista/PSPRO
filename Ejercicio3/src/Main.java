import java.util.ArrayList;

public class Main {

    public static void main(String [] args){


        ArrayList<Producto> listaProductos = new ArrayList<>();

        Pedido oPedido = new Pedido(listaProductos);

        for(int i = 0; i < 14; i++) {
            oPedido.generarPedido();
        }

        Thread hilo1 = new Thread ( new Hilo(oPedido.getListaPedido()));
        hilo1.start();
    }
}
