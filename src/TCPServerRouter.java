import java.net.*;
import java.io.*;

public class TCPServerRouter {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null; //Socket for the thread
        Object [][] RoutingTable = new Object [10][2];
        int SockNum = 5555; //Port number
        int ind = 0; //Index in the routing table	

        //Accepting connections
        ServerSocket serverSocket = null; //Server socket for accepting connections
        try {
            int port = 5558;
            serverSocket = new ServerSocket(port);
            System.out.println("ServerRouter is Listening on port: " + port +".");
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + 5555 + ".");
            System.exit(1);
        }
			
        //Creating threads with accepted connections
        while(true)
        {
            try {
                clientSocket = serverSocket.accept(); //Wait for a connection then assign it to clientSocket
                SThread t = new SThread(RoutingTable, clientSocket, ind); //Thread for that connection.
                t.start();
                ind++;
                System.out.println("ServerRouter connected with Client/Server: " + clientSocket.getInetAddress().getHostAddress());
            } catch (IOException e) {
                System.err.println("Client/Server failed to connect.");
                break;
            }
        }
        //closing connections
        clientSocket.close();
        serverSocket.close();
        System.exit(1);
    }
}