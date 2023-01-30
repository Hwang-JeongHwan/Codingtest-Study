package book_study;
import java.io.*;
import java.util.*;
public class S4_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer>queue = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        for(int i = 1; i < n + 1; i ++){
            queue.offer(i);

        }
        System.out.print("<");
        while(!queue.isEmpty()){
            for(int i = 1; i < k + 1; i ++){
                if(i == k){
                    int a = queue.poll();
                    if(queue.isEmpty()){
                        System.out.print(a);
                    }
                    else{
                        System.out.print(a + ", ");
                    }
                }
                else{
                    queue.add(queue.poll());
                }
            }
        }

        System.out.print(">\n");


    }
}
