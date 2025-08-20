class Solution {
    public static int one=0;
    public static int zero=0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len=arr.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(arr[i][j]==0) zero ++;
                else one ++;
            }
        }
        zip(arr,0,0,len);
        answer[0]=zero;
        answer[1]=one;
        return answer;
    }
    
    public void zip(int [][]arr,int r,int c,int size){
        if(size==1) return;
        
        if(check(arr,r,c,size)){
            if(arr[r][c]==1){
                one -= (size*size-1);
            }
            else{
                zero -=(size*size-1);
            }
        }
        else{
            zip(arr,r,c,size/2);
            zip(arr,r+size/2,c,size/2);
            zip(arr,r,c+size/2,size/2);
            zip(arr,r+size/2,c+size/2,size/2);
        }
        
    }
    
    public boolean check(int [][]arr,int r,int c,int size){
        int checked=arr[r][c];
        
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++)
                if(arr[i][j]!=checked){
                    return false;
                }
        }
        return true;
    }
}