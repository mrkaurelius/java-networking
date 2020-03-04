package com.mrk.network;


import java.net.*; 
import java.io.*; 

/**
 * HttpServer
 */
 
public class HttpServer {

    private int MAX_REQUEST;
    // Socket info ?
    private ServerSocket server;
    private int PORT;
    private String ADDRESS; 
    
    private String httpOK = null; 

    HttpServer(int PORT, String ADDRES, int MAX_REQUEST){
        System.out.println("[INFO] Http Server Started");
        this.PORT = PORT;
        this.MAX_REQUEST = MAX_REQUEST;

        // implement http version 1.0
        this.httpOK = 
        "HTTP/1.0 200 OK\n" +
        "Content-type: text/html; charset=UTF-8\n" +
        "\n"+
        "<h1>Hello</h1>";

        try {
            this.server = new ServerSocket(PORT);
        } catch (Exception e) {
            //TODO: handle exception, IO exception 
            System.err.println("[ERROR] Server Socket Exception!");
        }
       
       
    }
    
    public int runServer(){
        for(;;){
            try {
                Thread.sleep(10);
                System.out.println("[INFO] Waiting for connections");

                Socket clientConnection = server.accept();
                System.out.println("[INFO] Client accepted, " + clientConnection.toString()); 

                DataOutputStream outToServer = new DataOutputStream(clientConnection.getOutputStream() );
                outToServer.writeBytes(this.httpOK);

                //outToServer.close();
                //clientConnection.close();

            } catch (Exception e) {
                //TODO: handle exception
                System.err.println("[ERROR] Thread Sleep Exception!");
            }
        }
    }

}