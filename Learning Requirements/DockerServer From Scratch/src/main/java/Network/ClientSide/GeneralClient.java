
package Network.ClientSide;

import Network.ServerSide.Server;
import ProcessHandlers.ProcessExecutor;
import ProcessHandlers.ProcessIOHandler;

import java.io.IOException;
import java.net.Socket;

public class GeneralClient {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket( "localhost", Server.PORT ); // connect to server

		startClientGame();

	}

	private static void startClientGame() throws IOException {

		Process uploadedCodeProcess = ProcessExecutor.invoke( "bash", "src/main/java/Network/ClientSide/uploadedCode/compileAndRun.sh");
//		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );
		ProcessIOHandler.writeToProcess( uploadedCodeProcess, "ENTER_A_NUMBER\n" );
		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );

	}

}
