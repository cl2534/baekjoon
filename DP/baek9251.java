/*
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

    0   A   C   A   Y   K   P
0   0   0   0   0   0   0   0
C   0   0   1   1   1   1   1
A   0   1   1   2   2   2   2
P   0   1   1   2   2   2   3
C   0   1   2   2   2   2   3
A   0   1   2   3   3   3   3
K   0   1   2   3   3   4   4

만약 두 캐릭터가 같을 경우,  d[i][j] = d[i-1][j-1] + 1
만약 두 캐릭터가 다를 경우, d[i][j] = Math.max(d[i-1][j], d[i][j-1]); 
*/

import java.util.*;

public class baek9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int [][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for (int x = 1; x <= str1.length(); x++) {
            char c1 = str1.charAt(x-1);
            for (int y = 1; y <= str2.length(); y++) {
                char c2 = str2.charAt(y - 1);
                if (c1 == c2) {
                    dp[x][y] = dp[x-1][y-1] + 1;
                } else {
                    dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}