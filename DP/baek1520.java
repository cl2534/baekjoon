/*
내리막길 

여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 
그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.
지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.

dfs로 푼다. 
d[i][j] = i,j 에서 n, m 끝까지 길이 몇개 있는지 저장.
*/

import java.util.*;
public class baek1520 {
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static int [][] dp;
    static int [][] map;
    static int n;
    static int m;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
         dp = new int[n][m];
        
        for (int i = 0 ;i < n; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
               
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];
        if (x == n-1 && y == m-1) return 1;
        
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx,ny);
            }
        }
        
        return dp[x][y];
    }
}