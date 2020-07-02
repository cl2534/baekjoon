/*
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

d[i][j] = d[i][target - coin[i]] + 1;

*/
import java.util.*;
public class baek2294 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] a = new int[n];
        int [] d= new int[m+1];
        
        for (int i =0 ; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m+1; i++) {
            d[i] = -1;
        }
        d[0] = 0;
        for (int j = 0; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                if (j - a[i] >=0 && d[j - a[i]] != -1) {
                    if (d[j] == -1 || d[j] > d[j-a[i]]+ 1) {
                        d[j] = d[j-a[i]] + 1;
                    }
                }
            }
        }
        System.out.println(d[m]);
    }
    
}