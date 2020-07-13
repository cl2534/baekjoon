/* 부분순열의 합
수열 S가 주어졌을 때, 수열 S의 부분 수열의 합으로 나올 수 없는 가장 작은 자연수를 구하는 프로그램을 작성하시오.

예를 들어, S = [5, 1, 2]인 경우에 1, 2, 3(=1+2), 5, 6(=1+5), 7(=2+5), 8(=1+2+5)을 만들 수 있다. 하지만, 4는 만들 수 없기 때문에 정답은 4이다.
*/
import java.util.*;
public class baek14225 {
    static boolean[] c = new boolean[20*100000+10];
    static int[] a = new int[20];
    static int n;
    
    static void recur(int index, int sum) {
        if (index == n) {
            c[sum] = true;
            return;
        }
        recur(index + 1, sum + a[index]);
        recur(index + 1, sum);
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        recur(0, 0);
        for (int i = 1; ;i++) {
            if(c[i] == false) {
                System.out.println(i);
                break;
            }
        }
    }
}