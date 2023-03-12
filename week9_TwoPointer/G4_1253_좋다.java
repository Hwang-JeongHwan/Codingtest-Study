package week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1253_좋다 {
    static FastReader scan = new FastReader();
    static int n, count;
    static int[] arr;
    static void input(){
        n = scan.nextInt();
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solution(){
        Arrays.sort(arr, 1, n + 1);
        int left, right, sum;
        for(int target = 1; target <= n; target++){
            left = 1;
            right = n;
            sum = 0;
            while(left < right){
                // index가 같으면 안됨
                while(left == target && left + 1 <= n){
                    left++;
                }
                while(right == target && right - 1 >= 1){
                    right--;
                }

                if(left >= right){
                    break;
                }
                sum = arr[left] + arr[right];

                if(sum == arr[target]){
                    count++;
                    break;
                }
                else if(sum < arr[target]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        System.out.println(count);
    }
    static boolean func(int targetIndex){
       //targetIndex 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
        int left = 1, right = n;
        int target = arr[targetIndex];
        while(left < right){
            if(left == targetIndex){
                left++;
            }
            else if(right == targetIndex){
                right--;
            }
            else{
                if(arr[left] + arr[right] == target){
                    return true;
                }
                else if(arr[left] + arr[right] < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return false;
    }
    static void solution2(){
        //최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(arr, 1, n + 1);
        int result = 0;
        for(int i = 1; i <= n; i++){
            if(func(i)){
                result++;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        input();
        solution2();
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
//3
//        0 0 1
//        정답: 0