
package JsonHandler;

import java.io.FileNotFoundException;

abstract public class JSONWriter {

	protected String fileName;

	public JSONWriter(String fileName) {
		this.fileName = fileName;
	}

	public abstract String JSONWrite() throws FileNotFoundException;

}
