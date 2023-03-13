package week9_TwoPointer;
import java.util.*;
import java.io.*;

public class S3_21921_블로그 {
    static FastReader scan = new FastReader();
    static int n, x;
    static int[] arr;
    static void input(){
        n = scan.nextInt();
        x = scan.nextInt();
        arr = new int [n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solution(){
        int left = 1, result = 0, len = 0, sum = 0;
        for(int right = 1; right <= n; right++){
            sum += arr[right];
            if(right - left + 1 > x){
                sum -= arr[left];
                left++;

            }
            if(result == sum){
                len++;
            }
            else if(result < sum){
                len = 1;
                result = sum;
            }
        }
        if(result == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(result);
            System.out.println(len);
        }
    }
    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
