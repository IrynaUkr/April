package task11;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

//https://www.hackerrank.com/challenges/java-date-and-time/problem?isFullScreen=true
public class DateAndTime {
    public static String findDay(int month, int day, int year) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);

        int i = calendar.get(Calendar.DAY_OF_WEEK);
        String result = "";
        switch (i) {
            case 1 -> result = "Sunday";
            case 2 -> result = "Monday";
            case 3 -> result = "Tuesday";
            case 4 -> result = "Wednesday";
            case 5 -> result = "Thursday";
            case 6 -> result = "Friday";
            case 7 -> result = "Saturday";
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = DateAndTime.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

