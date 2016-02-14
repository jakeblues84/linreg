package linreg.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BufferedCsvReader extends BufferedReader {

	public List<String> readCsvLine() throws IOException {
		String line = this.readLine();

		if (line == null) {
			return null;
		}

		return Arrays.asList(line.split(","));

	}

	public BufferedCsvReader(FileReader fileReader) {
		super(fileReader);
	}
}
