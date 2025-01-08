package ThredsChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread  extends Thread{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scannerInput;
    private int client_id;

    public ServerThread(Socket client_socket, int client_id) throws IOException {
        this.client = client_socket;
        this.client_id = client_id;
        out = new PrintWriter(client.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        scannerInput= new Scanner(System.in);
    }
    public void run(){
        try{
            out.println("Welcome to Chat application");
            while(true){
               String input = in.readLine();
                System.out.println("Client : "+ client_id+" Client says: " + input);


                System.out.print("Server: ");
                String output = scannerInput.nextLine();
                out.println(output);

            }
        }catch (IOException e){
            System.out.println("Client"+ client_id+" has left the chat");
        }
        finally {
            try {
                client.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}
