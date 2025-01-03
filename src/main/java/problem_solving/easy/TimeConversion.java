package problem_solving.easy;

public class TimeConversion {
    public static String timeConversion(String s) {
        boolean isPm = s.charAt(8) == 'P';
        int hours = Integer.parseInt(s.substring(0, 2));
        if (hours == 12 && !isPm) {
            hours = 0;
        } else if (hours == 12 && isPm) {
            hours = 12;
        } else if (isPm) {
            hours += 12;
        }
        StringBuilder result = new StringBuilder();
        if (hours < 10) {
            result.append(0);
        }
        result.append(hours);
        result.append(s, 2, 8);
        return result.toString();
    }

    public static void main(String[] args) {
        String conversion = timeConversion("12:05:45AM");
        System.out.println(conversion);
    }

}
