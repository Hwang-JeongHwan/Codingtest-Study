package week7_BinarySearch;
import java.util.*;
import java.io.*;
public class S3_2512_예산 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int max = 0;
        int total = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            if(max < arr[i]){
                max = arr[i];
            }
        }

        int m = Integer.parseInt(br.readLine());
        int start = m / n, end = max, mid = 0;
        int result = 0, limit = 0;
        if(total <= m){
            System.out.println(max);
        }

        else{
            // mid < 배열의 요소 -> result += 상한가
            // mid >= 배열의 요소 -> result += 배열의 요소
            // result > m -> end = mid - 1
            // result <= m -> limit = mid , start = mid + 1

            while(start <= end){
                mid = (start + end) / 2;
                result = 0;

                for(int i = 0; i < n; i++){
                    if(mid >= arr[i]){
                        result += arr[i];
                    }
                    else{
                        result += mid;
                    }
                }
                if(result <= m){
                    limit = mid;
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            System.out.println(limit);
        }

    }
}
