# LengthEncodedRecords
This project is an example on parsing length-encoded records with readable code.

Usually we write code like this:

````java
String recordType = line.substring(0, 2);
String date = line.substring(2, 10);
String name = line.substring(10, 50);
return new Record(recordType, date, name);
````

But we can do better! With a minimal boilerplate code, we can make it readable and reusable:

````java
String recordType = Fields.RECORD_TYPE.retrieveValue(line);
String date = Fields.DATE.retrieveValue(line);
String name = Fields.NAME.retrieveValue(line);
return new Record(recordType, date, name);
````

