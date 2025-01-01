package MessageApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleClient {
    static int port = 1999;

    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Client");
        System.out.println("\t\t ==============");

        InetAddress ipAddress = InetAddress.getLocalHost();

        System.out.println("Connection to the server...");
            Socket socket = new Socket(ipAddress, port);


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = in.readLine();
            System.out.println("Server says: " + input);

            System.out.println("Closing the connection...");
            socket.close();
            in.close();

    }
}
