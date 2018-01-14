/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_nang_cao.IP;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author PC
 */
public class getIP {

    private static void getIP() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("IP: " + addr.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getIPCONFIG_ALL() {
        try {
            Enumeration<NetworkInterface> eni = NetworkInterface.getNetworkInterfaces();
            while (eni.hasMoreElements()) {
                NetworkInterface ni = eni.nextElement();
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress ia = inetAddresses.nextElement();
                    System.out.println(ni.getName() + "   IP: " + ia.getHostAddress());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getPublicIpAddress() {
        String res = null;
        try {
            String localhost = InetAddress.getLocalHost().getHostAddress();
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                if (ni.isLoopback()) {
                    continue;
                }
                if (ni.isPointToPoint()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = (InetAddress) addresses.nextElement();
                    if (address instanceof Inet4Address) {
                        String ip = address.getHostAddress();
                        if (!ip.equals(localhost)) {
                            System.out.println((res = ip));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            String username = System.getProperty("user.name");
            java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
            System.out.println("Hostname of local machine: " + localMachine.getHostName());
            System.out.println("username = " + username);
        } catch (UnknownHostException ex) {
            Logger.getLogger(getIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
