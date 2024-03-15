package com.packt.learnjava.ch12_tools.resolver;

import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;

public class MyInetAddressResolverProvider extends InetAddressResolverProvider {
    @Override
    public InetAddressResolver get(Configuration configuration) {
        return new MyInetAddressResolver();
    }

    @Override
    public String name() {
        return "My Internet Address Resolver Provider";
    }
}