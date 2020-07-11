/*1,2,3 더하기 
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
*/
import java.util.*;
public class baek9095 {
    static int go(int count, int goal) {
        if (count == goal) {
            return 1;
        }
        if (count > goal) return 0;
        int res = 0;
        for (int i = 1; i <= 3; i++) {
            res += go(count + i, goal);
        }
        return res; 
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int res = 0;
            int goal = sc.nextInt();
            res = go(0, goal);
            System.out.println(res);
        }
    }
}