class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length==1) return sticker[0];
        int len=sticker.length;
        int []first=new int[len];
        int []second=new int[len];
        
        for(int i=1;i<len;i++){
            first[i]=sticker[i-1];
            second[i]=sticker[i];
        }
        
        for(int i=2;i<len;i++){
            first[i]=Integer.max(first[i-1],first[i-2]+first[i]);
            second[i]=Integer.max(second[i-1],second[i-2]+second[i]);
        }
        
        return Integer.max(first[len-1],second[len-1]);
    }
}