
package JSONHandler.JSONParser;

import java.io.FileNotFoundException;

abstract public class JSONParserFromFile {

	protected String fileName;

	public JSONParserFromFile(String fileName) {
		this.fileName = fileName;
	}

	public abstract Object JSONParse() throws FileNotFoundException;

}
