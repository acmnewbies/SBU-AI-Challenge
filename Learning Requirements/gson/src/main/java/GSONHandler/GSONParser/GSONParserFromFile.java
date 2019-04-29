
package GSONHandler.GSONParser;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

abstract public class GSONParserFromFile {

	protected String fileName;

	public GSONParserFromFile(String fileName) {
		this.fileName = fileName;
	}

	public abstract Object GSONParse() throws FileNotFoundException, UnsupportedEncodingException;

}
