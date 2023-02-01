package week2_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class S4_18258_큐2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            if(first.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            if(first.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");

                }
                else{
                    sb.append(queue.peek() + "\n");
                }
            }
            if(first.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(queue.peekLast() + "\n");
                }
            }
            if(first.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(queue.poll() + "\n");
                }
            }
            if(first.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            if(first.equals("size")){
                sb.append(queue.size()+"\n");
            }

        }
        System.out.println(sb);
    }
}
