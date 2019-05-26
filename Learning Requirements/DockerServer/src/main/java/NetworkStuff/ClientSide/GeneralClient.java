
package NetworkStuff.ClientSide;

import NetworkStuff.Ports;
import ProcessHandlers.ProcessExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class GeneralClient {

	public static void main(String[] args) throws IOException, InterruptedException {


//		Process temp1 = ProcessExecutor.invoke( "ls" );
//		Process temp2 = ProcessExecutor.invoke( "pwd" );
//		Thread.sleep(1000000);
		Process temp = ProcessExecutor.invoke( "./uploadedCode/compileAndRun.sh" );

		Socket socket = new Socket( "localhost", Ports.PORT );

		Scanner in = new Scanner( System.in );
		int number = in.nextInt();
		System.out.println( "Number: " + number );

	}

}
