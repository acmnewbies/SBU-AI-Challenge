
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

//		Process lsProcess = ProcessExecutor.invoke( "ls" );
//		ProcessIOHandler.printProcessInputStream( lsProcess );

		Process uploadedCodeProcess = ProcessExecutor.invoke( "bash", "Network/ClientSide/uploadedCode/compileAndRun.sh");
		System.out.println( "uploadedCodeProcess Errors: " );
//		ProcessIOHandler.printProcessErrorStream( uploadedCodeProcess );

//		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );
		ProcessIOHandler.writeToProcess( uploadedCodeProcess, "ENTER_A_NUMBER\n" );
		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );

	}

}
