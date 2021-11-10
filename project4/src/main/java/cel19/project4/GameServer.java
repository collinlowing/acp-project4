package cel19.project4;

import java.net.ServerSocket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class GameServer {
	private String[][] board = new String[3][3]; // 3x3 board that stores the state of the board space.
	private Player[] players; // array of players
	private ServerSocket server;
	private int currentPlayer;
	private final static int PLAYER_X = 0;
	private final static int PLAYER_O = 1;
	private final static String[] MARKS = { "X", "O" };
	private Lock gameLock;
	private Condition otherClientConnected;
	private Condition otherPlayerTurn;
	
	GameServer()
	{
		players = new Player[2];
		currentPlayer = PLAYER_X;
	}
	
}
