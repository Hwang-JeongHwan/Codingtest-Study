package week10_TwoPointer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class G3_20366_같이_눈사람_만들래 {
    static FastReader scan = new FastReader();
    static int n;
    static int[] arr;
    static long min = 1000_000_000L;
    static long max = 0;
    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void solution(){
        Arrays.sort(arr, 1, n + 1);
        int start, end;
        long sum = 0, sumInner;
        // 4개씩 봐야하니까 n - 3까지, n = 600 -> n^3 가능
        for(int left = 1; left <= n - 3; left++) {
            for (int right = left + 3; right <= n; right++) {
                start = left + 1;
                end = right - 1;
                sum = arr[left] + arr[right];
                while (start < end) {
                    sumInner = arr[start] + arr[end];
                    min = Math.min(min, Math.abs(sum - sumInner));
                    if (sumInner > sum) {
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
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
