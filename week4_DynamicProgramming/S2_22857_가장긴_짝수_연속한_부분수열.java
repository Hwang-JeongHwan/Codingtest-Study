package week4_DynamicProgramming;
import java.util.*;
import java.io.*;

public class S2_22857_가장긴_짝수_연속한_부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[50001];
        int[] odd = new int[50001];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        odd[0] = arr[0] % 2 == 0? 0 : 1;
        // 1 2 3 4 5 6 7 8
        // 1 1 2 2 3 3 4 4
        for(int i = 1; i < n; i++){
            if(arr[i] % 2 == 0){
                odd[i] = odd[i - 1]; // 짝수인 경우 odd[i - 1]
            }
            else{
                odd[i] = odd[i - 1] + 1; // 홀수인 경우 odd[i - 1] + 1

            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            int l = 0, r = i;
            while(l <= r){
                int mid = (l + r) / 2;
                int count;
                if(mid == 0){
                    count = odd[i];
                }
                else{
                    count = odd[i] - odd[mid - 1];
                }
                if(count <= k){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }

            }
            int left = r + 1;
            if(left == 0){
                max = Math.max(max, i - left + 1 - odd[i]);
            }
            else{
                max = Math.max(max, i - left + 1 - (odd[i] - odd[r]));
            }

        }
        System.out.println(max);
    }
}
