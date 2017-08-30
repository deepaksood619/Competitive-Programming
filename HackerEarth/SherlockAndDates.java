// https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/sherlock-and-dates/description/

/*
    Working but not fully optimized.
    Time out for last 3 test cases
*/

import java.util.*;

import java.text.ParseException; 

import java.lang.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

class SherlockAndDates {

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		String date = "31:05:0457 17:04:9231"; // 968
		// String date = "30:03:1199 30:03:1204"; // 2
		// String date = "27:03:5208 27:03:5215"; // 6
		// String date = "01:01:0001 01:02:0003"; // 1

		String[] dateArr = date.split(" ");

		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
		try {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(sdf.parse(dateArr[0]));

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(sdf.parse(dateArr[1]));

			int count = 0;

			int val = cal1.compareTo(cal2);

			while(val <= 0) {

				int year = cal1.get(Calendar.YEAR) % 100;
				
				if(year >= 2) {
					if(year <= 13) {
						// System.out.println("year sat - " + cal1.getTime());
						int mon = cal1.get(Calendar.MONTH) + 2;
						if(mon > year) {
							// System.out.println("year sat - " + cal1.getTime());
							cal1.add(Calendar.YEAR, 1);
							cal1.set(Calendar.MONTH, 0);
						} else if(mon < year) {
							// System.out.println("mon inc - " + cal1.getTime());
							cal1.add(Calendar.MONTH, 1);
							cal1.set(Calendar.DATE, 1);
						} else {
							mon -= 2;
							int dateInt = cal1.get(Calendar.DATE);
							if(dateInt > mon) {
								cal1.add(Calendar.MONTH, 1);
								cal1.set(Calendar.DATE, 1);
							} else if(dateInt == mon) {
								// System.out.println("Date - " + cal1.getTime());
								count++;
								cal1.add(Calendar.DATE, 1);
							} else {
								cal1.add(Calendar.DATE, 1);
							}						
						}
					} else {
						cal1.add(Calendar.YEAR, 102 - year);
						cal1.set(Calendar.MONTH, 0);
					}
				} else {
					// System.out.println(cal1.get(Calendar.YEAR));
					cal1.add(Calendar.YEAR, 1);
					cal1.set(Calendar.MONTH, 0);
				}

				val = cal1.compareTo(cal2);
			}
			System.out.println(count);

		} catch(ParseException e) {
			e.printStackTrace();
		}

		

	}
}