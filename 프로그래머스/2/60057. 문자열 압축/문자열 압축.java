class Solution {
    public int solution(String s) {
        
        int answer = Integer.MAX_VALUE;
        int stringLen=s.length();
        if(stringLen==1) return 1;
        for(int i=1;i<=stringLen/2;i++){
            int len=i;
            String cur=s.substring(0,i);
            int cnt=0;
            for(int j=i;j<stringLen;j+=i){
                String temp= ((j+i)<=stringLen) ? s.substring(j,j+i) : s.substring(j,stringLen);
                if(temp.equals(cur)){
                    cnt++;
                }
                else{
                    if(cnt>0&&cnt<9){
                        len +=1;
                    }
                    if(cnt>=9&&cnt<99){
                        len +=2;
                    }
                    if(cnt>=99){
                        len +=3;
                    }
                    cnt=0;
                    len +=temp.length();
                    cur=temp;
                }
            }
            if(cnt>0&&cnt<9){
                        len +=1;
                    }
                    if(cnt>=9&&cnt<99){
                        len +=2;
                    }
                    if(cnt>=99&&cnt<999){
                        len +=3;
                    }
            if(cnt==999){
                len +=4;
            }
            answer=Integer.min(len,answer);
            // System.out.println(len);
        }
        return answer;
    }
}