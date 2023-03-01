package week7_BinarySearch;
import java.util.*;
import java.io.*;
public class S2_1654_랜선자르기 {
    static long[] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long total = 0;
        long start = 1; // 1로 해야 0으로 나누지 않음
        // input이 1 1
        //         1 이렇게 들어오면
        // start = 0, end = 0, mid = 0 arr[i] / 0을 해버림
        long len = 0,  end = 0, mid = 0;
        arr = new long[k];

        for(int i = 0; i < k; i++){
            arr[i] = Long.parseLong(br.readLine());

        }
        Arrays.sort(arr);
        end = arr[k - 1] + 1; // arr[1, 1] 이면 0으로 나누게됨

        while(start <= end){
            mid = (start + end) / 2;
            total = 0;
            for(int i = 0; i < k; i++){
                total += arr[i] / mid;
            }
            if(total >= m){
                len = mid;
                start = mid + 1; // int일때  mid + 1을 하면 오버플로우 발생 long으로 바꿔줌
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(len);
    }
}
