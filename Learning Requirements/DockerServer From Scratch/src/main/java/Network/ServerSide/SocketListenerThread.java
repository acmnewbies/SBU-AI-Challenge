
package Network.ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListenerThread extends Thread{

	private Socket player1Socket, player2Socket;
	private ServerSocket serverSocket;

	@Override
	public void run() {
		try {
			player1Socket = serverSocket.accept();
			player2Socket = serverSocket.accept();
		} catch ( IOException ioexception ) {
			ioexception.printStackTrace();
			System.exit( 1 );
		}
	}

	public SocketListenerThread( ServerSocket serverSocket ) {
		this.serverSocket = serverSocket;
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
