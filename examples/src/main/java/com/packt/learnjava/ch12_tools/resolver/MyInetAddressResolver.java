package com.packt.learnjava.ch12_tools.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.util.stream.Stream;

public class MyInetAddressResolver implements InetAddressResolver {
    @Override
    public Stream<InetAddress> lookupByName(String host, LookupPolicy lookupPolicy)
            throws UnknownHostException {
        return Stream.of(InetAddress.getByAddress(new byte[] {1, 2, 3, 4}));
    }

    @Override
    public String lookupByAddress(byte[] addr) {
        return "mysite.com";
    }
}