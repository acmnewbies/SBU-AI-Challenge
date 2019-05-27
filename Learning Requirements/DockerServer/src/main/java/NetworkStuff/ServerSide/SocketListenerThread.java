package NetworkStuff.ServerSide;

import NetworkStuff.Ports;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListenerThread extends Thread {

	private Socket player1Socket, player2Socket;
	private ServerSocket serverSocket;

	public SocketListenerThread( ServerSocket serverSocket ) {
		this.serverSocket = serverSocket;
	}

	public void run() {
		try {

//			ServerSocket serverSocket = new ServerSocket( Ports.PORT );

//			System.out.println( "Waiting for players to connect" );
			player1Socket = serverSocket.accept();
//			System.out.println( "Player1 connected" );
			player2Socket = serverSocket.accept();
//			System.out.println( "Player2 connected" );

		} catch (IOException e) {
			e.printStackTrace();
			System.exit( 1 );
		}
	}

	public Socket getPlayer1Socket() {
		return player1Socket;
	}

	public void setPlayer1Socket(Socket player1Socket) {
		this.player1Socket = player1Socket;
	}

	public Socket getPlayer2Socket() {
		return player2Socket;
	}

	public void setPlayer2Socket(Socket player2Socket) {
		this.player2Socket = player2Socket;
	}
}
