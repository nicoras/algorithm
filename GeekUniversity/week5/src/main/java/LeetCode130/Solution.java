package LeetCode130;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visit[i][j]=false;
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&&!visit[i][j]){
                    //一次bfs找到一堆点
                    List<Pair<Integer,Integer>> cl = bfs(board,i,j);
                    cll.add(cl);
                    ans++;

                }
            }
        }
        //遍历cll,check当中是否有边界'O',如果cl没有边界'O'，将'O'翻转
        for(List<Pair<Integer,Integer>> cl:cll){
            if(check(cl)){
                change(cl,board);
            }
        }
        // return ans;
    }
    private boolean visit[][];
    private int m,n;
    private List<List<Pair<Integer,Integer>>> cll = new ArrayList<>();
    //验证,true通过
    private boolean check(List<Pair<Integer,Integer>> cl){
        for(Pair<Integer,Integer> p:cl){
            int x = p.getKey();
            int y = p.getValue();
            if(x==0||x==m-1||y==0||y==n-1){
                return false;
            }
        }
        return true;
    }
    //将'O'改为'X'
    private void change(List<Pair<Integer,Integer>> cl,char[][] grid){
        for(Pair<Integer,Integer> p:cl){
            int x = p.getKey();
            int y = p.getValue();
            grid[x][y] = 'X';
        }
    }
    private List<Pair<Integer,Integer>> bfs(char[][] grid,int sx,int sy){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        List<Pair<Integer,Integer>> cl = new ArrayList<>();
        Queue<Pair<Integer,Integer>> q = new LinkedList<Pair<Integer,Integer>>();
        //当前点入队;
        q.offer(new Pair<Integer,Integer>(sx,sy));
        visit[sx][sy]=true;
        cl.add(new Pair<Integer,Integer>(sx,sy));
        while(!q.isEmpty()){
            //取队头
            int x = q.peek().getKey();
            int y = q.poll().getValue();
            //取所有出边
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                //判断边界合法性
                if(nx<0||ny<0||nx>=m||ny>=n){
                    continue;
                }
                if(grid[nx][ny]=='O'&&!visit[nx][ny]){
                    q.offer(new Pair<Integer,Integer>(nx,ny));
                    cl.add(new Pair<Integer,Integer>(nx,ny));
                    //入队时标记visit
                    visit[nx][ny]=true;
                }
            }
        }
        return cl;

    }
}
