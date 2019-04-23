
package JsonHandler;

import SideClasses.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class PersonJSONWriter extends JSONWriter {

	private Person person;

	public PersonJSONWriter( Person person, String fileName ) {
		super( fileName );
		this.person = person;
	}

	@Override
	public String JSONWrite() throws FileNotFoundException {

		JSONObject jo = new JSONObject();

		jo.put( "firstName", person.getFirstName() );
		jo.put( "lastName", person.getLastName() );
		jo.put( "age", person.getAge() );

		Map m = new LinkedHashMap( 2 );
		m.put( "city", person.getAddress().getCity() );
		m.put( "state", person.getAddress().getState() );
		jo.put( "address", m );

		JSONArray ja = new JSONArray();
		for ( int i = 0; i < person.getCars().length; i++ ) {
			m = new LinkedHashMap(2);
			m.put("model", person.getCars()[i].getModel() );
			m.put( "color", person.getCars()[i].getColor() );
			ja.add( m );
		}
		jo.put( "cars", ja );

//		PrintWriter pw = new PrintWriter( "src/JSONfiles/" + fileName + ".json" );
		PrintWriter pw = new PrintWriter( fileName );
		pw.write( jo.toJSONString() );

		pw.flush();
		pw.close();

//		return "src/JSONfiles/" + fileName + ".json";
		return fileName;

	}

}
