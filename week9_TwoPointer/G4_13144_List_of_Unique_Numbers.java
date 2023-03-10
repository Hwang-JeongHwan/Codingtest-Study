package week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_13144_List_of_Unique_Numbers {
    static FastReader scan = new FastReader();
    static int n;
    static int[] arr;
    static int[] count;
    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        count = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solution(){
        int right = 0;
        long total = 0;
        for(int left = 1; left <= n; left++){
            while(right + 1 <= n && count[arr[right + 1]] == 0){
                right++;
                count[arr[right]]++;
            }
            total += right - left + 1;
            count[arr[left]]--;
        }
        System.out.println(total);
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
