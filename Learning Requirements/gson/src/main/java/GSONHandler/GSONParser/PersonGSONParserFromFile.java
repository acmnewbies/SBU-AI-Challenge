
package GSONHandler.GSONParser;

import SideClasses.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class PersonGSONParserFromFile extends GSONParserFromFile {

	public PersonGSONParserFromFile(String fileName ) {
		super( fileName );
	}

	@Override
	public Person GSONParse() throws FileNotFoundException, UnsupportedEncodingException {

		Person person = new Person();

//		System.out.println( fileName );
		Reader reader = new FileReader( fileName );

		Gson gson = new GsonBuilder().create();
		person = gson.fromJson( reader, Person.class );

		return person;

	}

}

