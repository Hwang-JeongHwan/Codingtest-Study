package week6;
import java.io.*;
import java.util.*;

public class G5_5557_1학년 {
    private static long[][] dp; // 2^63-1 => 8byte -> long
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int left, right, n;
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][21];
        arr = new int [n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][arr[1]] = 1;
        for(int i = 2; i < n; i++){ // n번째 수는 연산하지 않음
            for(int j = 0; j <= 20; j++){ // 중간에 나오는 수는 모두 0 이상 20이하
                if(dp[i - 1][j] != 0){
//                    System.out.println(j);
                    left = j - arr[i];
                    right = j + arr[i];
                    if(left >= 0 && left <= 20){ // 0이상 20이하면
                        dp[i][left] += dp[i - 1][j];

                    }

                    if(right >= 0 && right <= 20){
                        dp[i][right] += dp[i - 1][j];
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n - 1][arr[n]]); // n번째 수는 연산하지 않음
    }
}
