package problem_solving.medium.JP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Coins {
    public static int coinChange(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int coinSteps = 0;
        boolean[] vstd = new boolean[amount + 1];
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int sum = q.poll();
                if (sum == amount) {
                    return coinSteps;
                }
                if (sum > amount || vstd[sum]) {
                    continue;
                }
                vstd[sum] = true;
                for (int coin : coins) {
                    q.add(sum + coin);
                }
            }
            coinSteps++;
        }
        return -1;
    }

    public static int coinChangeNaive(int[] coins, int amount) {
        // Base cases
        if (amount == 0) {
            return 0; // No coins are needed to make amount 0
        }
        if (amount < 0) {
            return -1; // Not possible to mak e negative amount
        }

        // Initialize the result to a large value
        int minCoins = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            int result = coinChangeNaive(coins, amount - coin); // Reduce the amount by this coin
            if (result >= 0) { // Check if the result is valid
                minCoins = Math.min(minCoins, 1 + result); // Update the minimum coins
            }
        }

        // If no solution was found, return -1; otherwise, return minCoins
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static int coinChangeIterative(int[] coins, int amount) {
        // If amount is 0, we need 0 coins
        if (amount == 0) {
            return 0;
        }
        // Stack for remaining amounts
        Stack<Integer> currentRemains = new Stack<>();
        currentRemains.push(amount);
        // Stack for corresponding coin counts
        Stack<Integer> currentCoins = new Stack<>();
        currentCoins.push(0);

        int minCoins = Integer.MAX_VALUE;

        while (!currentRemains.empty()) {
            int remains = currentRemains.pop();
            int coinCounter = currentCoins.pop();
            if (remains == 0) {
                minCoins = Math.min(minCoins, coinCounter);
                continue;
            }
            for (int coin : coins) {
                if (remains - coin >= 0) {
                    currentRemains.push(remains - coin);
                    currentCoins.push(coinCounter + 1);
                }
            }
        }
        // If no solution was found, return -1
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }


    public static void main(String[] args) {
        int[] coins = new int[]{9, 6, 4};
        int i = coinChangeIterative(coins, 2);
        System.out.println(i);

    }

}
