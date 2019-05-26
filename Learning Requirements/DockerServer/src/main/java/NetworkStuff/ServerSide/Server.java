
package NetworkStuff.ServerSide;

import NetworkStuff.Ports;
import ProcessHandlers.ProcessExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {

//		ServerSocket serverSocket = new ServerSocket( Ports.PORT );
		Thread socketListenerThread = new Thread( new SocketListenerThread() );
		socketListenerThread.start();

		Process player1Process = ProcessExecutor.invoke( "bash", "src/main/java/run.sh", "player1container" );
		Process player2Process = ProcessExecutor.invoke( "bash", "src/main/java/run.sh", "player2container" );
//		System.out.println( player1Process.waitFor() );
//		System.out.println( player1Process.exitValue() );
//		System.out.println( "HERE" );

		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( player2Process.getErrorStream() ) );
		String line;
		while ((line = bufferedReader.readLine()) != null)
			System.out.println( line );
//		System.out.println( "LS IS RUN" );

/*		Socket p1 = serverSocket.accept();
		System.out.println( "First Accept is done" );
		Socket p2 = serverSocket.accept();
		System.out.println( "Second Accept is done" );*/

	}

}
