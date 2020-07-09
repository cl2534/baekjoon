/*리모컨
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.
*/
import java.util.*;
public class baek1107 {
    static boolean [] broken = new boolean[10];
    static int channel(int num) {
        if (num == 0) {
            return broken[0] ? 0 : 1;
        }
        int len = 0;
        while (num > 0) {
            if (broken[num % 10]) {
                return 0;
            }
            len++;
            num /= 10;
        }
        return len;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            broken[sc.nextInt()] = true;
        }
        int res = n - 100; // 아예 깡으로 +,- 으로 가는 횟수. 
        if (res < 0) {
            res = -res;
        }
        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int tmp = channel(c); // 채널 누르는 횟수: 4자리 같은 경우 4번 클릭. 
            if (tmp > 0) {
                int press = n - c; // +,- 를 누르는 횟수
                if (press < 0) press = -press;
                if (res > tmp + press) {
                    res = tmp + press;
                }
            }
        }
        System.out.println(res);
    }    
}