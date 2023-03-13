package week9_TwoPointer;
import java.io.*;
import java.util.*;
public class S1_20922_겹치는건_싫어 {
    static FastReader scan = new FastReader();
    static int n, k;
    static int[] arr, count;

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        arr = new int[n + 1];
        count = new int[100001];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void solution(){
        int right = 0, result = 0;
        for(int left = 1; left <= n; left++){
            count[arr[left - 1]]--;
            // right를 옮기면 count[right]는 증가
            // right가 범위안에 있고 right를 옮겼을때 count <= k면 right를 옮김
            while(right + 1 <= n && count[arr[right + 1]] + 1 <= k){
                right++;
                count[arr[right]]++;

            }

            result = Math.max(result, right - left + 1);
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        input();
        solution();

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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