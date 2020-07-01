/*
keys = ['abc', 'bcd'] 배열이 주어지고, String url = "www.cj.com/bcd=321&abc=235&fge=43" 이 주어질 떄,
www.cj.com/abc=235&bcd=321 로 리턴. 

중요 key points:

1. String 문자열 찾는 함수들 : 
    - indexOf(String str) 
    - matches(String str) 
    - contains(String str)
2. String 문자열 제거 함수들: 
    - substring
    - replaceAll
    - delete(int start, int end)
    - deleteCharAt(int index)
    - split 으로 새 배열을 만든다. 

*/

import java.io.*;
import java.util.*;


public class stringQuestion {

    public static void main(String [] args) {
        StringBuilder sb = new StringBuilder();
        String url = "www.cj.com/bcd=123&abc=432&cde=321";
        String [] keys = {"abc", "bcd","cde"};
        int slashIdx = url.indexOf('/');
        sb.append(url.substring(0, slashIdx+1));
        for (int i = 0; i < keys.length; i++) {
            int idx = url.indexOf(keys[i]);
            int end = 0; 
            String newStr = url.substring(idx);
            for (int j = 0; j < newStr.length(); j++) {
                if (newStr.charAt(j) == '&' || j == newStr.length() - 1) {
                    if (j == newStr.length() - 1) {
                        end = j+1;
                        break;
                    }
                    end = j;
                    break;
                }
            }
            sb.append(newStr.substring(0, end));
            if (i != keys.length - 1) {
                sb.append('&');
            }
            
        }
        System.out.println(sb); //"www.cj.com/abc=432&bcd=123&cde=321"
    }
}