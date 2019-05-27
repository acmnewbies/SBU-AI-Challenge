
package NetworkStuff.ServerSide;

import NetworkStuff.IOHandlers.SocketIOHandler;
import NetworkStuff.Ports;
import ProcessHandlers.ProcessExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket( Ports.PORT );
		SocketListenerThread socketListenerThread = new SocketListenerThread( serverSocket );
		socketListenerThread.start();

		Process player1Process = ProcessExecutor.invoke( "bash", "src/main/java/run.sh", "player1container" );
		Process player2Process = ProcessExecutor.invoke( "bash", "src/main/java/run.sh", "player2container" );

		socketListenerThread.join();

		SocketIOHandler player1IOHandler = new SocketIOHandler( socketListenerThread.getPlayer1Socket() );
		SocketIOHandler player2IOHandler = new SocketIOHandler( socketListenerThread.getPlayer2Socket() );

//		printProcessOutputStream(player2Process);

	}

	private static void printProcessOutputStream( Process process ) throws IOException {
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( process.getErrorStream() ) );
		String line;
		while ( (line = bufferedReader.readLine() ) != null)
			System.out.println( line );
	}

}
