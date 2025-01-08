package ThredsChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    static int port = 2999;

    public static void main(String[] args) throws IOException {

        System.out.println("\t\t Simple Chat Client");
        System.out.println("\t\t ===================");

        Scanner scannerInput = new Scanner(System.in);
        String input, output;

        InetAddress ipAddress = InetAddress.getLocalHost();

        Socket socket = new Socket(ipAddress, port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        try {

            while (true) {
                input = in.readLine();
                System.out.println("Server says: " + input);


                System.out.print("Client: ");
                output = scannerInput.nextLine();
                out.println(output);

            }
        } finally {
            socket.close();
            in.close();
            out.close();

        }

    }

}
