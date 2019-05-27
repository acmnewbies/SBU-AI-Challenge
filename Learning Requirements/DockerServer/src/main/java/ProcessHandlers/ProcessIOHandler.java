
package ProcessHandlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProcessIOHandler {

	public PrintStream printer;
	public BufferedReader reader;

	public ProcessIOHandler( Process process ) {
		this.printer = new PrintStream( process.getOutputStream() );
		this.reader = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
	}

}
