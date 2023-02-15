package week5_DynamicProgramming2;
import java.io.*;
import java.util.*;

public class G5_15486_퇴사2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][2];
        int[] dp = new int[n + 2];

        for(int i = 1; i  < n + 1; i ++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int maxNum = -1;
        for(int i = 1; i < n + 2; i ++){
            if(dp[i] > maxNum){
                maxNum = dp[i];
            }
            if(i + arr[i][0] < n + 2){
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], maxNum + arr[i][1]);
            }
        }
        System.out.println(dp[n + 1]);

    }
}
