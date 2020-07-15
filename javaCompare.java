// Practice Java Comparators 
import java.util.*;
class javaCompare {

  public static void main(String [] args) {
    Player p1 = new Player(50, "James");
    Player p2 = new Player(40, "Abbey");
    Player p3 = new Player(100, "Cathy");
    Player p4 = new Player(20, "David");
    List<Player> list = new LinkedList<Player>();
    list.add(p1);
    list.add(p2);
    list.add(p3);
    list.add(p4);

    //ArrayList Object 정렬
    Collections.sort(list, (a,b) -> a.name.compareTo(b.name));
    Collections.sort(list, (a,b) -> a.score - b.score);

    //Array 내림차순 정렬
    Integer [] arr = new Integer[]{1,40, 30, 50,100};
    Arrays.sort(arr, Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    System.out.println(list);

  }
}

class Player {
  int score; String name;


  public String toString() {
    return "(name : " + name + ", score: " + score + ")";
  }

  Player(int score, String name) {
    this.score = score;
    this.name = name;
  }
}
