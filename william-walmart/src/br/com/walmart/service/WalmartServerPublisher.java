package br.com.walmart.service;
 
import javax.xml.ws.Endpoint;
/**
 * 
 * @author William.Galindo
 */
public class WalmartServerPublisher {
 
    public static void publish(){
        Endpoint.publish("http://127.0.0.1:9878/walmart",new WalmartServerImpl());
    }
}
