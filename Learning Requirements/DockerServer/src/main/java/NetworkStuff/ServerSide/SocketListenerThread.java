package NetworkStuff.ServerSide;

import NetworkStuff.Ports;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListenerThread implements Runnable {

	public void run() {
		try {

			ServerSocket serverSocket = new ServerSocket( Ports.PORT );

			System.out.println( "Waiting for players to connect" );
			Socket player1Socket = serverSocket.accept();
			System.out.println( "Player1 connected" );
			Socket player2Socket = serverSocket.accept();
			System.out.println( "Player2 connected" );

		} catch (IOException e) {
			e.printStackTrace();
			System.exit( 1 );
		}
	}
}
