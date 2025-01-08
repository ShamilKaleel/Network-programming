package ThredsChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    static int port = 2999;



    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Chat Server");
        System.out.println("\t\t ===================");

        ServerSocket serverSocket = new ServerSocket(port);


        int current_client=1;

        try {
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client is connected....\n\n");


                ServerThread ct= new ServerThread(client,current_client);
                ct.start();
                current_client++;
            }
        }finally {
            serverSocket.close();
        }

            }


    }


