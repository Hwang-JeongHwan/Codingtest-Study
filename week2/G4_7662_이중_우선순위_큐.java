package week2;

import java.io.*;
import java.util.*;

public class G4_7662_이중_우선순위_큐 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//
//        for (int i = 0; i < t; i++) {
//            int k = Integer.parseInt(br.readLine());
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
//
//            for (int j = 0; j < k; j++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                String s = st.nextToken();
//                int n = Integer.parseInt(st.nextToken());
//                if (s.equals("I")) {
//                    pq.add(n);
//                    reversePq.add(n);
//                } else {
//                    if (n == 1) {
//                        if (!reversePq.isEmpty()) {
//                            pq.remove(reversePq.poll());
//                        }
//                    }
//                    else {
//                        if (!pq.isEmpty()) {
//                            reversePq.remove(pq.poll());
//                        }
//                    }
//                }
//            }
//            if (pq.isEmpty()) {
//                sb.append("EMPTY\n");
//            } else {
//                sb.append(reversePq.poll()).append(" ").append(pq.poll());
//            }
//        }
//        System.out.println(sb);
        // Priority Queue 에서 remove가 O(n)만큼 걸리므로 시간초과
        // Tree map 을 사용하면 firstKey, lastKey메소드로 접근도 가능하고 정렬되어있음
        // remove O(logN)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int data = Integer.parseInt(st.nextToken());
                if(op.equals("I")){
                    treeMap.put(data, treeMap.getOrDefault(data, 0) + 1);

                }
                else{
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    int rnum = data == -1 ? treeMap.firstKey() : treeMap.lastKey();

                    // -1 이면 최소값, 아니면 최대값
                    if(treeMap.get(rnum) == 1){
                        treeMap.remove(rnum);
                        }
                    else{

                        treeMap.put(rnum, treeMap.getOrDefault(rnum, 0) - 1);
                    }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey() +"\n");
            }
        }
        System.out.println(sb);
    }
}