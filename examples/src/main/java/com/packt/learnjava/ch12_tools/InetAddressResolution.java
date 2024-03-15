package com.packt.learnjava.ch12_tools;

import java.net.InetAddress;
import java.util.Arrays;

public class InetAddressResolution {
    public static void main(String[] args) {
        defaultResolver();
        //Copy the following line, starting from "com"
        // com.packt.learnjava.ch12_tools.resolver.MyInetAddressResolverProvider
        // to the file resources/META-INF/services/java.net.spi.InetAddressResolverProvider
        // and uncomment the following method
        //myResolver();
    }

    static void defaultResolver(){
        try {
            InetAddress ia = InetAddress.getByName("google.com");
            String ha = ia.getHostAddress();
            System.out.println(ha);             // prints: 142.250.72.14 or 1.2.3.4

            InetAddress[] ias = InetAddress.getAllByName("google.com");
            System.out.println(Arrays.toString(ias));  //prints: [google.com/142.250.72.14, google.com/2607:f8b0:400f:803:0:0:0:200e]
                                                       //    or: [/1.2.3.4]
            byte[] ipAddress = InetAddress.getByName("142.250.72.14").getAddress();
            ia = InetAddress.getByAddress(ipAddress);
            System.out.println(ia.getHostName());          //prints: den08s06-in-f14.1e100.net or 142.250.72.14
            System.out.println(ia.getCanonicalHostName()); //prints: den08s06-in-f14.1e100.net or 142.250.72.14
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void myResolver(){
        System.out.println("\nMy Inet Address Resolver:");
        try {
            InetAddress ia = InetAddress.getByName("google.com");
            String ha = ia.getHostAddress();
            System.out.println(ha);                    // prints: 1.2.3.4

            InetAddress[] ias = InetAddress.getAllByName("google.com");
            System.out.println(Arrays.toString(ias));  //prints: [/1.2.3.4]

            byte[] ipAddress = InetAddress.getByName("1.2.3.4").getAddress();
            ia = InetAddress.getByAddress(ipAddress);
            System.out.println(ia.getHostName());          //prints: 1.2.3.4
            System.out.println(ia.getCanonicalHostName()); //prints: 1.2.3.4
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
