package InfyCodingEfficient;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class A10_12HourToMilitaryTime {
public static void main(String[] args) throws ParseException {
	Scanner sc = new Scanner(System.in);
	String date = sc.next();
	System.out.println(timeFormat24(date));
}

private static String timeFormat24(String date) throws ParseException {
	// TODO Auto-generated method stub
	DateFormat dateFormat = new SimpleDateFormat("hh:mm:ssaa");
	DateFormat format = new SimpleDateFormat("HH:mm:ss");
	Date time = null;
	String output = "";
	time = dateFormat.parse(date);
	output = format.format(time);
	return output;
}
}
