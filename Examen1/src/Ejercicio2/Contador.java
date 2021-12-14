public class Contador {

    private int contadorInterno;

    public Contador(){
        contadorInterno = 0;
    }

    public synchronized boolean incrementar(){
        boolean respuesta = false;
        if(contadorInterno < 10000){
            contadorInterno++;
            respuesta = true;
        }
        return respuesta;
    }

}
