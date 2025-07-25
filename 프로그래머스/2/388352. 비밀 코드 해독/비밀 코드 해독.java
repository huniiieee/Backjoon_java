import java.util.*;
class Solution {
    int answer=0;
    int N=0;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        Set<Integer> set=new HashSet<>();
        N=n;
        dfs(set,q,ans,0,0);
        
        return answer;
        
        
    }
    public void dfs(Set<Integer> set,int [][]q,int []ans,int cnt,int pre){
        if(cnt==5){
            if(check(set,q,ans)){
                answer++;
            }
            return;
        }
        
        for(int i=pre+1;i<=N;i++){
            set.add(i);
            dfs(set,q,ans,cnt+1,i);
            set.remove(Integer.valueOf(i));
        }
    }
    
    public boolean check(Set<Integer>set, int[][]q,int []ans){
        int len=q.length;
        boolean flag=true;
        for(int i=0;i<len;i++){
            int cnt=0;
            for(int j=0;j<5;j++){
                if(set.contains(q[i][j])) cnt++;
            }
            if(cnt!=ans[i]){
                flag=false;
                break;
            }
        }
        return flag;
    }  
}