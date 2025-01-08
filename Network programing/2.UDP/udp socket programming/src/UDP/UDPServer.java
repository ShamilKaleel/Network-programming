package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    static int port = 1234;

    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket to receive the data
        DatagramSocket server = new DatagramSocket(port);

        System.out.println("Server is running and waiting for a message...");

        // Buffer to store incoming data
        byte[] receiveBuffer = new byte[20];

        // DatagramPacket to receive the data
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        // Receive the data
        server.receive(receivePacket);

        // Convert the received data into a string
        String receivedMessage = new String(receivePacket.getData());

        // Display the received message
        System.out.println("Message received from client: " + receivedMessage);

        // Close the socket
        server.close();
    }
}
