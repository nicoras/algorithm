package LeetCode1091;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        if(m==1){
            return 1;
        }

        return bfs(grid,0,0);
    }
    private int bfs(int[][] grid,int sx,int sy){
        int[] dx = {-1,1,0,0,-1,-1,1,1};
        int[] dy = {0,0,-1,1,-1,1,-1,1};
        int step = 0;
        Queue<Pair<Integer,Integer>> q = new LinkedList();
        q.add(new Pair(sx,sy));
        visit[sx][sy] = true;
        step = 1;
        int size;
        while(!q.isEmpty()){
            size = q.size();
            for(int c=0;c<size;c++){
                //取队头
                int x = q.peek().getKey();
                int y = q.poll().getValue();
                //取所有出边
                for(int i=0;i<8;i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(!(nx<0||ny<0||nx>=m||ny>=n) && grid[nx][ny]==0 && !visit[nx][ny]){
                        q.offer(new Pair(nx,ny));
                        visit[nx][ny] = true;
                        if(nx==m-1 && ny==n-1){
                            return step += 1;
                        }
                    }
                }
            }
            step+=1;
        }
        return -1;
    }
    boolean[][] visit;
    int m,n;

}
