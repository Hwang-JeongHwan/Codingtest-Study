package week7_BinarySearch;

import java.io.*;
import java.util.*;

public class Main {
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        arr = new long[n];
        long start = 1, mid = 0, end = 1_000_000_000_000_000_000L;
        long total = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr); // 정렬 안해도됨

        while(start <= end){
            mid = (start + end) / 2;
            total = 0;
            for(int i = 0; i < n; i++){
                total += mid / arr[i];
                if(total >= m){ // total이 더 커지면 더이상 검사할 필요없음
                    break;
                }
            }
            if(total >= m){
                end = mid - 1;

            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(start); // m이랑 같은경우 end의 범위를 조정하므로 start출력

    }
}