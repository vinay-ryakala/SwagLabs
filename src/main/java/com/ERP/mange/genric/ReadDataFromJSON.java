package com.ERP.mange.genric;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {
	
	public String readDataFromJson(String key) throws IOException, ParseException {
		// convert
		FileReader fileReader = new FileReader(IAutoConstants.CREDNTIALSPATH);
		JSONParser parser = new JSONParser();
		Object object = parser.parse(fileReader);
		HashMap map = (HashMap) object;
		String valueString = (String) map.get(key);
	return valueString;

	}
}
