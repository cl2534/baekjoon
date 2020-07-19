/*
 KEY POINTS :
 1. Arraylist.remove(index) / Arraylist.remove(Object o);
 2. remove(index) 를 할 경우, 해당 인덱스의 배열은 사라지기 떄문에 For Loop 전에 cnt 변수를 만들어서 지운다.

 만약 remove(index) 말고 remove(Object o) 로 접근했을 떄의 solution 은 나중에 풀어보도록. 
*/


public class Coffee {
    int order_num;
    int order_time;
    Coffee(int order_num, int order_time) {
      this.order_num = order_num;
      this.order_time = order_time;
    }
}

public class coffeeOrder {
  public static void main(String [] args) {
    int N = 3;
    int [] coffee_times = new int[]{4, 2, 2, 5, 3};
    ArrayList<Integer> res = new ArrayList<Integer>();
    ArrayList<Coffee> list = new ArrayList<Coffee>();

    for (int i = 0; i < coffee_times.length; i++) {
      list.add(new Coffee(i+1, coffee_times[i]));
    }
    ArrayList<Coffee> order = new ArrayList<Coffee>(3);
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      Coffee cof = new Coffee(i+1, coffee_times[i]);
      order.add(cof);
      list.remove(i - cnt);
      cnt++;
    }

    for (int time = 0; ; time++) {
      ArrayList<Integer> idx = new ArrayList<Integer>();
      for (int i = 0; i < order.size(); i++) {
        Coffee co = order.get(i);
        if (co.order_time == time) {
          res.add(co.order_num);
          idx.add(i);
        }
      }
      if (idx.size() > 0) {
        int count = 0;                                    // 2번 Key points
        for (int i =0 ; i < idx.size(); i++) {
          order.remove(idx.get(i) - count);
          count++;
        }
        int listCnt = 0;                                  // 2번 Key points 
        if (list.size() > 0) {
          for (int i = 0; i < count; i++) {
            Coffee co = list.get(i-listCnt);
            co.order_time += time;
            order.add(co);
            list.remove(i - listCnt);
            listCnt++;
          }
        }
      }
      if (res.size() == coffee_times.length) break;
    }
    int [] ans = new int[res.size()];
    for (int i =0 ; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    //return ans; 
  }
}
