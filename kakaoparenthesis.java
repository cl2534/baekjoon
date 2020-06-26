import java.util.*;
import java.io.*;

class kakaoparenthesis {
  static int pos = 0;
  public static void main(String [] args) {

  }

  public boolean isCorrect(String s) {
    Stack<Character> stack = new Stack<Character>();
    int left = 0;
    int right = 0;
    boolean ans;
    for (int i =0 ;i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
        stack.push(s.charAt(i));
      } else {
        right++;
        if (stack.isEmpty()) {
          ans = false;
        } else {
          stack.pop();
        }
      }
      if (left == right) {
        pos = i+1;
        return ans;
      }
    }
    return true;
  }
  public String solution(String p) {
    if (p.isEmpty()) return p;
    boolean correct = isCorrect(p);
    String u = p.substring(0, pos);
    String v = p.substring(pos, p.length());
    if (correct) {
      return u + isCorrect(v);
    }
    String answer = "";
    answer = "(" + solution(v) + ")";
    for (int i = 1; i < u.length() - 1; i++) {
      if (u.charAt(i) == '(') {
        answer += ")";
      } else {
        answer += "(";
      }
    }
    return answer; 

  }
}
