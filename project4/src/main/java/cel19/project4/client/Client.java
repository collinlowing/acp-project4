package cel19.project4.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public Client(String host, int port) {
		try {
			// Initiate client socket
			String serverHostName = host;
			int serverPort = port;
			System.out.println("Connecting to host " + serverHostName + " on port " + port + ".");
			Socket socket = null;
			PrintWriter output = null;
			BufferedReader input = null;

			try {
				// Get a socket from the server
				socket = new Socket(serverHostName, serverPort);
				// Create I/O instances from socket
				output = new PrintWriter(socket.getOutputStream(), true);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// Fill in
			} catch (UnknownHostException e) {
				System.out.println("Unknown host: " + serverHostName);
				System.exit(1);
			} catch (IOException e) {
				System.out.println("Unable to get streams from server");
				e.printStackTrace();
				System.exit(1);
			}

			// Create input from System.in
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
			// Main client loop
			boolean done = false;
			while (!done) {
				// Fill in
				System.out.print("client: ");
				String userInput = consoleInput.readLine();
				if (userInput.equalsIgnoreCase("quit")) {
					done = true;
				}
				output.println(userInput);
				System.out.println("server: " + input.readLine());
			}

			// Close all resources
			output.close();
			input.close();
			consoleInput.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		String host = "127.0.0.1";
		int port = 8765;
		new Client(host, port);
	}
}
