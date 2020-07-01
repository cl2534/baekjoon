/*
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

key points: 
d[i][j] = 각 i, j 에 i, j까지의 모든 value 의 합을 넣는다. 
단, d[i][j] 는 d[i][j] = d[i-1][j] - d[i][j-1] + d[i-1][j-1] 
*/

import java.util.*;

public class baek2167 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] memo = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                memo[i][j] = memo[i-1][j] - memo[i-1][j-1] + memo[i][j-1] + sc.nextInt();
            }
        }
        int t = sc.nextInt();
        int [] res = new int[t];
        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            res[i] = memo[x2][y2] + memo[x1-1][y1-1] - memo[x1 - 1][y2] - memo[x2][y1-1];
        }
        for (int sum : res) {
            System.out.println(sum);
        }
    }
}