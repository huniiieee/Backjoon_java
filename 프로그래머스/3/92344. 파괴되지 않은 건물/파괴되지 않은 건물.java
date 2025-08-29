class Solution {
    int answer=0;
    int r=0;
    int c=0;
    public int solution(int[][] board, int[][] skill) {
        int len=skill.length;
        r=board.length;
        c=board[0].length;
        
        int [][] diff= calDiff(skill);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j] +=diff[i][j];
            }
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
                if(board[i][j]>0) answer++;
        }
        return answer;
    }
    
    public int [][] calDiff(int [][]skills){
        
        int [][] temp=new int [r+1][c+1];
        for(int []skill : skills){
            int type=skill[0];
            int r1=skill[1];
            int r2=skill[3];
            int c1=skill[2];
            int c2=skill[4];
            int degree= (type==1) ? -skill[5] : skill[5];
            
            temp[r1][c1] +=degree;
            temp[r1][c2+1] -=degree;
            temp[r2+1][c1] -=degree;
            temp[r2+1][c2+1] +=degree;
        }
        
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                temp[i][j] +=temp[i][j-1];
            }
        }
        
        for(int i=0;i<c;i++){
            for(int j=1;j<r;j++){
                temp[j][i] +=temp[j-1][i];
            }
        }
        
        return temp;
    }
    
}