package net.liuzd.util.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IP {

    private IP() {

    }

    public static String get() throws Exception {
        InetAddress ip = getLocalHostLANAddress();
        if (null != ip) {
            return ip.getHostAddress();
        }
        return null;
    }

    public static InetAddress getLocalHostLANAddress() throws Exception {
        try {
            InetAddress ip = null;
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddrs = ifaces.nextElement().getInetAddresses();
                while (inetAddrs.hasMoreElements()) {
                    InetAddress inetAddr = inetAddrs.nextElement();
                    if (inetAddr.isLoopbackAddress()) {
                        continue;
                    }
                    if (inetAddr.isSiteLocalAddress()) {
                        return inetAddr;
                    } else if (ip == null) {
                        ip = inetAddr;
                    }
                }
            }
            if (ip == null) {
                ip = InetAddress.getLocalHost();
            }
            return ip;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}