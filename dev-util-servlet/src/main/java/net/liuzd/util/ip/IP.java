package net.liuzd.util.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class IP {

    private IP() {

    }
    
    public static String get(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
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