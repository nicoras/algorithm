package LeetCode200;

import java.util.HashSet;

public class Solution {

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m*n];

        for(int i=0;i<m*n;i++){
            fa[i] = i;
        }
        int[] dx = {1,0};
        int[] dy = {0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0'){
                    continue;
                }
                int nij = num(i,j);
                for(int k=0;k<2;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!(nx<0||ny<0||nx>=m||ny>=n) && grid[nx][ny]=='1'){
                        unionSet(nij,num(nx,ny));
                    }
                }
            }
        }
        HashSet<Integer> faIdx = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // System.out.print(fa[num(i,j)]+"_"+find(num(i,j)));
                // System.out.print(" ");
                if(grid[i][j]=='1'){
                    int a = find(num(i,j));
                    if(!faIdx.contains(a)){
                        faIdx.add(a);
                    }
                }
            }
//            System.out.println();
        }
        return faIdx.size();
    }

    //通过i,j得到一维坐标
    private int num(int i,int j){
        return i*n+j;
    }

    private int find(int x){
        if(x == fa[x]){
            return x;
        }
        return fa[x] = find(fa[x]);
    }
    private void unionSet(int x,int y){
        x = find(x);y = find(y);
        if(x!=y){
            fa[x] = y;
        }
    }
    int[] fa;
    int m,n;

}
