package week7_BinarySearch;
import java.util.*;
import java.io.*;
public class S2_2805_나무자르기 {
    static int[] trees;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = 0, start = 0, end = 0, mid = 0;
        long total = 0;
        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > end){
                end = trees[i];
            }
        }
        Arrays.sort(trees);

        while(start <= end){
            mid = (start + end) / 2;
            total = 0;
            for(int i = 0; i < n; i++){
                if(trees[i] - mid > 0){
                    total += trees[i] - mid;
                }
            }
            if(total >= m){
                h = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
//        System.out.println(total);
        System.out.println(h);
    }
}
