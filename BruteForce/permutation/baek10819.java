/*차이를 최대로
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.


*/
import java.util.*;
public class baek10819 {
    static boolean next_perm(int [] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -=1;
        }
        if (i <= 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }
        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;
        j = a.length - 1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i+=1;
            j-=1;
        }
        return true;
    }
    public static int calculate(int a[]) {
        int sum = 0;
        for (int i=1; i<a.length; i++) {
            sum += Math.abs(a[i] - a[i-1]);
        }
        return sum;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        do {
            int temp = calculate(a);
            ans = Math.max(ans, temp);
        } while(next_permutation(a));

        System.out.println(ans);
    }
}