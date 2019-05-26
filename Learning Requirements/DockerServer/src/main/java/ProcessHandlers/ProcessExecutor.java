
package ProcessHandlers;

import java.io.IOException;

public class ProcessExecutor {

	public static Process invoke( String... strings ) throws IOException {
		ProcessBuilder pb = new ProcessBuilder( strings );
		return pb.start();
	}

}
