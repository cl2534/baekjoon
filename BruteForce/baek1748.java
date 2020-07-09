/*수 이어쓰기 1
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

1 ~ 9 -> 1자리 수 : 9개 * 1자리 = 9개.
10 ~ 99 -> 2자리 수: 90개 * 2자리 = 180개.
100 ~ 999 -> 3자리 수: 900개 * 3자리 = 2700 개 
..

for (int start = 1; start <= n; start *= 10) {
    end = (start * 10) - 1;
    if (end > n) {
        end = n;
    }
    res += (end - start + 1) * len;
    len++;
}
*/
public class baek1748 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 1;
        int ans = 0;
        int end = 0;
        for (int start = 1; start <= n; start*=10) {
            end = (start * 10) - 1;
            if (end > n) {
                end = n;
            }
            ans += (end - start + 1) * len;
            len++;
        }
        System.out.println(ans);
    }
}