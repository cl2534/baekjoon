/*
준규는 N×M 크기의 미로에 갇혀있다. 미로는 1×1크기의 방으로 나누어져 있고, 
각 방에는 사탕이 놓여져 있다. 미로의 가장 왼쪽 윗 방은 (1, 1)이고, 가장 오른쪽 아랫 방은 (N, M)이다.

준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다. 준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고, 
각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다. 또, 미로 밖으로 나갈 수는 없다.

준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.

d[i][j] = Math.max(d[i-1][j], d[i-1][j-1],d[i][j-1]) + a[i][j]
d[i][j] = i,j 오기 전까지의 대각선, 왼쪽, 오른쪽의 최댓값에 현재 값을 더해 최댓값을 저장 

*/
import java.util.*;
public class baek11048 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] a = new int[n+1][m+1];
        int [][] d = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=m; j++) {
                d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]);
                d[i][j] = Math.max(d[i][j-1], d[i][j]);
                d[i][j] += a[i][j];
            }
        }
        System.out.println(d[n][m]);
    }
}