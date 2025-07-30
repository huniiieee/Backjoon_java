import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len=commands.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++)
            answer[i]=sortK(array,commands[i][0],commands[i][1],commands[i][2]);
        
        return answer;
    }
    public int sortK(int []array,int i,int j,int k){
        int len=j-i+1;
        int []temp=new int[len];
        for(int t=0;t<len;t++)
            temp[t]=array[t+i-1];
        Arrays.sort(temp);
        return temp[k-1];
    }
}