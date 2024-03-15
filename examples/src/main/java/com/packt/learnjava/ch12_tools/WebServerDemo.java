package com.packt.learnjava.ch12_tools;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class WebServerDemo {
    public static void main(String[] args) {
        HttpServer server = SimpleFileServer.createFileServer(
                new InetSocketAddress(5678),
                Path.of("/Users/nick/apidoc"),
                SimpleFileServer.OutputLevel.INFO
        );
        server.start();
    }
}
