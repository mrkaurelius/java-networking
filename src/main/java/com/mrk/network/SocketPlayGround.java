package com.mrk.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

// class for learning purposes

public class SocketPlayGround {

    public static void main() {

        try {
            Socket sc = new Socket("52.77.209.135",18333);
            InputStream iStream =  sc.getInputStream();
            
            System.out.println(iStream.read()); 
            sc.close();

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }


    }




}