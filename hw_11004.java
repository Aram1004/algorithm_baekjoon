/*
문제
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

출력
A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

예제 입력 1
5 2
4 1 2 3 5
예제 출력 1
2
 */

package algorithm.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw_11004 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort(arr);
        //quickSort(arr, 0, arr.length - 1);
        int[] temp = new int[arr.length];
        merge(arr, temp, 0, arr.length - 1);
        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] arr, int start, int end) {
        int res = partition(arr, start, end);
        if(start < res - 1) {
            // 0보다 클때 실행 (오른쪽에 하나라도 있을때)
            quickSort(arr, start, res - 1);
        } // 왼쪽탐색
        if(end > res) {
            quickSort(arr, res, end);
        }// 오른쪽 탐색

    }
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end)/2];
        while(start<=end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if(start<=end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end --;
            }
        }
        return start;
    }


    public static void merge(int[] arr,int[] temp, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            merge(arr, temp, start, middle);
            merge(arr, temp, middle + 1, end);
            // 제일 작게 분할
            merge(arr, temp, start, end, middle);

        }
    }

    public static void merge(int[] arr,int[] temp, int start, int end ,int middle) {
        for(int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = middle + 1;
        int index = start;
        while(part1 <= middle && part2 <= end) {
            // 대소비교
            if(temp[part1] <= temp[part2]) {
                // 앞에있는것이 더 작을 경우
                arr[index] = temp[part1];
                //원본 배열에 저장
                part1++;
            }else {
                arr[index] = temp[part2];
                part2++;
            }
            index ++ ;
        }
        for(int i = 0; i <= middle - part1; i++) {
            arr[index + i] = temp[part1 + i];
        } //앞쪽배열이 남아 있는 경우

    }
}


