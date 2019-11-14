
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class matrix {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T, N;

        T = sc.nextInt();

        for(int testNum=1; testNum<=T; testNum++) {
            N = sc.nextInt();
            int[][] m = new int[N][N];
            int[][] cache = new int[N][N];
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    m[r][c] = sc.nextInt();
                }
            }
            cache[0][0] = m[0][0];
            System.out.println("#"+testNum+": " + cost(m, N-1, N-1, cache));
        }
    }

    private static int cost(int[][] m, int i, int j) {
        if(i==0 && j==0) return m[0][0];

        if(i==0) return cost(m, 0, j-1) + m[0][j];
        if(j==0) return cost(m, i-1, 0) + m[i][0];

        return (Math.max(cost(m, i-1, j), cost(m, i, j-1)) + m[i][j]);
    }

    private static int cost(int[][] m, int i, int j, int[][] cache) {
        if(i==0 && j==0)
            return cache[0][0];

        if(i==0){
            cache[i][j] = (cache[0][j-1] != 0) ? (cache[0][j-1] + m[0][j])
                    : (cost(m,0,j-1,cache) + m[0][j]);
            return cache[i][j];
        }

        if(j==0) {
            cache[i][j] = (cache[i-1][0] != 0) ? (cache[i-1][0] + m[i][0])
                    : (cost(m, i-1, 0, cache) + m[i][0]);
            return cache[i][j];
        }

        int A = (cache[i-1][j] != 0) ? (cache[i-1][j]) : (cost(m, i-1, j, cache));
        int B = (cache[i][j-1] != 0) ? (cache[i][j-1]) : (cost(m, i, j-1, cache));
        cache[i][j] = Math.max(A, B) + m[i][j];
        return cache[i][j];
    }
}
