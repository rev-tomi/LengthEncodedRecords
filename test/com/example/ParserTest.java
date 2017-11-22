package com.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParserTest {
	
	@Parameters
	public static Collection<Object[]> data() {
		 return Arrays.asList(new Object[][]{
			 {new SubstringParser(), "substring parser"}, 
			 {new EnumParser(), "substring parser"}
		 });
	}
	
	private Parser parser;
	private String testCaseName;
	
	public ParserTest(Parser parser, String testCaseName) {
		this.parser = parser;
		this.testCaseName = testCaseName;
	}

	@Test
	public void testParseLine() {
		// GIVEN
		String line = "AA20121129a123456789b123456789c123456789d123456789";
		
		// WHEN
		Record record = parser.parse(line);
		
		// THEN
		assertEquals(testCaseName, "AA", record.getRecordType());
		assertEquals(testCaseName, "20121129", record.getDate());
		assertEquals(testCaseName, "a123456789b123456789c123456789d123456789", record.getName());
	}
}
