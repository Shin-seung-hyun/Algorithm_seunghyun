import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
// 1. 장르 선정
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }
        //classic: 1450 , pop:3100
        
        //key값만 가져와서 genre에 넣기
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        //value에 따라 key값 내림차순 정렬
        //pop, classic
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1)); 
        
// 2. 장르 내 노래 선정
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);
            
            //해당 장르의 음악 중에서 play횟수가 가장 큰 인덱스 찾기
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }
            
            //해당 장르의 음악 중에서 play횟수가 두번째로 큰 인덱스 찾기
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) { 
                    max = plays[j];
                    secondIdx = j;
                }
            }
            
            list.add(firstIdx);
            if(secondIdx >= 0) list.add(secondIdx); //secondIdx는 존재 할 수도, 안 할 수도 있음
        }
        
// 3. print result
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}