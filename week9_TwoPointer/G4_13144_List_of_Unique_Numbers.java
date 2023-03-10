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
        count = new int[100000 + 1];
        for(int i = 1; i <= n ; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solution(){
        int right = 0;
        long total = 0;
        for(int left = 1; left <= n; left++){
            //right를 옮길 수 있는 만큼 옮긴다
            // 다음 count배열의 arr의 다음 위치가 0 이면 옮길 수 있음
            while(right + 1 <= n && count[arr[right + 1]] == 0){
                right++;
                count[arr[right]]++;
            }
            // total을 갱신
            total += right - left + 1;

            //left를 옮겨주면서 count[arr[left]]를 1감소시킨다.
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
