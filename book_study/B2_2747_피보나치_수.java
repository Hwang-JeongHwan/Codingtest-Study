package book_study;
import java.util.Scanner;
import java.util.Arrays;
public class B2_2747_피보나치_수 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        fibo(n);
        System.out.println(dp[n]);

    }
    public static int fibo(int n){
//        System.out.println(Arrays.toString(dp));
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fibo(n - 2) + fibo(n - 1);
    }
}
