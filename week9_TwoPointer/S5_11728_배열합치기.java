package week9_TwoPointer;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class S5_11728_배열합치기 {
   static FastReader scan = new FastReader();
   static StringBuilder sb = new StringBuilder();
   static int[] A, B, C;
   static int n, m;
   static void input(){
      n = scan.nextInt();
      m = scan.nextInt();
      A = new int[n];
      B = new int[m];
      C = new int[n + m];
      for(int i = 0; i < n; i++){
         A[i] = scan.nextInt();
      }


      for(int i = 0; i < m; i++){
         B[i] = scan.nextInt();
      }
   }
   static void solution(){
      int indexA = 0, indexB = 0;
      while(indexA < n && indexB < m){
         // 작은것을 sb에 append
         if(A[indexA] < B[indexB]){
            sb.append(A[indexA++] + " ");
         }
         else{
            sb.append(B[indexB++] + " ");
         }
      }
      // 위의 반복문이 끝나고 둘중 한 배열을 다 탐색했고 나머지 한 배열에 아직 탐색하지 못한부분들이 있을수 있으므로
      while(indexA < n){
         sb.append(A[indexA++] + " ");
      }
      while(indexB < m){
         sb.append(B[indexB++] + " ");
      }
      System.out.println(sb);
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