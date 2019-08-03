
package Network.ServerSide;

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

	}

	private static void startListening() {

		socketListenerThread = new SocketListenerThread( serverSocket );
		socketListenerThread.start();

	}

	private static void startPlayers() {

		//  This function must run the docker image that contains general client

	}

}