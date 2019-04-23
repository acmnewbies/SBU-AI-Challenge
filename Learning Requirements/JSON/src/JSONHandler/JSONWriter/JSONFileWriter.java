package JSONHandler.JSONWriter;

import java.io.FileNotFoundException;

abstract public class JSONFileWriter {

	protected String fileName;

	public JSONFileWriter(String fileName) {
		this.fileName = fileName;
	}

	public abstract String JSONWrite() throws FileNotFoundException;

}
