/* 쉬운 계단 수

45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

길이가 i 일 떄 마지막 숫자가 j 인 경우: d[i][j]

1) j > 1 일 떄, d[i][j] += d[i-1][j-1]
2) j < 9 일 때, d[i][j] += d[i-1][j+1];

각 숫자의 양쪽에서 j-1 , j+1 을 더한다. 
*/
import java.util.*;

public class baek10844 {
    static int mod = 1000000;
    public static void main(String [] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [][] d = new long[n+1][10];
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                if (j + 1 <= 9) {
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }
        
        long res = 0;
        for (int i = 0; i <= 9; i++) {
            res += d[n][i];
        }
        res %= mod;
        System.out.println(res);
    }
}