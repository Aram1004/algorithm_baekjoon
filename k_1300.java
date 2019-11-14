/*
k번째수 1300
문제
세준이는 N*N크기의 배열을 만들었다. (배열의 방 번호는 1부터 시작한다.)

그 배열을 A라고 했을 때, 배열에 들어가는 수는 A[i][j] = i*j 이다.

세준이는 이 수를 일차원 배열 B에 넣으려고 한다. 그렇게 되면, B의 크기는 N*N이 될 것이다. 그러고 난 후에, B를 오름차순 정렬해서 k번째 원소를 구하려고 한다.

N이 주어졌을 때, k번째 원소를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, n2)보다 작거나 같은 자연수이다.*/


package algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class k_1300 {

    public static void main(String[] args) throws IOException {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = (int) Math.min((long) N * N, (long) 10000);
        int mid;
        int ans = 0;

        while (left <= right) {

            mid = (left + right) / 2;

            int cnt = getCnt(mid, N);

            if (cnt >= K) {

                ans = mid;
                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static int getCnt(int x, int N) {

        int cnt = 0;

        for (int i = 1; i <= N; i++) {

            cnt += Math.min(x / i, N);
        }

        return cnt;
    }
}
