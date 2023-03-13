package week9_TwoPointer;
import java.io.*;
import java.util.*;
public class G5_22862_가장긴짝수_연속한부분수열_large {
    static FastReader scan = new FastReader();
    static int n, k;
    static int oddCount, evenCount = 1;
    static int[] arr;
    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }

    static int findOddCount(int x){
        if(x % 2 == 1){
            return oddCount + 1;
        }
        return oddCount;
    }
    static void solution(){
        int right = 0, result = 0;
        for(int left = 1; left <= n; left++){
            if(oddCount >= 1 && arr[left - 1] % 2 == 1){
                oddCount--;
            }
            // right를 늘릴수 있을때까지 늘리기
            while(right + 1 <= n && oddCount <= k){
                right++;
                if(arr[right] % 2 == 1){
                    oddCount++;
                }


            }
            result = Math.max(right - left + 1 -oddCount, result);
        }
        System.out.println(result);
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
