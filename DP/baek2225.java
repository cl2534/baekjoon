/*
합분해

0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

key poitns :
dp[i][j] = i 개수의 정수에서 합이 j 되는 경우
변수 l = j - l 까지의 경우의 수. 
dp[i][j] += dp[i-1][j-l];
*/

import java.util.*;

public class baek2225 {
    public static long mod = 1000000000L;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [][] dp = new int[k+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n;i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= mod;
                }
            }
        }
    }
}