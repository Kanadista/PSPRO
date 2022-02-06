import javax.swing.*;
import java.net.*;
import java.util.Enumeration;

public class Main {


    public static void main(String[] args) {

        Enumeration<NetworkInterface> interfaces = null;
        NetworkInterface inf;
        byte[] mac;

        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (interfaces.hasMoreElements()) {
            inf = interfaces.nextElement();
            try {
                mac = inf.getHardwareAddress();

                if (mac != null) {
                    String[] hex = new String[mac.length];
                    for (int i = 0; i < mac.length; i++) {
                        hex[i] = String.format("%02X", mac[i]);
                    }
                    for (InterfaceAddress ip: inf.getInterfaceAddresses()) {
                        System.out.println(ip.getAddress());
                        System.out.println(ip.getNetworkPrefixLength());
                    }
                    System.out.println(inf.getName());
                    System.out.println(inf.getDisplayName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
