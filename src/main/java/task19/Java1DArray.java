package task19;
//https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true

import java.util.Scanner;

public class Java1DArray {
    public static boolean canWinTooSlow(int leap, int[] game) {
        int currentPosition = 0;
        int n = game.length;
        boolean stopGame = false;
        boolean answer = false;
        while ((game[currentPosition] == 0) & !stopGame) {
            if ((currentPosition == n - 1) || ((currentPosition + leap) >= n)) {
                answer = true;
                break;
            } else {
                if ((leap !=0 )&& (game[currentPosition + leap] == 0) ){
                    currentPosition = currentPosition + leap;
                } else {
                    if (game[currentPosition + 1] == 0) {
                        currentPosition++;
                    } else {
                        if ((currentPosition - 1 >= 0) && (game[currentPosition] == 0)) {
                            currentPosition--;
                        } else {
                           break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public  static boolean canWin(int leap, int[]game){
        return isGameSolved(leap,game,0);
    }
    public static boolean isGameSolved(int leap, int[]game, int i){
        if(i >= game.length){
            return true;
        }if (i < 0 || game[i]==1){
            return false;
        }
        game[i] = 1;

        return isGameSolved(leap,game,i + leap)
                ||isGameSolved(leap, game, i + 1)
                ||isGameSolved(leap,game,i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }

}
