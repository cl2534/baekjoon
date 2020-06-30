/* 오르막 수 
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

i 는 길이, j 는 마지막 숫자, k 는 그전의 숫자.


*/

import java.util.*;
public class baek11057 {
    static int mod = 10007;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] d = new int[n+1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;                // 길이의 1인 모든 숫자는 1
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i-1][k]; // i 는 길이, j 는 마지막숫자, k 는 그 전 (i-1) 의 숫자 (j 보다 낮아야함)
                    d[i][j] %= mod;
                }
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