package week4_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class S2_1912_연속합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long[] dp = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));
        // arr[i - 1] + arr[i] < 0; arr[i] = 0 else arr[i] += arr[j]; 처음 생각은 이거였는데
        // 이렇게 하면 -만 들어온경우 최대값을 0으로 만들어버
//        for(int i = 1; i < n; i++){
//            if (arr[i] + arr[i - 1] < 0){
//                continue;
//                // arr[i] + arr[i - 1] < 0 작아지는 경우 더하지 않고 다음으로 건너뜀
//            }
//            else{
//                arr[i - 1] += arr[i];
//            }
//            // 8
//            //67 -80 -49 79 14 -20 -35 81
//            //[67, -80, 30, 93, 14, -20, 46, 81, 0]
//            // 119가 나와야함



//        }
//        System.out.println(Arrays.toString(arr));
//        long max = -1000;
//        for(int i = 0; i < n; i++){
//            if(max < arr[i]){
//                max = arr[i];
//            }
//        }
//        System.out.println(max);
        dp[0] = arr[0];
        long max = arr[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
