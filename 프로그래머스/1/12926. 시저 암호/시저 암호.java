class Solution {
    public String solution(String s, int n) {
        char [] lower = new char[26];
        char [] upper = new char[26];
        for(int i=0;i<26;i++){
            lower[i]=(char)('a'+i);
            upper[i]=(char)('A'+i);
        }
        
        String answer = "";
        for(char a:s.toCharArray()){
            if(Character.isUpperCase(a)){
                int idx= a - 'A';
                idx = (idx+n)%26;
                answer += upper[idx];
            }
            else if(Character.isLowerCase(a)){
                int idx= a - 'a';
                idx = (idx+n)%26;
                answer += lower[idx];
            }
            else{
                answer +=a;
            }
        }
        return answer;
    }
}