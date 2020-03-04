package com.mrk.network;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        HttpServer server = new HttpServer(8080, "127.0.0.1", 1000);
        
        server.runServer();
    
    }
}
