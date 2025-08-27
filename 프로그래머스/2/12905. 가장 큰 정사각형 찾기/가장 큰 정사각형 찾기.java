class Solution
{
    public int solution(int [][]board)
    {
        if(allZero(board)) return 0;
        int answer=1;
        int r=board.length;
        int c=board[0].length;
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(board[i][j]==0) continue;
                board[i][j]=Integer.min(Integer.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                answer=Integer.max(answer,board[i][j]);
            }
        }
        return answer*answer;
    }
    

    
    public boolean allZero(int [][]board){
        boolean result=true;
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1) return false;
            }
        }
        return true;
    }
}