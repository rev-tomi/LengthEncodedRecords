package com.example;

public class EnumParser implements Parser {
	
	private static enum Fields {
		
		RECORD_TYPE(0, 2),
		DATE(2, 10),
		NAME(10, 50);
		
		final private int start;
		final private int end;
		
		private Fields(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String retrieveValue(String line) {
			return line.substring(start, end);
		}
	}

	@Override
	public Record parse(String line) {
		String recordType = Fields.RECORD_TYPE.retrieveValue(line);
		String date = Fields.DATE.retrieveValue(line);
		String name = Fields.NAME.retrieveValue(line);
		return new Record(recordType, date, name);
	}

}
