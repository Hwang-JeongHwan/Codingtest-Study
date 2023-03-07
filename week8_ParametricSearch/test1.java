package week8_ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1 {
    static FastReader scan = new FastReader();
    static int[] arr;
    static int n;
    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }
    static int determination(int left, int right, int x){
        int candidate = right + 1, mid = 0;
        // left + 1 ~ right 까지 -arr[left] 이상의수중 가장 작은수 return 없으면 right + 1 return
        while(left <= right){
            mid = (left + right) / 2;
//            System.out.println(mid);
            if(arr[mid] >= x){
                candidate = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return candidate;
    }
    static void solution(){
        Arrays.sort(arr, 1, n + 1);
        int candidate = 0, num1 = 0, num2 = 0;
        int result = Integer.MAX_VALUE;
        for(int left = 1; left < n; left++){
            candidate = determination(left + 1, n, -arr[left]);

            // left + candidate - 1
            if(left < candidate - 1 && Math.abs(arr[left] + arr[candidate - 1]) < result){
                result = Math.abs(arr[left] + arr[candidate - 1]);
                num1 = arr[left];
                num2 = arr[candidate - 1];
            }

            // left + candidate
            if(candidate <= n && Math.abs(arr[left] + arr[candidate]) < result){
                result = Math.abs(arr[left] + arr[candidate]);
                num1 = arr[left];
                num2 = arr[candidate];
            }
        }
        System.out.println(num1 + " " + num2);
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
