package com.mrk.network;


import java.net.*; 
import java.io.*; 

/**
 * HttpServer
 * dummy buggy http server
 */

public class HttpPlayGround {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(8081);
        server.runServer();
    }

}

 
class HttpServer {

    // Socket info ?
    private ServerSocket sSocket;

    public int PORT;
    public static String httpOK = null; 

    HttpServer(int PORT){
        System.out.println("[INFO] Http Server Started");
        this.PORT = PORT;

        // implement http version 1.0
        httpOK = 
        "HTTP/1.1 200 OK\n" +
        "Content-type: text/html; charset=UTF-8\n" +
        "Content-Length: 14\n" +
        "Connection: close\n" +
        "\n"+
        "<h1>Hello</h1>";

        try {
            this.sSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            //TODO: handle exception, IO exception 
            System.err.println("[ERROR] Server Socket Exception!");
        }
    }
    
    public void runServer(){

        while(true){
            System.out.println("Active threads: " + Thread.activeCount());

            try {
                //Thread.sleep(10);
                System.out.println("[INFO] Waiting for connections");

                SocketHandler sh  = new SocketHandler(sSocket.accept());
                sh.start();


            } catch (Exception e) {
                //TODO: handle exception
                System.err.println("[ERROR] Thread Sleep Exception!");
            }
        }
    }

    public class SocketHandler extends Thread {
        
        public Socket socket;

        public SocketHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                System.out.println("[INFO] Client accepted, " + socket.toString() +  "Thread ID: "+ Thread.currentThread().getId()); 
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream() );
                outputStream.writeBytes(HttpServer.httpOK);
                
                outputStream.flush();
                socket.close();
                
                System.out.println("Connection closed");

            } catch (Exception e) {
                e.printStackTrace();
                //TODO: handle exception
            }
        }
        
    }

}