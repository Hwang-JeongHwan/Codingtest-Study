package week4_DynamicProgramming;
import java.util.*;
import java.io.*;
public class S2_22857_가장긴_짝수_연속한부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int evenCount = 0;
        if(arr[0] % 2 == 0){
            evenCount++;
        }
        else{
            oddCount++;
        }
        int max = evenCount;
        while(left <= right){
            if(oddCount > k){
                if(arr[left] % 2 == 0){
                    evenCount--;
                }
                else{
                    oddCount --;
                }
                left ++;
            }
            else{
                right++;
                if(right >= n){
                    break;
                }
                if(arr[right] % 2 ==0){
                    evenCount++;
                }
                else{
                    oddCount++;
                }
                max = Math.max(evenCount, max);
            }
        }
        System.out.println(max);

        /*
        long[] arr = new long[n];
        long[] dp = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
            if(arr[i] % 2 == 0){
                dp[i] = 1;
            }
            else{
                dp[i] = 0;
            }
        }
//        int evenIndex = -1;
//        for(int i = 0; i < k; i++){
//            if(dp[i] != 0){
//                evenIndex = i;
//            }
//        }

        int oddCount;
        int evenCount;

        long max = 0;
        for(int i = k; i < n; i++){

            if(dp[i] != 0) {
                oddCount = 0;
                evenCount = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] == 0) {
                        oddCount++;
                    }
                    else {
                        evenCount++;
                    }

                    if (oddCount == k) {
                        if(j == 0){
                            dp[i] = evenCount;
                        }
                        if (j - 1 >= 0 && dp[j - 1] != 0) {
                            dp[i] = ++evenCount;
                        }
                        if(j - 1 >= 0 && dp[j - 1] == 0) {
                            dp[i] = evenCount;
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(max);
//        System.out.println(Arrays.toString(dp));
        */
    }
}
