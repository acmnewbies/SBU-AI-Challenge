
package NetworkStuff.ClientSide;

import NetworkStuff.IOHandlers.SocketIOHandler;
import NetworkStuff.Ports;
import ProcessHandlers.ProcessExecutor;
import ProcessHandlers.ProcessIOHandler;

import java.io.*;
import java.net.Socket;
import java.rmi.UnexpectedException;
import java.util.Scanner;

public class GeneralClient {

	public static void main(String[] args) throws IOException, InterruptedException {

		Socket socket = new Socket( "localhost", Ports.PORT );
		SocketIOHandler socketIOHandler = new SocketIOHandler( socket );

		Process uploadedCodeProcess = ProcessExecutor.invoke( "./src/main/java/NetworkStuff/ClientSide/uploadedCode/compileAndRun.sh" );

		ProcessIOHandler processIOHandler = new ProcessIOHandler( uploadedCodeProcess );
//		PrintStream processPrinter = new PrintStream( uploadedCodeProcess.getOutputStream() );
//		BufferedReader processReader = new BufferedReader( new InputStreamReader( uploadedCodeProcess.getInputStream() ) );

		if ( socketIOHandler.dis.readUTF().equals( "START_GAME" ) )
			startGame( socketIOHandler, processIOHandler );

		while ( true ) {



			if ( !uploadedCodeProcess.isAlive() )
				throw new UnexpectedException( "Process died unexpectedly... Exiting!" );

		}

	}

	private static void startGame( SocketIOHandler socketIOHandler, ProcessIOHandler processIOHandler ) throws IOException {

		while ( true ) {
			String currentCommand = socketIOHandler.dis.readUTF();
			if ( currentCommand.equals( "YOUR_TURN" ) ) {
				processIOHandler.printer.print( "ENTER_A_NUMBER" );
				processIOHandler.printer.flush();
				String response = processIOHandler.reader.readLine();
				socketIOHandler.dos.writeUTF( response );
			}
		}

	}

}
