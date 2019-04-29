
package NetworkStuff.ServerSide;

import JSONHandler.JSONParser.JSONParserFromFile;
import JSONHandler.JSONParser.PersonJSONParserFromFile;
import SideClasses.Car;
import SideClasses.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import static NetworkStuff.ServerSide.Server.persons;

public class ClientHandler implements Runnable {

	private Socket socket;
	final public DataInputStream dis;
	final public DataOutputStream dos;
	private String id;

	public ClientHandler( Socket socket, String id ) throws IOException {
		this.socket = socket;
		this.dis = new DataInputStream( socket.getInputStream() );
		this.dos = new DataOutputStream( socket.getOutputStream() );
		this.id = id;
	}

	@Override
	public void run() {

		try {
			dos.writeUTF( id );
		} catch (IOException e) {
			e.printStackTrace();
			System.exit( 12 );
		}

		try {

			while ( true ) {
				String fileAddress = this.dis.readUTF();
//				Object obj = new JSONParser().parse( new FileReader( fileAddress ) );
//
//				JSONObject jo = (JSONObject) obj;
//				Person person = new Person();
//
//				person.setFirstName( (String) jo.get("firstName" ) );
//				person.setLastName( (String) jo.get("lastName" ) );
//
//				person.setAge( (long) jo.get("age" ) );
//
//				Map address = (Map)jo.get("address");
//				Iterator<Map.Entry> addressItr = address.entrySet().iterator();
//				while ( addressItr.hasNext() ) {
//					Map.Entry pair = addressItr.next();
//					if ( pair.getKey().equals("city") )
//						person.getAddress().setCity( (String) pair.getValue() );
//					else if ( pair.getKey().equals("state") )
//						person.getAddress().setState( (String) pair.getValue() );
//				}
//
//				JSONArray ja = (JSONArray) jo.get( "cars" );
//
//				Iterator arrayItr = ja.iterator();
//				person.setCars( new Car[ja.size()] );
//				int carCounter = 0;
//				while ( arrayItr.hasNext() ) {
//					Iterator<Map.Entry> carItr = ( (Map) arrayItr.next() ).entrySet().iterator();
//					while ( carItr.hasNext() ) {
//						person.getCars()[carCounter] = new Car();
//						Map.Entry pair = carItr.next();
//						if ( pair.getKey().equals("model") )
//							person.getCars()[carCounter].setModel( (String) pair.getValue() );
//						else if ( pair.getKey().equals("color") )
//							person.getCars()[carCounter].setColor( (String) pair.getValue() );
//					}
//					carCounter++;
//				}
//
//				System.out.println( person );
//				persons.add( person );

				PersonJSONParserFromFile parser = new PersonJSONParserFromFile( fileAddress );
				Person person = parser.JSONParse();
				System.out.println( person );
				persons.add( person );


			}

		}
		catch ( IOException ioexception ) {
			System.out.println( "IOException in ClientHandler" );
			System.exit( 12 );
		}
//		catch ( ParseException parseException ) {
//			System.out.println( "Parse Exception!" );
//			System.exit( 13 );
//		}

	}

}
