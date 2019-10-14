
package Network.ServerSide;

import ProcessHandlers.ProcessExecutor;
import ProcessHandlers.ProcessIOHandler;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static final int PORT = 1958;

	private static ServerSocket serverSocket;
	private static SocketListenerThread socketListenerThread;

	public static void main(String[] args) throws IOException, InterruptedException {

		serverSocket = new ServerSocket( Server.PORT ); // Start Server
		startListening();   // Start waiting for players to connect

		startPlayers();

		socketListenerThread.join(); // Wait for players to connect

		// Khob alan do taa bazikon vasl shodan

//		DataInputStream temp = new DataInputStream( socketListenerThread.getPlayer1Socket().getInputStream() );
//		String testReturnValue = temp.readUTF();
//		System.out.println( testReturnValue );

	}

	private static void startListening() {

		socketListenerThread = new SocketListenerThread( serverSocket );
		socketListenerThread.start();

	}
	private static void startPlayers() throws IOException {

		Process player1Process = ProcessExecutor.invoke( "bash", "runGeneralClient.sh", "player1container" );
//		ProcessIOHandler.printProcessErrorStream( player1Process );
		Process player2Process = ProcessExecutor.invoke( "bash", "runGeneralClient.sh", "player2container" );
//		ProcessIOHandler.printProcessErrorStream( player2Process );

	}

}
