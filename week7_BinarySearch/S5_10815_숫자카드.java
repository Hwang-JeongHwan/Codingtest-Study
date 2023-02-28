package week7_BinarySearch;
import java.util.*;
import java.io.*;
public class S5_10815_숫자카드 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            sb.append(binarySearch(0, n - 1, Integer.parseInt(st.nextToken())) + " ");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int start, int end, int target){
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(arr[mid] == target){
                return 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return 0;
    }
}