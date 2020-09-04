/* 
베스트 앨범 https://programmers.co.kr/learn/courses/30/lessons/42579

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

*/


public class bestAlbum {
    class Solution {
        class Song implements Comparable<Song>{
            int id, play;
            String genre;
            
            Song(int id, int play, String genre) {
                this.id = id;
                this.play = play;
                this.genre = genre;
            }
            @Override
            public int compareTo(Song o) {
                if (this.play == o.play) {
                    return this.id - o.id;
                } else {
                    return -(this.play - o.play);
                }
            }
        }
        ArrayList<Integer> bestAlbum;
        ArrayList<Song> songList;
        HashMap<String, Integer> genreMap;
        HashMap<String, Integer> albumMap;
        
        public int[] solution(String[] genres, int[] plays) {
            bestAlbum = new ArrayList<>();
            songList = new ArrayList<>();
            genreMap = new HashMap<>();
            albumMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                int id = i;
                int play = plays[i];
                String genre = genres[i];
                songList.add(new Song(id, play, genre));
                if (genreMap.containsKey(genre)) {
                    genreMap.put(genre, genreMap.get(genre) + play);
                } else {
                    genreMap.put(genre, play);
                }
            }
            Collections.sort(songList, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    if(s1.genre.equals(s2.genre)) {
                        return s1.compareTo(s2);
                    } else {
                        return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
                    }
                }
            });
            
            for (Song song : songList) {
                if (!albumMap.containsKey(song.genre)) {
                    albumMap.put(song.genre, 1);
                    bestAlbum.add(song.id);
                } else {
                    int genreCnt = albumMap.get(song.genre);
                    if (genreCnt >= 2) continue;
                    else {
                        albumMap.put(song.genre, genreCnt + 1);
                        bestAlbum.add(song.id);
                    }
                }
            }
            int [] answer = new int[bestAlbum.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = bestAlbum.get(i);
            }
            return answer;
        }
    }
}