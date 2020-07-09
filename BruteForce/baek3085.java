/*
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 
상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 
이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
*/
import java.util.*;

public class Main {
    
    static int check(char [][] a) {
        int n = a.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                
               if (a[i][j] == a[i][j-1]) {
                   cnt++;
               } else {
                   cnt = 1;
               }
               if (cnt > res) {
                   res = cnt;
               }
                
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
               
                
               if (a[j][i] == a[j-1][i]) {
                   cnt++;
               } else {
                   cnt = 1;
               }
               if (cnt > res) {
                   res = cnt;
               }
           }  
        }
        return res;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 < n) {
                    char tmp = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = tmp;
                    int t = check(a);
                    if (t > res) {
                        res = t;
                    }
                    tmp = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = tmp;
                }
                
                if (i + 1 < n) {
                    char tmp = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = tmp;
                    int t = check(a);
                    if (t > res) {
                        res = t;
                    }
                    tmp = a[i][j];
                    a[i][j] = a[i+1][j];
                    a[i+1][j] = tmp;
                }
            }
        }
        System.out.println(res);
    }
}