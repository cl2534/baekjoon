/* 
완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.



*/

public class incompleteAthelete {
    public String solution(String[] participant, String[] completion) {
        String result = "";
        /*
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                int cnt = map.get(participant[i]);
                map.put(participant[i], ++cnt);
            } else {
                map.put(participant[i], 1);
            }
        }
        for (String name : completion) {
            int val = map.get(name);
            map.put(name, --val);
        }
        for (String key : map.keySet()) {
            if (map.get(key) >= 1) {
                result += key;
            }
        }
        return result;
        */
        for (int i = 0; i < participant.length; i++) {
            boolean flag = true;
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    completion[j] = null;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += participant[i];
            }
        }
        return result;
    }
}