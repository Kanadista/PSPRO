import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        String host = "";
        int resultado = 0;
        String ipAddress = "";
        Scanner input = new Scanner(System.in);
        InetAddress ip;

        System.out.println("|| 1. Convertir host a IP. || 2. Convertir IP a host: ");
        resultado = input.nextInt();
        input.nextLine();

        switch (resultado){
            case 1:
                System.out.println("Introduce el nombre del host: ");
                host = input.nextLine();
                try {
                    ip = InetAddress.getByName(host);
                    convertirHostAIP(ip);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("Introduce la IP de la cual quieres averiguar el host: ");
                ipAddress = input.nextLine();
                try {
                    ip = InetAddress.getByName(ipAddress);
                    System.out.println(ip.getHostName());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void convertirHostAIP(InetAddress ip){
        for(byte b: ip.getAddress()) {
            System.out.print(b & 0xFF);
            System.out.print(".");
        }
    }
}
