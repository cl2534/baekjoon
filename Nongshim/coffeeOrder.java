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

    int [] coffee_times = new int[]{4, 2, 2, 5, 3};
    ArrayList<Integer> res = new ArrayList<Integer>();
    int time = 0;
    ArrayList<Coffee> list = new ArrayList<Coffee>();
  
    for (int i = 0; i < coffee_times.length; i++) {
      list.add(new Coffee(i+1, coffee_times[i]));
    }
    ArrayList<Coffee> order = new ArrayList<Coffee>(3);
    for (int i = 0; i < 3; i++) {
      Coffee cof = new Coffee(i+1, coffee_times[i]);
      order.add(cof);
      list.remove(i);
    }
  
    while(res.size() != coffee_times.length) {
      time++;
      int cnt = 0;
      for (int i = 0; i < order.size(); i++) {
        Coffee co = order.get(i);
        if (co.order_time == time) {
          res.add(co.order_num);
          co.remove(i);
          cnt++;
        }
      }
  
      for (int i = 0; i < cnt; i++) {
        order.add(list.get(i));
      }
      
  
    }
  
  
    }
}
