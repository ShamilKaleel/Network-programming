package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// UDP Client class
public class UDPClient {
    // Define the port number to communicate with the server
    static int port = 1234;

    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket for sending the data
        DatagramSocket client = new DatagramSocket();

        // Get the IP address of the local host (can be changed to the server IP)
        InetAddress ipAddress = InetAddress.getLocalHost();

        // The message to be sent to the server
        String str = "Hello World";

        // Convert the message to bytes to send over the network
        byte[] buf = str.getBytes();

        // Create a DatagramPacket with the data, length, server IP, and port
        DatagramPacket packet = new DatagramPacket(buf, buf.length, ipAddress, port);

        // Send the packet using the DatagramSocket
        client.send(packet);

        // Close the DatagramSocket to release resources
        client.close();
    }
}
