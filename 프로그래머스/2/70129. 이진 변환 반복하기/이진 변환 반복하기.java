class Solution {
    public static int zeroCnt=0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;
        while(!s.equals("1")){
            s=removeZero(s);
            s=binary(s);
            cnt++;
        }
        answer[0]=cnt;
        answer[1]=zeroCnt;
        return answer;
    }
    
    public String removeZero(String s){
        String temp=s.replaceAll("0","");
        zeroCnt +=s.length()-temp.length();
        return temp;
    }
    
    public String binary(String s){
        return Integer.toBinaryString(s.length());
    }
}