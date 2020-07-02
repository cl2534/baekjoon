/*
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  
{1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

Key Points:

1) 가장 긴 증가하는 부분 수열을 구한다.
for (int i = 1; i <= n; i++) {
    for (int j = 1; j < i; j++) {
        if (a[j] < a[i] && dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
        }
    }
}
2) 가장 긴 감소하는 부분 수열을 구한다. (배열 끝에서)
for (int i = n - 1; i >= 1; i--) {
    for (int j = i + 1; j <= n; j++) {
        if (a[j] < a[i] && dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
        }
    }
}
1번 + 2번 - 1 = 답. 

*/
import java.util.*;
public class baek11054 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n+1];
        int [] d2 = new int[n+1];
        int [] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        
        for (int i = n; i >= 1; i--) {
            d2[i] = 1;
            for (int j = i+1 ; j <= n; j++) {
                if (a[j] < a[i] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }
        int res = d[1] + d2[1] - 1;
        for (int i = 1; i <=n; i++) {
            if (res < d[i] + d2[i] - 1) {
                res = d[i] + d2[i] - 1;
            }
        }
        System.out.println(res);
        
        
    }
}