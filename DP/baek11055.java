/*
수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 
합이 가장 큰 증가 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.

dp[i] = a[i] 로 시작 (리셋 값 시작)
i 와 j 를 돌려서 a[i] > a[j] 인 경우에, d[i] < d[j] + a[i] (최댓값). 
그러므로 각 d[i] 에는 증가하면서 최댓값이 들어가있다. 
*/
import java.util.*;
public class baek11055 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n+1];
        int [] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        
       
        for (int i = 1 ; i<= n; i++) {
            d[i] = a[i];
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + a[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }
        int res = d[1];
        for (int i = 1 ; i <= n; i++) {
            res = Math.max(d[i], res);
        }
        System.out.println(res);
    }
}