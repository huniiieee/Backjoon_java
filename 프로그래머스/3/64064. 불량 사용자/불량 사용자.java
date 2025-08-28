import java.util.*;
class Solution {
    int answer=0;
    Set<String> set=new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int len=user_id.length;
        boolean [] visited=new boolean[len];
        bt(user_id,banned_id,visited,0);
        return answer;
    }
    
    public void bt(String []user_id, String []banned_id,boolean [] visited,int cnt){
        if(cnt == banned_id.length){
            if(set.add(Arrays.toString(visited))){
                 answer++;
            }
            return;
        }
        
        for(int i=0;i<user_id.length;i++){
            if(visited[i]) continue;
            if(!check(user_id[i],banned_id[cnt])) continue;
            
            visited[i]=true;
            bt(user_id,banned_id,visited,cnt+1);
            visited[i]=false;
        }
        
        
    }
    public boolean check(String real, String fake){
        
        if(real.length()!=fake.length()){
            return false;
        }
        
        int len=real.length();
        for(int i=0;i<len;i++){
            char a=real.charAt(i);
            char b=fake.charAt(i);
            if(b=='*') continue;
            if(a!=b) return false;
        }
        return true;
    }
}