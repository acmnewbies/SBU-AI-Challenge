package GSONHandler.GSONWriter;

import SideClasses.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class PersonGSONFileWriter extends GSONFileWriter {

	private Person person;

	public PersonGSONFileWriter(Person person, String fileName ) {
		super( fileName );
		this.person = person;
	}

	@Override
	public String GSONWrite() throws FileNotFoundException, UnsupportedEncodingException, IOException {

		Writer writer = new OutputStreamWriter( new FileOutputStream( fileName + ".json" ), "UTF-8" );

		Gson gson = new GsonBuilder().create();
		gson.toJson( this.person, writer );

		writer.close();

		System.out.println( fileName + ".json" );

		return fileName + ".json";

	}

}
