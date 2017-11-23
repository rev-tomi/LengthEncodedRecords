package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesParser implements Parser {
	
	private final Map<String, FieldParser> fieldParsers = new HashMap<>();
	
	public PropertiesParser(Properties parserProperties) {
		fieldParsers.putAll(parseParserProperties(parserProperties));
	}

	Map<String, FieldParser> parseParserProperties(Properties parserProperties) {
		Map<String, FieldParser> result = new HashMap<>();
		for (Entry<Object, Object> e : parserProperties.entrySet()) {
			String key = e.getKey().toString();
			String[] keyParts = key.split("\\.");
			String fieldName = keyParts[1];
			String startOrEnd = keyParts[2];
			int value = Integer.valueOf(e.getValue().toString());
			FieldParser details = null;
			if (result.containsKey(fieldName)) {
				details = result.get(fieldName);
			} else {
				details = new FieldParser();
				result.put(fieldName, details);
			}
			if ("start".equalsIgnoreCase(startOrEnd)) {
				details.setStart(value);
			} else if ("end".equalsIgnoreCase(startOrEnd)) {
				details.setEnd(value);
			}
			
		}
		return result;
		
	}

	@Override
	public Record parse(String line) {
		String recordType = parseNamedField("record_type", line);
		String date = parseNamedField("date", line);
		String name = parseNamedField("name", line);
		return new Record(recordType, date, name);
	}

	private String parseNamedField(String fieldName, String line) {
		return fieldParsers.get(fieldName).getField(line);
	}
	
	private static class FieldParser {
		
		private int start;
		private int end;

		public void setStart(int start) {
			this.start = start;
		}

		public void setEnd(int end) {
			this.end = end;
		}
		
		public String getField(String line) {
			return line.substring(start, end);
		}

		
	}

}
