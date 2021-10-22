package main;

import clases.Contenedor;
import clases.HiloConsumidor;
import clases.HiloProductor;

class principal{

public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<Integer>();
        Thread hprod = new Thread(new HiloProductor(almacen, "P"));
        Thread hcons = new Thread(new HiloConsumidor(almacen, "C")); hprod.start();
        hcons.start();
    }
}


