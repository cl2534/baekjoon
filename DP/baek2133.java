/*
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

*/
import java.util.*;
public class baek2133 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        if (n > 1) dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * 3;
            for (int j = 0; j < i-2; j+=2) {
                dp[i] += dp[j] * 2;
            }
        } 
        System.out.println(dp[n]);
    }
}