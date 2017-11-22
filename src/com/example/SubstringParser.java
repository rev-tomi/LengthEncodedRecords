package com.example;

public class SubstringParser implements Parser {

	@Override
	public Record parse(String line) {
		String recordType = line.substring(0, 2);
		String date = line.substring(2, 10);
		String name = line.substring(10, 50);
		return new Record(recordType, date, name);
	}

}
