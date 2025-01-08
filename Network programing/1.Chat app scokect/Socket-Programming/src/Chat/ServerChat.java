package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    static int port = 2999;



    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Chat Server");
        System.out.println("\t\t ===================");

        ServerSocket serverSocket = new ServerSocket(port);


        Scanner scannerInput =new Scanner(System.in);
        String input, output;

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client is connected....\n\n");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println("Welcome to socket programming");
                try{
                    out.println("Welcome to Chat application");
                    while(true){
                        input = in.readLine();
                        System.out.println("Client says: " + input);


                        System.out.print("Client: ");
                        output = scannerInput.nextLine();
                        out.println(output);

                    }
                }finally {
                    socket.close();
                    in.close();
                    out.close();

                }

            }

        } finally {
            serverSocket.close();
        }
    }
}


