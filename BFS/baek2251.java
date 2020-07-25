/* 물통
각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 
이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 
이 과정에서 손실되는 물은 없다고 가정한다.

이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 
첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.
*/

class Pair {
    int x, y;
    Pair(int x , int y) {
        this.x = x;
        this.y = y;
    }
}

import java.util.*;
public class baek2251 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = new int[3];
        for(int i=0; i<3; i++) {
            a[i] = sc.nextInt();
        }
        int [] from = {0, 0, 1, 1, 2, 2}; 
        int [] to = {1, 2, 0, 2, 0, 1};
        boolean [][]check = new boolean[201][201];
        boolean [] ans = new boolean[201];
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(0, 0));
        ans[a[2]] = true;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = a[2] - x - y;
            for (int i = 0; i < 6; i++) {
                int [] next = {x, y, z};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;
                if (next[to[i]] > a[to[i]]) {
                    next[from[i]] = next[to[i]] - a[to[i]];
                    next[to[i]] = a[to[i]];
                }
                if (check[next[0]][next[1]] == false) {
                    check[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for (int i = 0; i <= a[2]; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}