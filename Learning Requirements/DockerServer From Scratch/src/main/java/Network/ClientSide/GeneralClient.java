
package Network.ClientSide;

import Network.ServerSide.Server;
import ProcessHandlers.ProcessExecutor;
import ProcessHandlers.ProcessIOHandler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class GeneralClient {

	private static Socket socket;

	public static void main(String[] args) throws IOException {

		socket = new Socket( "localhost", Server.PORT ); // connect to server

//		DataOutputStream temp = new DataOutputStream( socket.getOutputStream() );
//		temp.writeUTF( "Test Testtttttt!!!!!" );

		startClientGame();

	}

	private static void startClientGame() throws IOException {

//		Process lsProcess = ProcessExecutor.invoke( "ls" );
//		ProcessIOHandler.printProcessInputStream( lsProcess );

		Process uploadedCodeProcess = ProcessExecutor.invoke( "bash", "Network/ClientSide/uploadedCode/compileAndRun.sh");
//		System.out.println( "uploadedCodeProcess Errors: " );
//		ProcessIOHandler.printProcessErrorStream( uploadedCodeProcess );

		// Testing if it works

//		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );
		ProcessIOHandler.writeToProcess( uploadedCodeProcess, "ENTER_A_NUMBER\n" );
//		ProcessIOHandler.printProcessInputStreamOneLine( uploadedCodeProcess );
		DataOutputStream temp = new DataOutputStream( socket.getOutputStream() );
		temp.writeUTF( ProcessIOHandler.getProcessInputStreamOneLine( uploadedCodeProcess ) );

	}

}
