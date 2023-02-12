package week5_DynamicProgramming2;
import java.util.*;
import java.io.*;
public class S1_22869_징검다리_건너기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 2; i < n + 1; i ++){
            for(int j = 1; j < i + 1; j ++){
                if(dp[j] && (i - j) * (1 + Math.abs(arr[i] - arr[j])) <= k){
                    dp[i] = true;
                    break;
                }
            }
        }
        if(dp[n]){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
