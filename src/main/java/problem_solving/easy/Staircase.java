package problem_solving.easy;

public class Staircase {
    public static void staircase(int n) {
        for (int i = n - 1; i >= 0; i--) {
            int space = i;
            for (int j = 0; j < n; j++) {
                if (space > 0) {
                    System.out.print("_");
                    space--;
                } else {
                    System.out.print("£");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //staircase(4);
        int i = saveThePrisoner(8, 20 * 197999, 2);
        System.out.println(i);

    }

    public static int saveThePrisoner(int n, int m, int s) {
        //n-prisoners, m-pieces, s- startsFrom
        m = (m - 1) % n;
        s = (s - 1) % n;
        return (s + m) + 1;
    }

}
