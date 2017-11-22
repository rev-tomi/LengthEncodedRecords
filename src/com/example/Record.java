package com.example;

public class Record {

	private final String recordType;
	private final String date;
	private final String name;
	
	public Record(String recordType, String date, String name) {
		this.recordType = recordType;
		this.date = date;
		this.name = name;
	}

	public String getRecordType() {
		return recordType;
	}

	public String getDate() {
		return date;
	}

	public String getName() {
		return name;
	}
	
	
}
