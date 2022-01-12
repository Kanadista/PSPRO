import javax.swing.*;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {


    public static void main (String [] args) {

        Enumeration<NetworkInterface> interfaces = null;
        NetworkInterface inf;
        byte[] mac;


        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while(interfaces.hasMoreElements()){
            inf = interfaces.nextElement();
            System.out.println(inf.getName());
            System.out.println(inf.getDisplayName());

            try {
                mac = inf.getHardwareAddress();
                if(mac != null) {
                    String[] hex = new String[mac.length];
                    for (int i = 0; i < mac.length; i++) {
                        hex[i] = String.format("%02X", mac[i]);
                    }
                    System.out.println(String.join("-", hex));
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }
}
