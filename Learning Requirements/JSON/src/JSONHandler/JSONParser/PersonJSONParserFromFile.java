
package JSONHandler.JSONParser;

import SideClasses.Car;
import SideClasses.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class PersonJSONParserFromFile extends JSONParserFromFile {

	public PersonJSONParserFromFile(String fileName ) {
		super( fileName );
	}

	@Override
	public Person JSONParse() throws FileNotFoundException {

		Person person = new Person();

		try {

			Object object = new JSONParser().parse(new FileReader(this.fileName));
			JSONObject jo = (JSONObject) object;

			person.setFirstName( (String) jo.get("firstName") );
			person.setLastName( (String) jo.get("lastName" ) );

			person.setAge( (long) jo.get("age" ) );

			Map address = (Map)jo.get("address");
			Iterator<Map.Entry> addressItr = address.entrySet().iterator();
			while ( addressItr.hasNext() ) {
				Map.Entry pair = addressItr.next();
				if ( pair.getKey().equals("city") )
					person.getAddress().setCity( (String) pair.getValue() );
				else if ( pair.getKey().equals("state") )
					person.getAddress().setState( (String) pair.getValue() );
			}

			JSONArray ja = (JSONArray) jo.get( "cars" );

			Iterator arrayItr = ja.iterator();
			person.setCars( new Car[ja.size()] );
			System.out.println( "Number of casrs: " + ja.size() );
			int carCounter = 0;
			while ( arrayItr.hasNext() ) {
				Iterator<Map.Entry> carItr = ( (Map) arrayItr.next() ).entrySet().iterator();
				while ( carItr.hasNext() ) {
					person.getCars()[carCounter] = new Car();
					Map.Entry pair = carItr.next();
					if ( pair.getKey().equals("color") ) {
						person.getCars()[carCounter].setColor( (String) pair.getValue() );
						System.out.println( "CurrentColor: " + ( (String) pair.getValue() ) );
						System.out.println( "CarColor: " + person.getCars()[carCounter].getColor() );
					}
					else if ( pair.getKey().equals("model") )
						person.getCars()[carCounter].setModel( (String) pair.getValue() );
				}
				carCounter++;
			}

//			System.out.println( person );
		}
		catch ( IOException ioException ) {
			System.out.println( "IOException in JSON Parse method!" );
			System.exit( 12 );
		}
		catch ( ParseException parseException ) {
			System.out.println( "Parse Exception in JSON Parse method!" );
			System.exit( 12 );
		}

		System.out.println("Person is finalized!" );
		for ( int i = 0; i < person.getCars().length; i++ )
			System.out.println( person.getCars()[i].getColor() );
		return person;

	}

}

