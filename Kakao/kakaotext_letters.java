import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
class kakaotext_letters {
  public static void main(String [] args) {

  }
  aabbaccc 2a2ba3c
  ababcdcdababcdcd
  abcabcdede

  public int solution(String s) {
    int answer = s.length();
    for (int i = 1; i <= s.length() / 2; i++) {
      int pos = 0;

      for (;pos + i <= s.length(); ) {
        String unit = s.substring(pos, pos+i);
        pos += i;
        int cnt = 0;
        for (; pos + i <= s.length();) {
          if (unit.equals(pos, pos+i)) {
            pos+= i;
            cnt++;
          } else {
            break;
          }
        }
        if (cnt > 0) {
          len -= cnt * i;
          if (cnt < 9) len += 1;
          else if (cnt < 99) len += 2;
          else if (cnt < 999) len += 3;
          else len += 4;
        }
      }
      answer = Math.min(answer, len);
    }
  }

}
