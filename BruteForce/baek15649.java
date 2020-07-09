/* N 과 M 수열
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*/
import java.util.*;
public class baek15649 {
    static boolean[] c = new boolean[10];
    static int [] a = new int[10];
    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false;
        }
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
    }
}