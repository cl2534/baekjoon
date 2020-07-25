/* 스타트링크
강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.

스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 
강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.

보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. 
U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)

강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 
만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
*/

import java.util.*;
public class baek5014 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        int[] dist = new int[f+1];
        boolean[] check = new boolean[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        check[s] = true;
        while(!q.isEmpty()) {
            int floor = q.remove();
            if (floor + u <= f && check[floor + u] == false) {
                check[floor + u] = true;
                dist[floor + u] = dist[floor] + 1;
                q.add(floor + u);
            }
            
            if (floor - d >= 1 && check[floor - d] == false) {
                check[floor - d] = true;
                dist[floor - d] = dist[floor] + 1;
                q.add(floor - d);
            }
        }
        if (check[g]) {
            System.out.println(dist[g]);
        } else {
            System.out.println("use the stairs");
        }
    }
}