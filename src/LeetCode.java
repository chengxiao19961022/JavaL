import static net.mindview.util.Print.*;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];
        int result[][] = new int[n][n];
        for (int i = 0; i<n; ++i){
            for (int j = 0; j<n; ++j)
                result[i][j] = -1;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int r = 0, c = 0, ne = 0;
        for (int i = 1; i<n*n+1; ++i){
            result[r][c] = i;

            int nr = r+dy[ne], nc = r+dx[ne];
            if(nr>=0&&nr<n&&nc>=0&&nc<n&&result[nr][nc] == -1){
                r = nr; c = nc;
            }else {
                ne = (ne+1)%4;
                r+=dy[ne]; c+=dx[ne];
            }
        }
        return result;

    }
}

class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();
        int Row = matrix.length, Colume = matrix[0].length;
        boolean[][] booked = new boolean[Row][Colume];
        List<Integer> result = new ArrayList<Integer>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int r = 0, c = 0, ne = 0;
        for (int i = 0; i<Row*Colume; ++i){
            result.add((Integer) matrix[r][c]);
            booked[r][c] = true;
            int nr = r+dy[ne], nc = r+dx[ne];
            if(nr>=0&&nr<Row&&nc>=0&&nc<Colume&&!booked[nr][nc]){
                r = nr; c = nc;
            }else {
                ne = (ne+1)%4;
                r+=dy[ne]; c+=dx[ne];
            }
        }
        return result;
    }
}

public class LeetCode {


    public static void main(String args[]){

        List<ArrayList<Integer>> ll = new ArrayList<ArrayList<Integer>>(3);
        for (int i = 0; i<ll.size(); ++i){
            ll.set(i, new ArrayList<Integer>(5));
        }


    }
}
