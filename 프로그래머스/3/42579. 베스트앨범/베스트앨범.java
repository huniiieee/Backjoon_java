import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer=new LinkedList<>();
        
        Map<String,Integer> map1=new HashMap<>();
        Map<String,List<int []>>map2=new HashMap<>();
        int len=genres.length;
        
        for(int i=0;i<len;i++){
            String genre=genres[i];
            int play= plays[i];
            
            map1.put(genre,map1.getOrDefault(genre,0)+play);
            
            map2.putIfAbsent(genre, new LinkedList<>()); 
            map2.get(genre).add(new int[]{i, play});
        }
        
        List<Map.Entry<String,Integer>> list=new LinkedList<>(map1.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<String,Integer> l : list){
            String genre=l.getKey();
            List<int []> playList=map2.get(genre);
            playList.sort((a,b)->b[1]-a[1]);
            
            answer.add(playList.get(0)[0]);
            int listLen=playList.size();
            if(listLen>=2)
                answer.add(playList.get(1)[0]);
            
        }
        return answer;
    }
}