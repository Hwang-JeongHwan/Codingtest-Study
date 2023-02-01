package week2_DataStructure;

import java.util.*;
import java.io.*;

public class S4_10866_덱 {
    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);

            }
            if(s.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);

            }
            if(s.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(deque.pollFirst() + "\n");
                }
            }
            if(s.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else {
                    sb.append(deque.pollLast() + "\n");
                }
            }
            if(s.equals("size")){
                sb.append(deque.size() + "\n");
            }
            if(s.equals("empty")){
                if(deque.isEmpty()){
                    sb.append("1 \n");
                }
                else{
                    sb.append("0 \n");
                }
            }
            if(s.equals("front")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekFirst() + "\n");
                }
            }
            if(s.equals("back")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekLast() + "\n");
                }
            }

        }
        System.out.println(sb);

    }
}
