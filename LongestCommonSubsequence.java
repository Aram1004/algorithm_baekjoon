public class LongestCommonSubsequence {

    public static int find(char[] A, char[] B) {
        int[][] LCS = new int[A.length + 1][B.length + 1];
        String[][] solution = new String[A.length + 1][B.length + 1];
        // if A is null then LCS of A, B =0
        for (int i = 0; i <= B.length; i++) {
            LCS[0][i] = 0;
            solution[0][i] = "0";
        }

        // if B is null then LCS of A, B =0
        for (int i = 0; i <= A.length; i++) {
            LCS[i][0] = 0;
            solution[i][0] = "0";
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        return LCS[A.length][B.length];
    }
    public static void main(String[] args) {
        String A = "ACBDEA";
        String B = "ABCDA";
        System.out.println("LCS :" + find(A.toCharArray(), B.toCharArray()));
    }
}