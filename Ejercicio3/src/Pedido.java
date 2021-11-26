
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Pedido {

    private ArrayList<Producto> listaPedido;

    public ArrayList<Producto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(ArrayList<Producto> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public Pedido(ArrayList<Producto> listaPedido){

        this.listaPedido = listaPedido;

    }

    public void generarPedido(){

        Random rng = new Random();
        int tipoProducto = rng.nextInt(3)+1;
        Producto producto = null;

        switch (tipoProducto){

            case 1:

                producto = new Producto(1,rng.nextInt(50) + 1 , rng.nextInt(130-4) + 1 + 4);

                break;

            case 2:

                producto = new Producto(2,rng.nextInt(50) + 1 , rng.nextInt(29-2) + 1 + 2);

                break;

            case 3:

                producto = new Producto(3,rng.nextInt(50) + 1 , rng.nextInt(15-1) + 1 + 1);

                break;

        }

        listaPedido.add(producto);

    }
}
