
package NetworkStuff.IOHandlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketIOHandler {

	public DataInputStream dis;
	public DataOutputStream dos;

	public SocketIOHandler(Socket socket) throws IOException {
		this.dis = new DataInputStream( socket.getInputStream() );
		this.dos = new DataOutputStream( socket.getOutputStream() );
	}
}
