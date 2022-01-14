import javax.swing.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main {


    public static void main(String[] args) {

        Enumeration<NetworkInterface> interfaces = null;
        NetworkInterface inf;
        byte[] mac;
        byte[] ipByte;
        String ipAddress = "";
        Enumeration<InetAddress> ip;


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
                    ip = inf.getInetAddresses();
                    InetAddress inetAddres = ip.nextElement();
                    ipByte = inetAddres.getAddress();
                    System.out.println(String.join("-", hex));
                    System.out.println(inf.getName());
                    System.out.println(inf.getDisplayName());
                    for(int i = 0; i < inetAddres.getAddress().length; i++){
                        int t = 0xFF & ipByte[i];
                        ipAddress += "." + t;
                    }
                    System.out.println(ipAddress = ipAddress.substring(1));
                    ipAddress = "";
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
