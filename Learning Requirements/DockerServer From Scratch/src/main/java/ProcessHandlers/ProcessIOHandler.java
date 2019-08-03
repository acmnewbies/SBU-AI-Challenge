
package ProcessHandlers;

import java.io.*;

public class ProcessIOHandler {

	public static void printProcessErrorStream( Process process ) throws IOException {

		BufferedReader bf = getBufferedReader( process.getErrorStream() );
		printBufferedReaderStream( bf );

	}

	public static void printProcessInputStream( Process process ) throws IOException {

		BufferedReader bf = getBufferedReader( process.getInputStream() );
		printBufferedReaderStream( bf );

	}

	public static void writeToProcess( Process process, String input ) throws IOException {
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( process.getOutputStream() ) );
		bw.write( input );
		bw.write( "\n" );
		bw.flush();
	}

	private static void printBufferedReaderStream(BufferedReader bf) throws IOException {
		String line;
		while ( ( line = bf.readLine() ) != null )
			System.out.println( line );
	}

	private static BufferedReader getBufferedReader( InputStream inputStream ) {
		return new BufferedReader( new InputStreamReader( inputStream ) );
	}

}
