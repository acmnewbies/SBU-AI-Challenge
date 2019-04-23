
package NetworkStuff.ClientSide;

import JSONHandler.JSONWriter.PersonJSONFileWriter;
import SideClasses.Address;
import SideClasses.Car;
import SideClasses.Person;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static DataInputStream dis;
	public static DataOutputStream dos;
	private static String id;

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket( "localhost", 1958 );
		dis = new DataInputStream( socket.getInputStream() );
		dos = new DataOutputStream( socket.getOutputStream() );

		id = dis.readUTF();

//		System.out.println( "My ID is " + id + "!" );

		Scanner in = new Scanner( System.in );

		while ( true ) {

			Person currentPerson = new Person();

			System.out.println( "FirstName?" );
			currentPerson.setFirstName( in.next() );
			System.out.println( "LastName?" );
			currentPerson.setLastName( in.next() );
			System.out.println( "age?" );
			currentPerson.setAge( in.nextInt() );

			Address tempAddress = new Address();
			System.out.println( "City?" );
			tempAddress.setCity( in.next() );
			System.out.println( "State?" );
			tempAddress.setState( in.next() );
			currentPerson.setAddress( tempAddress );

			System.out.println( "Number of cars?" );
			currentPerson.setCars( new Car[in.nextInt()] );
			for ( int i = 0; i < currentPerson.getCars().length; i++ ) {
				currentPerson.getCars()[i] = new Car();
				System.out.println( "Model?" );
				currentPerson.getCars()[i].setModel( in.next() );
				System.out.println( "Color?" );
				currentPerson.getCars()[i].setColor( in.next() );
			}
//			System.out.println(currentPerson.getCars()[0].getColor());

			PersonJSONFileWriter writer = new PersonJSONFileWriter( currentPerson, id );
			String fileAddress = writer.JSONWrite();
			dos.writeUTF( fileAddress );

			System.out.println( "Do you want to add another person? (y/n)" );
			if ( in.next().charAt(0) == 'y' ) {
				continue;
			}
			else {
				break;
			}

		}

	}

}
