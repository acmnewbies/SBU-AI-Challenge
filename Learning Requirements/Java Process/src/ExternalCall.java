import java.io.*;

public class ExternalCall {

	public static void main(String[] args) throws IOException {

		String[] command = {"/home/roozbeh/MyApps/university/Term 4/SBU-AI-Challenge/Learning Requirements/Java Process/src/adder.sh"};
//		System.out.println( command[0] );
		ProcessBuilder pb = new ProcessBuilder( command );

		Process process = pb.start();

		OutputStream os = process.getOutputStream();
		PrintStream ps = new PrintStream( os );

		BufferedReader br = new BufferedReader( new InputStreamReader( process.getInputStream() ) );

		for ( int i = 0; i < 10; i++ )
			for ( int j = 0; j < 10; j++ ) {
				ps.println( i );
				ps.println( j );
				ps.flush();

				String output = br.readLine();
				System.out.println( i + " + " + j + " is equal to " + output );

			}

		process.destroy();

	}

}
