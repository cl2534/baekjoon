/*
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

1. 각 위치 d[i][j]: i행 j 열에 최대의 합을 넣는다. 
2. j - 1 >= 0 일 경우 (처음 숫자가 아닌 중간~ 끝에 있는 숫자) d[i-1][j-1] + a[i][j] 와 d[i-1][j] + a[i][j] 를 비교한다.  
*/
import java.util.*;

public class baek1932 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] d = new int[n+1][n+1];
        int [][] a = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        d[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = d[i-1][j] + a[i][j];
                if (j - 1 >= 0 && d[i][j] < d[i-1][j-1] + a[i][j]) {
                    d[i][j] = d[i-1][j-1] + a[i][j];
                }
            }
        }
        int res = d[n][1];
        for (int i = 2; i <= n; i++) {
            res = Math.max(res, d[n][i]);
        }
        System.out.println(res);
    }
}