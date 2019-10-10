/*
숫자카드 10815

문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이가 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다*/

package algorithm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class numcard_10815{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] beforeAArray = br.readLine().split(" ");
        int[] aArray = new int[n];

        for(int i=0; i< beforeAArray.length; i++){
            aArray[i] = Integer.parseInt(beforeAArray[i]);
        }

        Arrays.sort(aArray);

        int m = Integer.parseInt(br.readLine());
        String[] beforeComArray = br.readLine().split(" ");
        int[] compareArray = new int[m];

        for(int j=0; j<beforeComArray.length; j++){
            compareArray[j] = Integer.parseInt(beforeComArray[j]);
        }

        for(int i =0; i<compareArray.length; i++){
            int flag = 0;

            int max = n;
            int min = 0;
            int middle;

            while(max - min > 1){
                middle = (min+max)/2;

                if(compareArray[i] == aArray[0]){
                    flag = 1;
                    break;
                }

                if(compareArray[i] == aArray[middle]){
                    flag = 1;
                    break;
                }
                if(compareArray[i] > aArray[middle]){
                    min = middle;
                }else if(compareArray[i] < aArray[middle]){
                    max = middle;
                }

            }
            System.out.print(flag+" ");

        }
    }
}

