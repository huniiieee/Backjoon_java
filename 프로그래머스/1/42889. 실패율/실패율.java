import java.util.*;

class Solution {
    
    class StageInfo implements Comparable<StageInfo>{
        int stage;
        int total;
        int fail;
        
        public StageInfo(int stage,int total, int fail){
            this.stage=stage;
            this.total=total;
            this.fail=fail;
        }
        
        @Override
        public int compareTo(StageInfo o) {
            long lhs = (long) this.fail * o.total;
            long rhs = (long) o.fail * this.total;
            if (lhs != rhs) {
                return Long.compare(rhs, lhs); 
            }
            return Integer.compare(this.stage, o.stage);
        }

        
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] count=new int[N+1];
        for(int i=0;i<stages.length;i++){
            if(stages[i]>N) continue;
            count[stages[i]]++;
        }
        
        int total=stages.length;
        List<StageInfo> list=new ArrayList<>();
        for(int i=1;i<=N;i++){
            int fail=count[i];
            list.add(new StageInfo(i,total,fail));
            total -=fail;
        }
        
        Collections.sort(list);
        for(int i=0;i<N;i++){
            answer[i]=list.get(i).stage;
        }
        return answer;
    }
}