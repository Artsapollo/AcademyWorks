package lesson14.SOAP;

import javax.xml.ws.Endpoint;

public class MateGroupServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/mate", new MateGroupServiceImpl());
    }
}
