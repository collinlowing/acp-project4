package cel19.project4.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameRunnable implements Runnable {

	private Socket socket;
	private String[] responses;

	public GameRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner input = null;
		PrintWriter output = null;
		try {
			String request;
			input = new Scanner(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			// Main request loop
			while (((request = input.nextLine()) != null) && !request.equalsIgnoreCase("quit")) {
				System.out.println("Message recieved: " + request);
				output.println(handleRequest(request));
				output.flush();
			}
		} catch (IOException ex) {
			System.err.println("Unable to get streams from client");
		} finally {
			try {
				// Close all resources
				input.close();
				output.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	// Processes requests from client and then returns a response message
	private String handleRequest(String request) {
		String[] requests = pareseRequest(request);
		
		// Handle request actions
		for(String req : requests)
		{
			
		}
		
		// Generate response
		String response = "";
		for(String res : responses)
		{
			response  += res + " ";
		}
		return response;
	}

	private String[] pareseRequest() {
		
		return null;
	}

}
