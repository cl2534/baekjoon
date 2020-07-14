/* 스도쿠 

스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 
이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 
게임 시작 전 몇 몇 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

*/
import java.util.*;
public class baek2580 {
    public static final int n = 9;
    public static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }
    public static boolean go(int[][] a, boolean[][][] c, int z) {
        if (z == 81) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int x = z/n;
        int y = z%n;
        if (a[x][y] != 0) {
            return go(a, c, z+1);
        } else {
            for (int i=1; i<=9; i++) {
                if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x,y)][i]) {
                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = true;
                    a[x][y] = i;
                    if (go(a, c, z+1)) {
                        return true;
                    }
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[n][n];
        boolean[][][] c = new boolean[3][n][10];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] != 0) {
                    c[0][i][a[i][j]] = true;
                    c[1][j][a[i][j]] = true;
                    c[2][square(i,j)][a[i][j]] = true;
                }
            }
        }
        go(a, c, 0);
    }
}