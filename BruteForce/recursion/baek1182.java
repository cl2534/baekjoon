/* 부분순열
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
*/
import java.util.*;
public class baek1182 {
    static int n, m;
    static int recur(int index, int sum, int [] a) {
        if (index == a.length) {
            if (sum == m) {
                return 1;
            } else {
                return 0;
            }
        }
        return recur(index + 1, sum + a[index], a) + recur(index+1, sum, a);
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = recur(0, 0, a);
        if (m == 0) {
            ans -= 1;
        }
        System.out.println(ans);
    }
}