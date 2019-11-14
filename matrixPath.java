public class matrixPath {
    int matrixPath(int[][] m, int i, int j, int[][] cache) {
        if(i == 0 && j == 0) return cache[0][0];
        else if (i == 0) {
            cache[i][j] = (cache[0][j - 1] != 0) ? (cache[0][j - 1] + m[0][j]) : (matrixPath(m, 0, j - 1, cache) + m[0][j]);
            return cache[i][j];
        }
        else if (j == 0) {
            cache[i][j] = (cache[i - 1][0] != 0) ? (cache[i - 1][0] + m[i][0]) : (matrixPath(m, i - 1, 0, cache) + m[i][0]);
            return cache[i][j];
        }
        int a = (cache[i - 1][j] != 0) ? (cache[i - 1][j]) : (matrixPath(m, i - 1, j, cache));
        int b = (cache[i][j - 1] != 0) ? (cache[i][j - 1]) : (matrixPath(m, i, j - 1, cache));
        return cache[i][j] = Math.max(a, b) + m[i][j];
    }

}
