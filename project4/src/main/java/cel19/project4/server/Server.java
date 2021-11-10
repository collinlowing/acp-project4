package cel19.project4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cel19.project4.GameRunnable;

public class Server {
	private static final int PORT_NUMBER = 8765;

    public static void main(String[] args) {
        System.out.println("EchoServer running");

        ServerSocket server = null;
        try {
            // Obtain server socket
        	server = new ServerSocket(PORT_NUMBER);
            while (true) {
            	// Wait for connection
            	Socket socket = server.accept();
            	// Create new Runnable
            	GameRunnable gameRunnable = new GameRunnable(socket);
            	// Pass the new Socket
            	Thread t = new Thread(gameRunnable);
            	// Start the Thread
            	t.start();
            }
        } catch (IOException ex) {
            System.err.println("Unable to start server.");
        } finally {
        	// Close everything
        	try {
        		server.close();
        	}
        	catch(IOException e) {
        		e.printStackTrace();
        	}
        }
    }
}
