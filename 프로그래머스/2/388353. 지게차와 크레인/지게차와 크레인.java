import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0,0,1,-1};
    int answer=0;
    int n=0;
    int m=0;
    public int solution(String[] storage, String[] requests) {
        

        n = storage.length;
        m = storage[0].length();
        answer= n*m;
        for(String request : requests){
            boolean[][] visited = new boolean[n][m];
            if(request.length() == 1){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(storage[i].charAt(j) == request.charAt(0) && check(i, j, n, m, storage)){
                            visited[i][j] = true;
                        }
                    }
                }
            }
            else{
                char temp = request.charAt(0);
                for(int i = 0; i < n; i++){
                    for(int j = 0 ; j < m; j++){
                        if(storage[i].charAt(j) == temp)    visited[i][j] = true;
                    }
                }
            }

            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < m; j++){
                    if(visited[i][j]){
                        storage[i] = storage[i].substring(0, j) + "o" + storage[i].substring(j+1);
                        answer--;
                    }
                }
            }
        }
        
        return answer;
    }
    public boolean check(int x, int y, int n, int m, String[] storage){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nx = tmp[0];
            int ny = tmp[1];

            for(int i = 0 ; i < 4; i++){
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if(nextX < 0 || nextX > n-1 || nextY < 0 || nextY > m-1) return true;

                if(!visited[nextX][nextY] && storage[nextX].charAt(nextY) == 'o'){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return false;
    }
}