
package NetworkStuff.ServerSide;

import SideClasses.Person;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static ArrayList<Person> persons = new ArrayList<>();

	public static void main(String[] args) throws Exception{

		int counter = 0;

		ServerSocket serverSocket = null;

		serverSocket = new ServerSocket( 1958 );

		while ( true ) {
			Socket socket = serverSocket.accept();
			ClientHandler temp = new ClientHandler( socket, Integer.toString( counter ) );
			Thread tempThread = new Thread( temp );
			tempThread.start();
			counter++;
		}

	}

}
