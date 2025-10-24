import java.util.*;

class Solution {
    int answer=0;
    int []col;
    
    public int solution(int n) {
        col=new int[n];
        bt(0,n);
        return answer;
    }
    
    public void bt(int depth,int n){
        if(depth==n){
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++){
            col[depth] = i;
            if(check(depth)){
                bt(depth+1,n);
            }
        }
    }
    
    public boolean check(int depth){
        for(int i=0;i<depth;i++){
            if(col[i]==col[depth]) return false;
            if(Math.abs(i-depth)==Math.abs(col[i]-col[depth])) return false;
        }
        return true;
    }
}