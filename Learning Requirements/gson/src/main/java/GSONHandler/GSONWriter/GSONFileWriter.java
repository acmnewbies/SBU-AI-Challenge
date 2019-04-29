package GSONHandler.GSONWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

abstract public class GSONFileWriter {

	protected String fileName;

	public GSONFileWriter(String fileName) {
		this.fileName = fileName;
	}

	public abstract String GSONWrite() throws FileNotFoundException, UnsupportedEncodingException, IOException;

}
